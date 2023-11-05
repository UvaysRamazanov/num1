package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Car_interfaceTest {
    List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Car car = new Car("Brand" + i, i);
            carList.add(car);
        }
    }

    @Test
    public void Checkingfor100elements (){
        assertEquals(carList.size(), 100);
    }

    @Test
    public void Checkingforaddition () {
        Car Toyota = new Car("Toyota", 101);
        carList.add(Toyota);
        assertEquals(carList.size(), 101);
    }

    @Test
    public void CheckingfordeletionObjects (){
        Car Toyota = new Car("Toyota", 101);
        carList.add(Toyota);
        assertEquals(carList.size(), 101);
        carList.remove(Toyota);
        assertEquals(carList.size(), 100);
    }

    @Test
    public void Checkingfordeletion (){
        carList.remove(99);
        assertEquals(carList.size(), 99);
    }

    @Test
    public void CheckingTheOperationOfTheMethodGet (){
        Car car = carList.get(0);
        assertEquals("Brand0", car.getBrand());
    }

    @Test
    public void CheckingForDeletionOfAllElements(){
        carList.clear();
        assertEquals(carList.size(), 0);
    }

    @Test
    public void insertInfoFirstPosition(){
        Car BMW = new Car("BMW", 1);
        carList.add(0, BMW);
        Car carFromList = carList.get(0);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertInfoMiddlePosition(){
        Car BMW = new Car("BMW", 1);
        carList.add(50, BMW);
        Car carFromList = carList.get(50);
        assertEquals("BMW", carFromList.getBrand());
    }

    @Test
    public void insertInfoLastPosition(){
        Car BMW = new Car("BMW", 1);
        carList.add(100, BMW);
        Car carFromList = carList.get(100);
        assertEquals("BMW", carFromList.getBrand());
    }
}