package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarSetTest {

    private CarSet carSet;

    @BeforeEach
    void setUp() {
        for (int i = 0; i < 100; i++) {
            Car car = new Car("Brand" + i, i);
            carSet.add(car);
        }
    }

   /* @Test
    void whenAdd3ElementsThenSizeIncreaseBy1() {
        for (int i = 0; i < 3; i++) {
            Car car = new Car("BMW", 1);
            carSet.add(car);
        }
        assertEquals(carSet.size(),101);
    }*/

    @Test
    void remove() {
    }

    @Test
    void size() {
    }

    @Test
    void clear() {
    }
}