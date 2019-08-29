package com.makun.database;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Created by makun
 * @Date 2018/9/18
 * 模仿mysql数据库中的B+树索引
 */
class BplusTree {
    BplusTree() {
        init();
    }

    /**
     * 聚集索引，内部封装了数据库内容
     */
    private Map<Integer, Map<Integer, TreeSet<Student>>> primaryIdx = new TreeMap<>();

    /**
     * 姓名列作为索引，封装了姓名到id的映射
     */
    private Map<String, List<Long>> nameIdx;

    /**
     * 编码列作为索引
     */
    private Map<String, TreeMap<String, List<CodeIdNode>>> codeIdx;

    /**
     * 树的度
     */
    private static final Integer BRANCH_NUM = 10;

    /**
     * 每一页的元素个数 （List长度）
     */
    private static final Integer PAGE_SIZE = 3;


    /**
     * 模仿向数据库中插入数据
     *
     * @param stu 插入的数据
     */
    void save(Student stu) {
        // 判断应该放到哪一页
        TreeSet<Student> destPage = getDestPage(stu.id);
        destPage.add(stu);
        // 如果已经构建了索引树，那么需要对索引树进行更新
        if (codeIdx != null) {
            addCodeIdxForData(stu);
        }
    }

    /**
     * 相当于 select * from student where id = #{primaryKey}
     *
     * @param primaryKey 查找记录的主键
     * @return 记录
     */
    Student select(Long primaryKey) {
        return selectById(primaryKey);
    }


    /**
     * 相当于delete from student where id = #{key}
     *
     * @param key 记录主键
     */
    void delete(Long key) {
        TreeSet<Student> destPage = getDestPage(key);
        for (Student stu : destPage) {
            if (stu.id.equals(key)) {
                destPage.remove(stu);
            }
        }
        // 如果已经构建了索引树，那么需要对索引树进行更新
        if (codeIdx != null) {
            addCodeIndex();
        }
    }

    /**
     * 为name列加索引，相当于
     * alter table student add index idx_name (name)
     */
    void addNameIndex() {
        nameIdx = new TreeMap<>();
        primaryIdx.forEach((Integer idxOne, Map<Integer, TreeSet<Student>> data) ->
                data.forEach((idxTwo, pageData) -> pageData.forEach(stu -> {
                    if (nameIdx.containsKey(stu.name)) {
                        nameIdx.get(stu.name).add(stu.id);
                    } else {
                        List<Long> list = new ArrayList<>();
                        list.add(stu.id);
                        nameIdx.put(stu.name, list);
                    }
                })));
    }

    /**
     * 通过name获取学生记录列表
     * 相当于 select * from student where name = #{name}
     *
     * @param name 查询姓名
     * @return 记录集合
     */
    List<Student> listByName(String name) {
        List<Student> result = new ArrayList<>();
        List<Long> primaryList = nameIdx.get(name);
        primaryList.forEach(primaryKey -> result.add(selectById(primaryKey)));
        return result;
    }

    /**
     * 为code列加索引，相当于
     * alter table student add index idx_code (code)
     */
    void addCodeIndex() {
        // 完成初始化
        codeIdx = new TreeMap<>();
        for (int i = 0; i < 10; i++) {
            TreeMap<String, List<CodeIdNode>> valueMap = new TreeMap<>();
            codeIdx.put("" + i, valueMap);
            for (int j = 0; j < 10; j++) {
                valueMap.put("" + i + j, new ArrayList());
            }
        }
        // 为索引树添加数据
        nameIdx = new TreeMap<>();
        primaryIdx.forEach((Integer idxOne, Map<Integer, TreeSet<Student>> data) ->
                data.forEach((idxTwo, pageData) -> pageData.forEach(this::addCodeIdxForData)));
    }

