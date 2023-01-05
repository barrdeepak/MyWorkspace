package com.workspace.demo.ds.search;

import com.workspace.demo.ds.Util;

/**
 * Created by deepak on 11/20/14.
 */
public class BinarySearch {


    public static int search(int[] arr, int p, int q, int k) {

        if (p > q)
            return -1;

        int mid = (p + q) / 2;

        if (arr[mid] == k)
            return mid;
        else if (arr[mid] > k)
            return search(arr, p, mid - 1, k);
        else return search(arr, mid + 1, q, k);
    }

    public static void main(String[] args) {

        int[] sortedArray = Util.getSortedArray(10);

        for (int i : sortedArray)
            System.out.println("i = " + i);

        System.out.println("search(10) = " + search(sortedArray, 0, sortedArray.length - 1, 10));
        System.out.println("search(1) = " + search(sortedArray, 0, sortedArray.length - 1, 1));
        System.out.println("search(5) = " + search(sortedArray, 0, sortedArray.length - 1, 5));
        System.out.println("search(6) = " + search(sortedArray, 0, sortedArray.length - 1, 6));
        System.out.println("search(12) = " + search(sortedArray, 0, sortedArray.length - 1, 12));
        sortedArray[8] = sortedArray[8]+1;
        sortedArray[9] = sortedArray[9]+1;
        System.out.println("search(12) = " + search(sortedArray, 0, sortedArray.length - 1, 9));

    }


}
