package edu.miu.testing;

public class ArrayFlattener {
      public int [] flattenArray(int [][] arrays) {
          if(arrays == null) return null;
        //determine the size
        int size = 0;
        int j = 0;
        for (int[] array : arrays) {
            size += array.length;
        }

        //create array and add elements to it
        int[] flattened = new int[size];
        for (int[] array : arrays) {
            for (int i : array) {
                flattened[j++] = i;
            }
        }
        return flattened;
    }
}
