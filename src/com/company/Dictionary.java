package com.company;

/**
 * Created by Melisa on 08/10/2015.
 */
public interface Dictionary<T, V> {
    public void add(T key, V val);
    public void modify(T key, V new_val);
    public boolean isEmpty();
    public int getSize();
    public void remove(T key);
    public V get(T key);

}