    /**
     * 类似 select * from student where code = #{code}
     *
     * @param code 输入code值
     * @return 查询集合
     */
    List<Student> listByCode(String code) {
        List<Student> result = new ArrayList<>();
        TreeMap<String, List<CodeIdNode>> valueMap = codeIdx.get(code.substring(0, 1));
        List<CodeIdNode> nodeList = valueMap.get(code.substring(0, 2));
        List<Long> filteredIdList = nodeList.stream().filter(m -> m.code.equals(code)).map(m -> m.id).collect(Collectors.toList());
        filteredIdList.forEach(id -> {
            Set<Student> studentSet = getDestPage(id);
            // 把获取页中与id一致的记录取出放入结果集合
            result.addAll(studentSet.stream().filter(m -> Objects.equals(m.getId(), id)).collect(Collectors.toList()));
        });
        return result;
    }

    /**
     * 类似于  select * from student where code like 'aa%';
     *
     * @param code 前缀匹配符号
     * @return 结果记录集合
     */
    List<Student> listByLikeCode(String code) {
        List<Student> result = new ArrayList<>();
        TreeMap<String, List<CodeIdNode>> valueMap = codeIdx.get(code.substring(0, 1));
        List<CodeIdNode> codeList = valueMap.get(code.substring(0, 2));
        // 从code获取的id集合去主键表查数据
        List<Long> filteredIdList = codeList.stream().filter(m -> m.code.startsWith(code)).map(m -> m.id).collect(Collectors.toList());
        filteredIdList.forEach(id -> {
            Set<Student> studentSet = getDestPage(id);
            // 把获取页中与id一致的记录取出放入结果集合
            result.addAll(studentSet.stream().filter(m -> Objects.equals(m.getId(), id)).collect(Collectors.toList()));
        });
        return result;
    }

    /**
     * 模拟覆盖索引
     * 类似 select id from student where code = #{code};
     * 这个时候就不必再去查找主键构建的树取数据了
     *
     * @param code 查询的编码
     * @return id集合
     */
    List<Long> listIdByCode(String code) {
        TreeMap<String, List<CodeIdNode>> valueMap = codeIdx.get(code.substring(0, 1));
        List<CodeIdNode> codeList = valueMap.get(code.substring(0, 2));
        List<Long> result = codeList.stream().filter(m -> m.code.equals(code)).map(m -> m.id).collect(Collectors.toList());
        return result;
    }

    private Student selectById(Long primaryKey) {
        TreeSet<Student> destPage = getDestPage(primaryKey);
        for (Student stu : destPage) {
            if (stu.id.equals(primaryKey)) {
                return stu;
            }
        }
        return null;
    }

    /**
     * 初始化数据
     */
    private void init() {
        for (int i = 0; i < BRANCH_NUM; i++) {
            primaryIdx.put(i * BRANCH_NUM * PAGE_SIZE, generateLeafNode(i));
        }
    }

    /**
     * 生成叶子节点数据集合
     *
     * @param num 划分页的主键值
     * @return 页数据集合
     */
    private Map<Integer, TreeSet<Student>> generateLeafNode(int num) {
        Map<Integer, TreeSet<Student>> result = new TreeMap<>();
        for (int i = 0; i < BRANCH_NUM; i++) {
            result.put(num * BRANCH_NUM * PAGE_SIZE + i * PAGE_SIZE, new TreeSet<>());
        }
        return result;
    }


    /**
     * 通过id获取记录所在页的记录集合
     *
     * @param primaryKey id
     * @return 记录集合
     */
    private TreeSet<Student> getDestPage(Long primaryKey) {
        Integer idxOne = (int) (primaryKey - primaryKey % (BRANCH_NUM * PAGE_SIZE));
        Map<Integer, TreeSet<Student>> dataMap = primaryIdx.get(idxOne);
        int idxTwo = (int) (primaryKey - primaryKey % PAGE_SIZE);
        return dataMap.get(idxTwo);
    }

    /**
     * 为一条数据添加code索引
     *
     * @param stu 数据记录
     */
    private void addCodeIdxForData(Student stu) {
        String codeIdxOne = stu.getCode().substring(0, 1);
        TreeMap<String, List<CodeIdNode>> valueMap = codeIdx.get(codeIdxOne);
        String codeIdxTwo = stu.getCode().substring(0, 2);
        valueMap.get(codeIdxTwo).add(new CodeIdNode(stu.getId(), stu.getCode()));
    }

    class CodeIdNode {
        Long id;
        String code;

        CodeIdNode(Long id, String code) {
            this.id = id;
            this.code = code;
        }
    }
}