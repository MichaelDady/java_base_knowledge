# Redis笔记
## Redis的集群策略
### 主从复制
#### 主从复制的特点 ：
* 集群里含有一个master节点与数个slave节点
* master节点主要负责数据库的写，在进行写的同时把数据的更改同步到每个slave节点，保证数据的一致性
* slave节点只负责读
* 一个slave节点只对应一个master节点，而一个master节点可能对应多个slave节点
#### 主从复制的工作机制：
当一个slave节点启动之后，会主动向master节点发送SYNC命令，master在接收到SYNC的命令之后会在后台保存快照与缓存保存快照这段时间的命令，
然后把保存的快照文件与缓存的命令同步发送给slave，slave在收到命令之后加载快照文件与缓存的执行命令。

### 哨兵 
#### 作用：监控redis系统的运行状况
#### 功能：
* 监控主数据库是否运行正常
* 当master节点出现故障的时候会自动的把slave节点升级成master节点
* 多哨兵模式运行的时候哨兵之前也会相互监控
* 多个哨兵可以监控一个数据库
#### 哨兵的工作机制
* 哨兵模式启动之后，会与要监控的master建立两个连接：
    * 一条连接用来订阅master的_sentinel_:hello 频道与获取其它监控该master节点的哨兵节点信息
    * 另一条定期向master发送INFO命令获取master本身的信息
* 与master建立连接之后，哨兵会执行如下三个操作：
    * 定期向master发送INFO命令
    * 定期向master的slave的_sentinel_:hello频道发送自己的信息
    * 定期向master，slave，其它的哨兵发送自己的信息
如果被PING的数据库或节点超时未回复，则哨兵认为其主观下线，如果下线的是master节点，则哨兵会向其它哨兵发送命令询问他们是否也认为此master
节点主观下线，如果达到一定的数目（可以配置），则哨兵会认为这个节点已经客观下线，并选举领头哨兵节点对主从系统发起故障恢复。

<br/>选取领头哨兵的raft算法：
*  发现master下线的哨兵节点（我们称他为A）向每个哨兵发送命令，要求对方选自己为领头哨兵
*  如果目标哨兵节点没有选过其他人，则会同意选举A为领头哨兵
*  如果有超过一半的哨兵同意选举A为领头，则A当选
*  如果有多个哨兵节点同时参选领头，此时有可能存在一轮投票无竞选者胜出，此时每个参选的节点等待一个随机时间后再次发起参选请求，进行下一轮投票精选，直至选举出领头哨兵

### 集群























