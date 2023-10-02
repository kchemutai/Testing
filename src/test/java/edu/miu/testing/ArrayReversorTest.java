package edu.miu.testing;

import edu.miu.testing.service.ArrayFlattenerService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ArrayReversorTest {

    private ArrayReversor arrayReversor;

    private ArrayFlattenerService arrayFlattenerService = Mockito.mock(ArrayFlattenerService.class);

    @BeforeEach
    void setUp() {
        arrayReversor = new ArrayReversor(arrayFlattenerService);
    }

    @AfterEach
    void tearDown() {
        arrayReversor=null;
    }

    @Test
    public void testArrayReverserValidInput(){
        int[][] input = {{1, 3}, {0}, {4, 5, 9}};
        int[] flattened = {1, 3, 0, 4, 5, 9};
        Mockito.when(arrayFlattenerService.flattenArray(input)).thenReturn(flattened);

        int[] expected = {9,5,4,0,3,1};
        int[] actual=arrayReversor.reverseArray(input);

        Assertions.assertArrayEquals(expected, actual);
        Mockito.verify(arrayFlattenerService).flattenArray(input);
    }

    @Test
    public void testArrayReverserNullInput(){
        Mockito.when(arrayFlattenerService.flattenArray(null)).thenReturn(null);
        int[] actual=arrayReversor.reverseArray(null);

        Assertions.assertNull(actual);
    }
}