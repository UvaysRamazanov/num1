package org.example;

import org.w3c.dom.Node;

public class CarLinkedList2 implements Car_interface{
    private Node first;
    private Node last;
    private int size = 0;
    @Override
    public Car getIndex(int index) {
        return getNode(index).value;
    }

    @Override
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first;
        } else {
            Node secondLast = last;
            Node last = new Node(secondLast, car, null);
            secondLast.next = last;
            last.previous = secondLast;
        }
        size++;
    }

    @Override
    public void add(Car car, int index) {
        checkIndex(index);
        if (index == size) {
            add(car);
            return;
        }
        Node nodeNext = getNode(index);
        Node nodePrevious = nodeNext.previous;
        Node newNode = new Node(nodePrevious, car, nodeNext);
        nodePrevious.next = newNode;
        nodeNext.previous = newNode;
        if (nodePrevious != null) {
            nodePrevious.next = newNode;
        } else {
            first = newNode;
        }
        size++;
    }

    @Override
    public boolean remove(Car car) {
        Node node = first;
        for (int i = 0; i < size; i++) {
            if (node.value.equals(car)) {
                return removeAt(i);
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    private static class Node {
        private Node previous;
        private Car value;
        private Node next;

        public Node (Node previous, Car value, Node next){
            this.previous = previous;
            this.value = value;
            this.next = next;
        }

    }

    private Node getNode (int index){
        Node node = first;
        for (int i = 0; i < index; i++) {
            node=node.next;
        }
        return node;
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Вы ввели неверный индекс");
        }
    }
}
