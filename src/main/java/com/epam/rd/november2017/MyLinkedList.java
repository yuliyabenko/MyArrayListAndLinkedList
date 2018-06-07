package com.epam.rd.november2017;

public class MyLinkedList<T> implements List<T> {

    private class Entry<T> {
        T value = null;
        Entry<T> previous = null;
        Entry<T> next = null;
    }

    private int size = 0;
    private Entry<T> first = null;
    private Entry<T> last = null;

    @Override
    public void add(T value, int index) {
        if (index >= 0 && index <= size) {
            if (isEmpty()) {
                addFirst(value);
            } else if (index == 0) {
                addFirst(value);
            } else if (index == size) {
                addLast(value);
            } else {
                Entry<T> temp = first;
                for (int i = 1; i <= index; i++) {
                    temp = temp.next;
                }
                Entry<T> newEntry = new Entry();
                newEntry.previous = temp.previous;
                newEntry.next = temp;
                temp.previous = newEntry;
                newEntry.value = value;
                if (newEntry.previous == null) {
                    first = newEntry;
                } else {
                    newEntry.previous.next = newEntry;
                }
                size++;
            }
        }
    }

    public void addFirst(T value) {
        if (isEmpty()) {
            first = new Entry();
            last = first;
            first.value = value;
        } else {
            Entry<T> temp = new Entry();
            temp.value = value;
            first.previous = temp;
            temp.next = first;
            first = temp;
        }
        size++;
    }

    public void addLast(T value) {
        if (isEmpty()) {
            first = new Entry();
            last = first;
            first.value = value;
        } else {
            Entry<T> temp = new Entry();
            temp.value = value;
            last.next = temp;
            temp.previous = last;
            last = temp;
        }
        size++;
    }

    @Override
    public T get(int index) {
        if (isCorrectIndex(index)) {
            if (IsStartFromBeginning(index)) {
                Entry<T> current = first;
                for (int i = 1; i <= index; i++) {
                    current = current.next;
                }
                return current.value;
            } else {
                Entry<T> current = last;
                for (int i = size - 2; i >= index; i--) {
                    current = current.previous;
                }
                return current.value;
            }
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

    public T getFirst() {
        return first.value;
    }

    public T getLast() {
        return last.value;
    }

    private boolean IsStartFromBeginning(int index) {
        return index < size / 2;
    }

    @Override
    public T remove(int index) {
        if (isCorrectIndex(index)) {
            T removedValue;
            Entry<T> current = first;
            if (size() == 1) {
                removedValue = first.value;
                size = 0;
                first = null;
                last = null;
                return removedValue;
            }
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            removedValue = current.value;
            Entry<T> next = current.next;
            Entry<T> previous = current.previous;
            if (previous == null) {
                first = next;
            } else {
                previous.next = next;
            }
            if (next == null) {
                last = previous;
            } else {
                next.previous = previous;
            }
            current.next = null;
            current.previous = null;
            size--;
            return removedValue;
        }
        return null;
    }

    public T removeFirst() {
        T removedValue = first.value;
        first = first.next;
        first.previous = null;
        size--;
        return removedValue;
    }

    public T removeLast() {
        T removedValue = last.value;
        last = last.previous;
        last.next = null;
        size--;
        return removedValue;
    }

    @Override
    public T update(T value, int index) {
        if (isCorrectIndex(index)) {
            Entry<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            T oldValue = current.value;
            current.value = value;
            return oldValue;
        }
        return null;
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
        Entry temp = first;
        String result = "LinkedList{| Element 0 = " + temp.value + " |";
        for (int i = 1; i < size; i++) {
            temp = temp.next;
            result += " Element " + i + " = " + temp.value + " |";
        }
        result += "}";
        return result;
    }
}
