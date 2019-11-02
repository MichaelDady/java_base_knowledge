//package com.makun.performance;
//
///**
// * @author Created by makun
// * @Date 2019-10-14
// */
//import com.sun.btrace.annotations.*;
//import static com.sun.btrace.BTraceUtils.*;
//
//@BTrace
//public class ThreadStart {
//    @OnMethod(clazz = "java.lang.Thread", method = "start")
//    public static void onnewThread(@Self Thread t) {
//        println("");
//        Threads.jstack(5);
//    }
//}
