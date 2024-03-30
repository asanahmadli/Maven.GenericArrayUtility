package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {

    T[] array;

    public ArrayUtility(T[] array) {
        this.array = array;
    }

    public <T, V> Integer countDuplicatesInMerge(T[] array1, V value) {
        Integer count = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i].equals(value)) {
                count++;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(value)) {
                count++;
            }
        }
        return count;
    }

    public <T> T getMostCommonFromMerge(T[] array1) {
        /**count repetition of character*/
        Integer count = 0;
        /**index help to fill array*/
        Integer index = 0;
        /**temp is holding temporary count*/
        Integer temp = 0;
        /**value will be the most repetition character*/
        T value = null;
        //create object type array and merge two array
        T[] arr = (T[]) new Object[array.length + array1.length];
        for (int i = 0; i < array.length; i++) {
            arr[i] = (T) array[i];
            index++;
        }

        for (int j = 0; j < array1.length; j++) {
            arr[index] = array1[j];
            index++;
        }

        //check most repetitive element in the array
        for (int m = 0; m < arr.length; m++) {

            for (int l = 0; l < arr.length; l++) {
                if (arr[m].equals(arr[l])) {
                    count++;
                }
            }
            if (temp < count) {
                temp = count;
                value = arr[m];
            }
            count = 0;
        }

        return value;
    }

    public <T> Integer getNumberOfOccurrences(T value1) {
        /**count repetition of character*/
        Integer count = 0;
        /**temp is holding temporary count*/
        Integer temp = 0;
        /**value will be the most repetition character*/
        T value = null;

        //check most repetitive element in the array
        for (int m = 0; m < array.length; m++) {
            if (array[m].equals(value1)) {
                count++;
            }
        }

        return count;
    }


    public <T> T[] removeValue(T value) {

        ArrayList<T> list = (ArrayList<T>) new ArrayList<>(Arrays.asList(array));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(value)) {
                list.remove(value);
            }
        }

        T[] result = (T[]) list.toArray((T[]) Array.newInstance(value.getClass(), list.size()));

        return result;
    }

}
