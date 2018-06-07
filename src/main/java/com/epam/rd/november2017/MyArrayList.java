package com.epam.rd.november2017;

import java.lang.reflect.Array;

public class MyArrayList<T> implements List<T> {

    private int size;
    private int capacity;
    private int initialCapacity = 5;
    private T[] array;
    private Class<T> cls;

    public MyArrayList(Class<T> cls) {
        this.cls = cls;
        array = (T[]) Array.newInstance(this.cls, initialCapacity);
        capacity = array.length;
    }

    public MyArrayList(Class<T> cls, int capacity) {
        initialCapacity = capacity;
        this.cls = cls;
        this.capacity = capacity;
        array = (T[]) Array.newInstance(this.cls, capacity);
    }

    @Override
    public void add(T value, int index) {
        if (index == size && index != 0) {
            add(value);
            return;
        }
        if (index >= 0 && index <= size) {
            if (isFull()) {
                increaseSize();
            }
            if (size == 1 && index == 0) {
                T temp = array[index];
                array[index] = value;
                array[index + 1] = temp;
                size++;
            } else {
                for (int i = size; i > index - 1; i--) {
                    array[i + 1] = array[i];
                }
                array[index] = value;
                size++;
            }
        }
    }

    public void add(T value) {
        if (isFull()) {
            increaseSize();
        }
        array[size++] = value;
    }

    private boolean isFull() {
        return size == array.length - 1;
    }

    private void increaseSize() {
        T[] temp = (T[]) Array.newInstance(this.cls, array.length * 2);
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;
    }

    @Override
    public T get(int index) {
        if (isCorrectIndex(index)) {
            return array[index];
        }
        return null;
    }

    @Override
    public T remove(int index) {
        if (isCorrectIndex(index)) {
            T removedValue = array[index];
            array[index] = null;
            for (int i = index + 1; i < size; i++) {
                array[i - 1] = array[i];
            }
            array[--size] = null;
            if (array.length > initialCapacity && size < array.length * 0.5) {
                reduceSize(capacity / 2);
            }
            return removedValue;
        }
        return null;
    }

    @Override
    public T update(T value, int index) {
        if (isCorrectIndex(index)) {
            T oldValue = array[index];
            array[index] = value;
            return oldValue;
        }
        return null;
    }

    private boolean isCorrectIndex(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Incorrect index [" +
                    index + "]. Element with such index doesn't exist!");
            return false;
        }
        return true;
    }

    private void reduceSize(int newLength) {
        T[] temp = (T[]) Array.newInstance(this.cls, newLength);
        System.arraycopy(array, 0, temp, 0, newLength);
        array = temp;
        capacity = newLength;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String result = "ArrayList{|";
        for (int i = 0; i < size; i++) {
            result += " Element " + i + " = " + array[i] + " |";
        }
        result += "}";
        return result;
    }

    public int getCapacity() {
        return array.length;
    }
}
