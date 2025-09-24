package com.josephhieu.dsa.stack;

import java.util.EmptyStackException;

public class StackImplementUsingArray {

    private int[] stack;
    private int top;
    private int capacity;

    public StackImplementUsingArray(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
        top = -1; // ban đầu stack rỗng
    }

    // Kiểm tra rỗng
    public boolean isEmpty() {
        return top == -1;
    }

    // Kiểm tra đầy
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Trả về số phần tử.
    public int length() {
        return top + 1;
    }

    public void push(int data) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        stack[++top] = data; // tăng top trước rồi gán giá trị.
    }

    // Lấy phần tử ra khỏi stack
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stack[top--];
    }

    // Xem phần tử trên cùng
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    // In stack từ top -> bottom
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top -> bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Demo
//    public static void main(String[] args) {
//        StackImplementUsingArray stack = new StackImplementUsingArray(5);
//
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//
//        stack.printStack(); // Stack (top -> bottom): 30 20 10
//        System.out.println("Peek: " + stack.peek()); // 30
//        System.out.println("Pop: " + stack.pop());   // 30
//        stack.printStack(); // Stack (top -> bottom): 20 10
//    }
}
