package com.makun.data_struct;

/**
 * @author Created by makun
 * @Date 2018/5/22.
 */
public class DyArrayStack {
    private int top;
    private int capacity;
    private int[] array;

    public DyArrayStack() {
        capacity = 1;
        top = -1;
        array = new int[capacity];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isStackFull() {
        return top == capacity - 1;
    }

    public void push(int data) {
        if (isStackFull()) {
            doubleStack();
        }
        array[++top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("The array is empty!!");
            return top;
        } else {
            return array[top--];
        }
    }

    private void doubleStack() {
        int[] newArray = new int[capacity * 2];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
    }

}
