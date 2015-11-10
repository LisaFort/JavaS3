package com.company;

/**
 * Created by Melisa on 06/10/2015.
 */
public interface Stack<T> {
    public void push(T e);
    public T pop();
    public boolean isEmpty();
    public T top();
}
