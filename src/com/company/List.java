package com.company;

/**
 * Created by Melisa on 07/10/2015.
 */
public interface List<T> {
    public void add(T e);
    public int getSize();
    public T get(int id);
    public boolean isEmpty();
}
