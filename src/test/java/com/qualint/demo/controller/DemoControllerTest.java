package com.qualint.demo.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DemoControllerTest {

    @Autowired
    private DemoController controller;

    @BeforeEach
    void init() {
        controller.database.clear();
    }

    @Test
    void getList() {
        List<Integer> result = controller.getList();
        List<Integer> expect = Collections.emptyList();
        assertEquals(expect, result);
    }

    @Test
    void addNumber() {
        List<Integer> result = controller.addNumber(100);
        List<Integer> expect = new ArrayList<>();
        expect.add(100);
        assertEquals(expect, result);
    }

    @Test
    void editValue() {
        controller.addNumber(100);
        List<Integer> result = controller.editValue(15, 0);
        List<Integer> expect = new ArrayList<>();
        expect.add(15);
        assertEquals(expect, result);
    }

    @Test
    void delValue() {
        controller.addNumber(100);
        List<Integer> result = controller.delValue(0);
        List<Integer> expect = Collections.emptyList();
        assertEquals(expect, result);
    }

    @Test
    void twoSum() {
        controller.addNumber(1);
        controller.addNumber(2);
        controller.addNumber(2);
        controller.addNumber(3);

        List<Integer> result1  = controller.twoSum(3);
        List<Integer> expect1 = new ArrayList<>();
        expect1.add(0);
        expect1.add(1);
        assertEquals(expect1, result1);

        List<Integer> result2  = controller.twoSum(4);
        List<Integer> expect2 = new ArrayList<>();
        expect2.add(1);
        expect2.add(2);
        assertEquals(expect2, result2);

        List<Integer> result3  = controller.twoSum(5);
        List<Integer> expect3 = new ArrayList<>();
        expect3.add(2);
        expect3.add(3);
        assertEquals(expect3, result3);

    }
}