package com.zfg.test.javatest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zfg on 2019/3/13
 */
public class SortTestTest1 {
    int[] ints;
    @Before
    public void setUp() throws Exception {
        ints = new int[]{5, 15, 3, 9, 10, 55, 13};
    }

    @Test
    public void bubbleSort() {
        SortTest.bubbleSort(ints);
    }
}