package com.zhuguang.test;

import com.zhuguang.common.IdWorker;

public class TestIds {

    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker();
        System.out.println("id:" + idWorker.nextId());
    }
}
