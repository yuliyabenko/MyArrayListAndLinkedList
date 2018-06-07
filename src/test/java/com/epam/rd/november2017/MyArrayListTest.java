package com.epam.rd.november2017;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest<T> {

    private MyArrayList<String> myArrayList = new MyArrayList(String.class);
    private MyArrayList<String> arrayWithCapacity = new MyArrayList(String.class, 2);

    @Test
    void testConstructorWithCapacity() {
        assertEquals(2, arrayWithCapacity.getCapacity());
    }

    @Test
    void testAddMethod() {
        myArrayList.add("First value",0);
        myArrayList.add("Second value", 0);
        assertEquals(2, myArrayList.size());
        myArrayList.add("Third value", 2);
        assertEquals(3, myArrayList.size());
        myArrayList.add("Fourth value", 1);
        assertEquals(4, myArrayList.size());
        myArrayList.add("Fifth value", 3);
        assertEquals(5, myArrayList.size());
        myArrayList.add("Sixth value", 4);
        assertEquals(6, myArrayList.size());
        //wrong index, element will not be added
        myArrayList.add("Fourth value", 10);
        assertEquals(6, myArrayList.size());
    }

    @Test
    void testAddToAndMethod() {
        myArrayList.add("First value");
        assertEquals(1, myArrayList.size());
        myArrayList.add("Second value");
        assertEquals(2, myArrayList.size());
    }

    @Test
    void testGetMethod() {
        myArrayList.add("First value");
        assertEquals("First value", myArrayList.get(0));
        //wrong index, such element doesn't exists:
        assertEquals(null, myArrayList.get(10));
    }

    @Test
    void testRemoveMethod() {
        myArrayList.add("First value");
        myArrayList.add("Second value");
        myArrayList.add("Third value");
        myArrayList.add("Fourth value");
        myArrayList.add("Fifth value");
        myArrayList.add("Sixth value");
        assertEquals("First value", myArrayList.remove(0));
        assertEquals("Second value", myArrayList.remove(0));
        assertEquals("Third value", myArrayList.remove(0));
        assertEquals("Fourth value", myArrayList.remove(0));
        //wrong index, such element doesn't exists:
        assertEquals(null,myArrayList.remove(10));
    }

    @Test
    void testUpdateMethod() {
        myArrayList.add("First value");
        assertEquals("First value", myArrayList.update("Updated value", 0));
        //wrong index, such element doesn't exists:
        assertEquals(null, myArrayList.update("Updated value", 10));
    }

    @Test
    void testSizeMethod() {
        myArrayList.add("First value");
        assertEquals(1, myArrayList.size());
        myArrayList.add("Second value");
        assertEquals(2, myArrayList.size());
    }

    @Test
    void testIsEmptyMethod() {
        assertEquals(true, myArrayList.isEmpty());
        myArrayList.add("First value");
        assertEquals(false, myArrayList.isEmpty());
    }

    @Test
    void testToStringMethod() {
        myArrayList.add("First value");
        assertEquals("ArrayList{| Element 0 = First value |}", myArrayList.toString());
        myArrayList.add("Second value");
        assertEquals("ArrayList{| Element 0 = First value | Element 1 = Second value |}",
                myArrayList.toString());
    }

    //Initial capacity = 5. When we add 6th element, capacity grows in 2 times = 10
    @Test
    void testGetCapacityMethod() {
        assertEquals(5, myArrayList.getCapacity());
        myArrayList.add("First value");
        myArrayList.add("Second value");
        myArrayList.add("Third value");
        myArrayList.add("Fourth value");
        myArrayList.add("Fifth value");
        myArrayList.add("Sixth value");
        assertEquals(10, myArrayList.getCapacity());
    }
}