package com.epam.rd.november2017.ui;

import com.epam.rd.november2017.MyArrayList;
import com.epam.rd.november2017.MyLinkedList;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

public class App {
    private MyArrayList<String> arrayList = new MyArrayList<>(String.class);
    private MyLinkedList<Integer> linkedList = new MyLinkedList<>();

    private enum Action {
        //ArrayList:
        toStringArrayList,
        addByIndexToArrayList,
        addToArrayList,
        getByIndexFromArrayList,
        removeByIndexFromArrayList,
        updateByIndexInArrayList,
        sizeOfArrayList,
        getCapacityOfArrayList,
        //LinkedList:
        toStringLinkedList,
        addByIndexToLinkedList,
        addFirstToLinkedList,
        addLastToLinkedList,
        getByIndexFromLinkedList,
        getFirstFromLinkedList,
        getLastFromLinkedList,
        removeByIndexFromLinkedList,
        removeFirstFromLinkedList,
        removeLastFromLinkedList,
        updateByIndexInLinkedList,
        sizeOfLinkedList
    }

    private void fillLists() {
        arrayList.add("Red");
        arrayList.add("Orange");
        arrayList.add("Yellow");
        arrayList.add("Green");
        arrayList.add("Blue");
        arrayList.add("Indigo");
        arrayList.add("Violet");

        linkedList.add(1, 0);
        linkedList.add(2, 1);
        linkedList.add(4, 2);
        linkedList.add(8, 3);
        linkedList.add(16, 4);
        linkedList.add(32, 5);
        linkedList.add(64, 6);
        linkedList.add(128, 7);
    }


    @Option(name = "-vA", usage = "value for ArrayList")
    private String valueForArrayList;

    @Option(name = "-iA", usage = "index for ArrayList")
    private int indexForArrayList;

    @Option(name = "-vL", usage = "value for LinkedList")
    private int valueForLinkedList;

    @Option(name = "-iL", usage = "index for LinkedList")
    private int indexForLinkedList;


    @Argument(usage = "action", required = true, metaVar = "action")
    private Action action;


    public static void main(String[] args) throws CmdLineException {
        new App().doMain(args);
    }

    private void doMain(String[] args) throws CmdLineException {
        fillLists();
        CmdLineParser parser = new CmdLineParser(this);
        if (args.length == 0) {
            System.out.println("Usage: ");
            parser.printUsage(System.out);
            return;
        } else {
            parser.parseArgument(args);
        }

        switch (action) {
            case toStringArrayList:
                System.out.println(arrayList.toString());
                break;
            case addByIndexToArrayList:
                arrayList.add(valueForArrayList, indexForArrayList);
                System.out.println("Modified array list: " + arrayList.toString());
                break;
            case addToArrayList:
                arrayList.add(valueForArrayList);
                System.out.println("Modified array list: " + arrayList.toString());
                break;
            case getByIndexFromArrayList:
                System.out.println("Element " + indexForArrayList + " = " + arrayList.get(indexForArrayList));
                break;
            case removeByIndexFromArrayList:
                System.out.println("Removed element: " + arrayList.remove(indexForArrayList));
                System.out.println("Modified array list: " + arrayList.toString());
                break;
            case updateByIndexInArrayList:
                System.out.println("Updated element: " + arrayList.update(valueForArrayList, indexForArrayList));
                System.out.println("Modified array list: " + arrayList.toString());
                break;
            case sizeOfArrayList:
                System.out.println("Array list size = " + arrayList.size());
                break;
            case getCapacityOfArrayList:
                System.out.println("Array list capacity = " + arrayList.getCapacity());
                break;
            case toStringLinkedList:
                System.out.println(linkedList.toString());
                break;
            case addByIndexToLinkedList:
                linkedList.add(valueForLinkedList, indexForLinkedList);
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case addFirstToLinkedList:
                linkedList.addFirst(valueForLinkedList);
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case addLastToLinkedList:
                linkedList.addLast(valueForLinkedList);
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case getByIndexFromLinkedList:
                System.out.println("Element " + indexForLinkedList + " = " + linkedList.get(indexForLinkedList));
                break;
            case getFirstFromLinkedList:
                System.out.println("First element = " + linkedList.getFirst());
                break;
            case getLastFromLinkedList:
                System.out.println("Last element = " + linkedList.getLast());
                break;
            case removeByIndexFromLinkedList:
                System.out.println("Removed element: " + linkedList.remove(indexForLinkedList));
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case removeFirstFromLinkedList:
                System.out.println("Removed element: " + linkedList.removeFirst());
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case removeLastFromLinkedList:
                System.out.println("Removed element: " + linkedList.removeLast());
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case updateByIndexInLinkedList:
                System.out.println("Updated element: " + linkedList.update(valueForLinkedList, indexForLinkedList));
                System.out.println("Modified linked list: " + linkedList.toString());
                break;
            case sizeOfLinkedList:
                System.out.println("Linked list size = " + linkedList.size());
                break;
            default:
                throw new AssertionError("No way!");
        }
    }
}
