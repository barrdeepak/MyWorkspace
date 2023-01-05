package com.workspace.demo.ds.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by deepak on 11/20/14.
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> cache = new HashMap();
        int min = coinChangeUtil(coins, amount, cache);
        System.out.println("cache = " + cache.keySet());
        return min;
    }

    public static int coinChangeUtil(int[] coins, int amount, Map<Integer, Integer> cache) {

        if (cache.containsKey(amount))
            return cache.get(amount);

        if (amount == 0)
            return 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] == amount) {
                cache.put(amount, 1);
                return 1;
            } else {
                if (amount - coins[i] > 0) {
                    int count = 1 + coinChangeUtil(coins, amount - coins[i], cache);
                     min = Integer.min(min, count);
                }
            }
        }
        cache.put(amount, min);
        return min;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        int minCoins = coinChange(coins, amount);
        System.out.println("minCoins = " + minCoins);

    }
}
