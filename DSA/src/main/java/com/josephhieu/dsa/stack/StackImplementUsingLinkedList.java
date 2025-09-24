package com.josephhieu.dsa.stack;

import java.util.EmptyStackException;

public class StackImplementUsingLinkedList {

    // instance variables
    private ListNode top;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public StackImplementUsingLinkedList() {
        top = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void push(int data) {
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int result = top.data;
        top = top.next;
        length--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    public void printStack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        ListNode current = top;
        System.out.print("Stack (top -> bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

//    public static void main(String[] args) {
//        StackImplementUsingLinkedList stack = new StackImplementUsingLinkedList();
//        stack.push(10);
//        stack.push(15);
//        stack.push(20);
//
//        System.out.println(stack.peek());
//        stack.printStack();
//        stack.pop();
//        stack.printStack();
//    }
}
