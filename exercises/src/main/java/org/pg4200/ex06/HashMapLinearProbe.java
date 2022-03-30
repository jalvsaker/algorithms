package org.pg4200.ex06;

import org.pg4200.les06.hash.MyHashMap;

import java.lang.reflect.Array;
import java.util.Objects;

public class HashMapLinearProbe<K, V> implements MyHashMap<K, V> {

    private final int M = 997;

    private class Entry{
        K key;
        V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] data = (Entry[]) Array.newInstance(Entry.class, M);

    private int size = 0;


    private int index(K key){
        int positive = key.hashCode() & 0x7f_ff_ff_ff;
        return positive % M;
    }

    @Override
    public void put(K key, V value) {
        Objects.requireNonNull(key);

        int index = index(key);

        for (int i = index; i < data.length; i++) {
            if (data[i] == null || data[i].key == key){
                if (data[i] == null) size++;
                data[i]= new Entry(key, value);
                return;
            }
        }

        for (int i = 0; i < index - 1; i++) {
            if (data[i] == null || data[i].key == key){
                if (data[i] == null) size++;
                data[i]= new Entry(key, value);
                return;
            }
        }
    }

    @Override
    public void delete(K key) {
        Objects.requireNonNull(key);

        int index = index(key);

        if (data[index] == null){
            return;
        }


        for (int i = index; i < data.length; i++){
            if (data[i].key == key){
                data[i].key = null;
                size--;
                return;
            }
        }

        for (int i = 0; i < index - 1; i++){
            if (data[i].key == key){
                data[i].key = null;
                size--;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        Objects.requireNonNull(key);

        int index = index(key);


        for (int i = index; i < data.length; i++){
            if (data[i] == null) return null;

            if (data[i] != null && data[i].key == key){
                return data[i].value;
            }
        }

        for (int i = 0; i < index - 1; i++) {
            if (data[i] == null) return null;

            if (data[i] != null && data[i].key == key){
                return data[i].value;
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return MyHashMap.super.isEmpty();
    }
}
