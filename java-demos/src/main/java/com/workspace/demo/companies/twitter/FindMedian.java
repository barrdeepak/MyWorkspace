package com.workspace.demo.companies.twitter;

public class FindMedian {

    int[] arr = new int[100];
    int totalElements = 0;

    private void addElement(int n) {
        arr[n - 1]++;
        totalElements++;
    }

    private double getMedian() {
        if (totalElements % 2 == 0) {
            int medianPoint = totalElements / 2;
            int value1 = findNthElement(medianPoint);
            int value2 = findNthElement(medianPoint + 1);
            return (double) (value1 + value2) / 2;
        } else {
            return findNthElement(totalElements/2+1);
        }
    }

    private int findNthElement(int n) {
        int elementsSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            elementsSoFar +=arr[i];
            if(elementsSoFar>=n)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        FindMedian fm = new FindMedian();
        for(int i =0;i<1000000000;i++)
            fm.addElement(70);
        System.out.println("fm.totalElements = " + fm.totalElements);
        System.out.println("fm.getMedian() = " + fm.getMedian());
    }
}
