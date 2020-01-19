package com.makun.data_struct;

public class OrderList {
    public static void main(String[] args) {
        MyContainer myContainer = new MyContainer();

        myContainer.add(3);
        myContainer.add(1);
        myContainer.add(5);

        System.out.println(myContainer);
    }


    static class MyContainer {
        private int[] arr = new int[100];
        private int capacity = 0;
        public void add(int ele) {
            int i = capacity - 1;
            for (; i >= 0 && arr[i] > ele; i--) {
                arr[i + 1] = arr[i];
            }
            arr[i + 1] = ele;
            capacity++;
        }
    }
}
