/** Using multi-dimensional array  **/

package org.example;

import java.lang.reflect.Array;

public class Array2 {
    public static void main (String args[]){
        int dims[] = new int[]{5,10,15}; // Um array com 5 elementos, onde cada elemento é um array com 10 elementos, onde cada um desses é um array com 15 ints.

        Object arr = Array.newInstance(Integer.TYPE, dims);

        Object arrobj = Array.get(arr, 3);
        Class cls = arrobj.getClass().getComponentType();
        System.out.println(cls);

        arrobj = Array.get(arrobj, 5);
        Array.setInt(arrobj, 10, 37);

        int arrCast[][][] = (int[][][]) arr;
        System.out.println(arrCast[3][5][10]);
    }
}
