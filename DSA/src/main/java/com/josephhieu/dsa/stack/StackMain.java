package com.josephhieu.dsa.stack;

import java.util.Stack;

public class StackMain {

//    public static void main(String[] args) {
//
////        String str = "HIEU".toLowerCase();
////        System.out.println(reverseString(str));
//        String str = "{()}";
//        System.out.println(isValid1(str));
//
//    }

    // Valid Parentheses problem (Balanced Brackets)
    public boolean isValid1(String str) {

        char[] chars = str.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            if (chars[l] == chars[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }

        return true;
    }


    // Next Greater Element
    public int[] nextGreaterElement(int[] arr) {

        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return result;
    }

    // How to reverse a String using a Stack
    public String reverseString(String str) {

        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            stack.push(c);
        }

        for (int i = 0; i < str.length(); i++) {
            chars[i] = stack.pop();
        }

        return new String(chars);
    }
}
