package com.company;

import java.util.*;
import java.util.Stack;

/**
 * Created by Melisa on 06/10/2015.
 */
public class ArrayStack<T> implements com.company.Stack<T> {

    private Stack<T> stk;

    public ArrayStack() {
        stk = new Stack<T>();
    }

    /**
     * adds an element to the stack
     * @param e - type object
     */
    public void push(T e) {
//        if (nrElem == elems.length) {
//            resize();
//        }
//        elems[nrElem++] = e;
        stk.push(e);
    }

    /**
     * Resizes the stack in case it is full
     */
//    private void resize() {
//        Object[] temp = new Object[ 2 * elems.length ];
//        for ( int i = 0; i < elems.length; i++ ){
//            temp[i] = elems[i];
//        }
//        elems = temp;
//    }

    /**
     * returns an element from the front of the stack
     * @return element
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stk.pop();
    }

    /**
     * Returns true or false depending on whther the stack is empty
     * @return true or false
     */
    public boolean isEmpty() {
        return stk.isEmpty();
    }

    /**
     * Returns an element from thetop of the stack
     * @return element
     */
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stk.peek();
    }

    @Override
    public String toString() {
//        String stackk = "[ ";
//        if (stk.isEmpty()) {
//            return "";
//        } else {
//            for ( int i = 0; i <stk.size(); i++) {
//                stackk = stackk.concat(elems[i].toString());
//                stackk = stackk.concat(" ");
//            }
//            stackk = stackk.concat("]");
//            return stackk;
//        }
        return stk.toString();
    }

}
