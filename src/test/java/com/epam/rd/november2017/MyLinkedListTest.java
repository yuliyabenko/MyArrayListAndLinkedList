package com.epam.rd.november2017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<String> myLinkedList = new MyLinkedList();

    @Test
    void testAddMethod() {
        myLinkedList.add("First value", 0);
        assertEquals(1, myLinkedList.size());
        myLinkedList.add("Second value", 0);
        assertEquals(2, myLinkedList.size());
        myLinkedList.add("Third value", 2);
        assertEquals(3, myLinkedList.size());
        myLinkedList.add("Third value", 1);
        assertEquals(4, myLinkedList.size());
    }

    @Test
    void testAddFirstMethod() {
        myLinkedList.addFirst("First value");
        assertEquals(1, myLinkedList.size());
        assertEquals("First value", myLinkedList.getFirst());
    }

    @Test
    void testAddLastMethod() {
        myLinkedList.addLast("First value");
        myLinkedList.addLast("Second value");
        assertEquals(2, myLinkedList.size());
        assertEquals("Second value", myLinkedList.getLast());
    }

    @Test
    void testGetMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        myLinkedList.add("Third value", 2);
        myLinkedList.add("Fourth value", 3);
        assertEquals("First value", myLinkedList.get(0));
        assertEquals("Second value", myLinkedList.get(1));
        assertEquals("Third value", myLinkedList.get(2));
        assertEquals("Fourth value", myLinkedList.get(3));
        //wrong index, such element doesn't exists:
        assertEquals(null, myLinkedList.get(10));
    }

    @Test
    void testGetFirstMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        assertEquals("First value", myLinkedList.getFirst());
    }

    @Test
    void testGetLastMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        assertEquals("Second value", myLinkedList.getLast());
    }

    @Test
    void testRemoveMethod() {
        myLinkedList.add("First value", 0);
        assertEquals("First value", myLinkedList.remove(0));
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        myLinkedList.add("Third value", 2);
        assertEquals("Second value", myLinkedList.remove(1));
    }

    @Test
    void testRemoveFirstMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        myLinkedList.add("Third value", 2);
        assertEquals("First value", myLinkedList.removeFirst());
    }

    @Test
    void testRemoveLastMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        myLinkedList.add("Third value", 2);
        assertEquals("Third value", myLinkedList.removeLast());
    }

    @Test
    void testUpdateMethod() {
        myLinkedList.add("First value", 0);
        assertEquals("First value", myLinkedList.update("Updated value", 0));
        myLinkedList.add("Second value", 1);
        assertEquals("Second value", myLinkedList.update("Updated value", 1));
        //wrong index, such element doesn't exists:
        assertEquals(null, myLinkedList.update("Updated value", 10));
    }

    @Test
    void testSizeMethod() {
        myLinkedList.add("First value", 0);
        myLinkedList.add("Second value", 1);
        assertEquals(2, myLinkedList.size());
        myLinkedList.add("Third value", 2);
        assertEquals(3, myLinkedList.size());
    }

    @Test
    void testIsEmptyMethod() {
        assertEquals(true, myLinkedList.isEmpty());
        myLinkedList.add("First value", 0);
        assertEquals(false, myLinkedList.isEmpty());
    }

    @Test
    void testToStringMethod() {
        myLinkedList.add("First value", 0);
        assertEquals("LinkedList{| Element 0 = First value |}", myLinkedList.toString());
        myLinkedList.add("Second value", 1);
        assertEquals("LinkedList{| Element 0 = First value | Element 1 = Second value |}",
                myLinkedList.toString());
    }
}