package com.epam.rd.november2017;

public interface List<T> {
    void add(T value, int index);

    T get(int index);

    T remove(int index);

    T update(T value, int index);

    int size();

    boolean isEmpty();

}
