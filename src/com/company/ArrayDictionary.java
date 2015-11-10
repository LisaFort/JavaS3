package com.company;

import Exceptions.EmptyDict;

import java.util.*;

/**
 * Created by Melisa on 08/10/2015.
 */
public class ArrayDictionary<T,V> implements Dictionary<T,V> {

//    private int MAXVAL = 5;
//
//    private Object[] keys;
//
//    private Object[] vals;
//
//    private int nrElems;
    private Map<T,V> dict;

    public ArrayDictionary() {
//        nrElems = 0;
//        keys = new Object[MAXVAL];
//        vals = new Object[MAXVAL];
        dict = new HashMap<>();
    }

    /**
     * Adds a pair key-value to the dictionary
     * @param key - type object
     * @param val - type object
     */
    public void add(T key, V val) {
//        if (nrElems == keys.length) {
//            resize();
//        }
//        if ( isEmpty() ) {
//            keys[nrElems++] = key;
//            vals[nrElems-1] = val;
//        } else {
//            int i = 0;
//            while ( (i < nrElems) && (keys[i] != key) ) {
//                i++;
//            }
//            if ( i == nrElems ) {
//                keys[nrElems++] = key;
//                vals[nrElems-1] = val;
//            }
//        }
        dict.put(key, val);

    }

    /**
     * Resizes the dictionary in case it is filled
     */
//    private void resize() {
//        Object[] tempkey = new Object[ 2 * keys.length ];
//        Object[] tempval = new Object[ 2 * vals.length ];
//        for ( int i = 0; i < keys.length; i++) {
//            tempkey[i] = keys[i];
//            tempval[i] = vals[i];
//        }
//        keys = tempkey;
//        vals = tempval;
//    }

    /**
     * Returns the number of elements in the dictionary
     * @return nrElems - int
     */
    public int getSize() {
        return dict.size();
    }

    /**
     * modifies the value in the dictionary corresponding to the key given, if it exists
     * @param key - type object
     * @param new_val - type object
     */
    public void modify(T key, V new_val) {
//        int j = -1;
//        for ( int i = 0; i < nrElems; i++) {
//            if (keys[i] == key) {
//                j = i;
//            }
//
//        }
//        if ( j > -1 ) {
//            vals[j] = new_val;
//        }
        dict.put(key,new_val);
    }

    /**
     * Returns true or false depending on whether the dictionary is empty
     * @return true or false
     */
    public boolean isEmpty() {
        return dict.isEmpty();
    }

    /**
     * Removes a key-value pair from the dictionary depending on the
     * @param key - type object, to find the pair to be deleted
     */
    public void remove(T key) {
//        int j = -1;
//        for ( int i =0; i < nrElems; i++) {
//            if ( keys[i] == key) {
//                j = i;
//            }
//        }
//        if ( j > -1) {
//            for (int i = j; i < nrElems - 1; i++) {
//                keys[i] = keys[i++];
//                vals[i] = vals[i++];
//            }
//            nrElems--;
//        }
        if (isEmpty() ) {
            throw new EmptyDict("Empty dictionary");
        }
        dict.remove(key);
    }

    /**
     *returns the value corresponding to the kay if the key given exists
     * @param key - type object
     * @return returns a value of type object
     */
    public V get(T key) {
//        int j = -1;
//        int i = 0;
//        for ( i = 0; i < nrElems; i++) {
//            if ( keys[i].equals((key))) {
//                j = i;
//            }
//        }
//        Object temp = new Object();
//        if ( j > -1) {
//            temp = vals[j];
//            return temp;
//        } else {
//            return null;
//        }
        return dict.get(key);
        //do we want to remove the element as well?

    }

    @Override
    public String toString() {
//        String dictt = "[ ";
//        if (nrElems == 0) {
//            return "";
//        } else {
//            for ( int i = 0; i < nrElems; i++) {
//                if ( i > 0) {dictt = dictt.concat(", ");}
//                dictt = dictt.concat(keys[i].toString());
//                dictt = dictt.concat(" : ");
//                dictt = dictt.concat(vals[i].toString());
//            }
//            dictt = dictt.concat(" ]");
//            return dictt;
//        }
        return dict.toString();
    }

}
