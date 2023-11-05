package org.example;

import javax.swing.plaf.nimbus.NimbusStyle;

public class CarLinkedList implements Car_interface{
    private Node first;
    private Node last;
    private int size = 0;

    @Override
    public Car getIndex(int index) {
        return getNode(index).value;
    }

    @Override //Добавление нового элемента
    public void add(Car car) {
        if (size == 0) {
            first = new Node(null, car, null);
            last = first; // Если размер = 0, то создаем новый Node,
                          // который будет первым и последним элементом
        } else {
            Node secondLast = last; // Элемент secondLast - последний элемент
            last = new Node(secondLast, car, null); // Создаем новый элемент и устанавливаем очередность
            secondLast.next = last; // Элемент после secondLast - последний элемент
        }
        size++; //Увеличение переменной size на 1
    }

    @Override // Добавление элемента по индексу
    public void add(Car car, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(); // Проверка индекса, что он находиться в допустимых пределах
        }
        if (index==size) { // Если индекс равен размеру коллекции
            add(car);      // Вставка объекта в конец списка
            return;        // Вызван метод добавления нового элемента, который был написан ранее add
        }
        /* Получение ссылки Node,
           который лежит по заданному индексу */
        Node nodeNext = getNode(index);
        // Ссылка на предыдущий элемент
        Node nodePrevious = nodeNext.previous;
        // Очередность - nodePrevious, nodeNext
        /* Создание нового объекта, который нужно
           вставить между двумя ранее созданными
           объектами nodeNext и nodePrevious */
        Node newNode = new Node(nodePrevious, car, nodeNext);
        // Создали объект и установили очередность //
        nodePrevious.next = newNode;
        // Для nodePrevious след-щим устанавливаеться newNode
        nodeNext.previous = newNode;
        // Для nodeNext пре-щим устанавливаеться newNode
        // Очередность - nodePrevious, newNode, nodeNext
        if (nodePrevious!= null) {
            nodePrevious.next= newNode;
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
        Node node = getNode(index); // Элемент, который надо удалить
        Node nodeNext = node.next; // Следующий элемент
        Node nodePrevious = node.previous; // Предыдущий элемент

        if (nodeNext != null) {                 // Если следующий элемент не равен null
            nodeNext.previous = nodePrevious;   // то предыдущий элемент яв-ся последним
        } else {
            last = nodePrevious;                // Иначе последний элемент = предыдущий
        }

        if (nodePrevious != null) {
            nodePrevious.next = nodeNext;
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    // Метод, который возвращает Node по индексу
    private Node getNode (int index) {
        Node node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public static class Node{
        private Node previous;
        private Car value;
        private Node next;

        public Node(Node previous, Car value, Node next) {
            this.previous = previous;
            this.value = value;
            this.next = next;
        } // Конструктор для public void add(Car car) {}

        public Node(Node secondLast, Car car, Object o) {
        }

        public Node() {

        }
    }
}
