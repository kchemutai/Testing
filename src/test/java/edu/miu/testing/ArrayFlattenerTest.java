package edu.miu.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayFlattenerTest {

    private ArrayFlattener arrayFlattener;

    @BeforeEach
    void setUp() {
        arrayFlattener = new ArrayFlattener();
    }

    @AfterEach
    void tearDown() {
        arrayFlattener=null;
    }

    @Test
    public void testArrayFlattenerWhenInputValid(){
        int[][] arrays = {{1, 3}, {0}, {4, 5, 9}};
        int[] expected = {1, 3, 0, 4, 5, 9};
        int[] actual = arrayFlattener.flattenArray(arrays);
        assertArrayEquals(expected, actual );
    }

    @Test
    public void testArrayFlattenerWhenInputNull(){
        int [] actual = arrayFlattener.flattenArray(null);
        assertNull(actual);
    }
}