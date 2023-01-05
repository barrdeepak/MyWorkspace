package com.workspace.demo.leetcode.others;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {

    List<Integer> products = new ArrayList<>();

    public ProductOfNumbers() {

    }

    public void add(int num) {
        if( num == 0)
            products.add(-1);
        else {
            int lastMultiplier = products.isEmpty() ? 1 : products.get(products.size() - 1);
            products.add(num * lastMultiplier);
        }
    }

    public int getProduct(int k) {
        if(products.size() == k)
            return Math.abs(products.get(k-1));
        int denominator = products.get(products.size() - k - 1);
        int product = products.get(products.size() - 1)/denominator;
        return Integer.max(product, 0);
    }


    public static void main(String[] args) {
        ProductOfNumbers pon = new ProductOfNumbers();
        pon.add(1);
        pon.add(2);
        pon.add(0);
        pon.add(5);
        pon.add(6);
        pon.add(7);
        pon.add(10);
        int product = pon.getProduct(7);
        System.out.println("product = " + product);
    }
}
