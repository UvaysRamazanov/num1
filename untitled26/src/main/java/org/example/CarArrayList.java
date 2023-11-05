package org.example;

import java.util.Arrays;

public class CarArrayList implements Car_interface{
    private Car[] array = new Car[10];
    private int size = 0;

    @Override
    public Car getIndex(int index) {
        checkIndex(index);
        return array[index];
    }

    @Override
    public void add(Car car) {
        increaseArray();
        array[size] = car;
        size++;
    }

    @Override
    public void add(Car car, int index) {
        increaseArray();
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException();
        }
            System.arraycopy(array, index, array, index+1, size-index);
        array[index] = car;
        size++;
    }

    @Override
    public boolean remove(Car car) {
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(car));
            return removeAt(i);
        }
        size--;
        return true;
    }

    @Override
    public boolean removeAt(int index) {
        checkIndex(index);
        System.arraycopy(array, index, array, index-1, size-index);
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        array = new Car[10];
        size = 0;
    }

    public void checkIndex(int index){
        if(index<0 || index > array.length){
            throw new IndexOutOfBoundsException();
        }
    }

    public void increaseArray(){
        if(size>=array.length) {
            array = Arrays.copyOf(array, array.length*2);
        }
    }
}
