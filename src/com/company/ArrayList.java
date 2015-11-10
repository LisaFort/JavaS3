package com.company;

import Exceptions.EmptyList;

import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Melisa on 07/10/2015.
 */
public class ArrayList<T> implements List<T>{

//    private Object[] elems;
//
//    private int nrElems;

    private java.util.List<T> lst;

    public ArrayList() {
//        nrElems = 0;
//        elems = new Object[10];
        lst = new java.util.ArrayList<>();
    }

    /**
     * Adds an element in the back of the list
     * @param e - type object, element to be added
     */
    public void add(T e) {
//        if (nrElems == elems.length) {
//            resize();
//        }
//        elems[nrElems++] = e;
        lst.add(e);
    }

    /**
     * Resizes the list in case it gets full
     */
//    private void resize() {
//        Object[] temp = new Object [ 2 * elems.length ];
//        for ( int i = 0; i < elems.length; i++) {
//            temp[i] = elems[i];
//        }
//        elems = temp;
//    }

    /**
     * Returns the number of elements in the list
     * @return integer
     */
    public int getSize() {
        return lst.size();
    }

    /**
     * Returns and removes the element from the id
     * @param id - type integer
     * @return the element from id
     */
    public T get(int id) {
        if (isEmpty()) {
            throw new EmptyList("Empty list, cannot return ");
        }
        if (id >= lst.size()) {
            throw new RuntimeException("Out of range");
        }
        return lst.get(id);
    }

    /**
     * Returns true or false depending on whether the list is empty or not
     * @return true or false
     */
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    @Override
    public String toString() {
       return lst.toString();
    }

}
