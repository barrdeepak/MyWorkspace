package com.workspace.demo.ds.dp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Contract {
    String name;
    int startHour;
    int duration;
    int price;

    @Override
    public String toString() {
        return String.format("%s , %d, %d, %d", name, startHour, duration, price);
    }

    public Contract(String name, int startHour, int duration, int price) {
        this.name = name;
        this.startHour = startHour;
        this.duration = duration;
        this.price = price;
    }
}

public class SpaceshipRental {

    public static int latestNonConflict(Contract[] contracts, int i) {
        for (int j = i - 1; j >= 0; j--) {
            if (contracts[j].startHour + contracts[j].duration <= contracts[i - 1].startHour)
                return j;
        }
        return -1;
    }

    private static int latestNonConflictBinarySearch(Contract[] contracts, int i ) {
        int lo = 0, hi = i - 1;

        // Perform binary Search iteratively
        while (lo <= hi)
        {
            int mid = (lo + hi) / 2;
            if (contracts[mid].startHour + contracts[mid].duration  <= contracts[i-1].startHour)
            {
                if (contracts[mid + 1].startHour  + contracts[mid+1].duration  <= contracts[i-1].startHour)
                    lo = mid + 1;
                else
                    return mid;
            }
            else
                hi = mid - 1;
        }

        return -1;
    }

    public static int optimizeContracts(Contract[] contracts, int n, Set<Contract> finalSet) {
        if (n == 1) {
            finalSet.add(contracts[0]);
            return contracts[0].price;
        }
        int profitWithIncluded = contracts[n - 1].price;
        int j = latestNonConflict(contracts, n);

        if (j != -1)
            profitWithIncluded += optimizeContracts(contracts, j + 1, finalSet);
        int profitWithout = optimizeContracts(contracts, n - 1, finalSet);

        if (profitWithout < profitWithIncluded)
            finalSet.add(contracts[n - 1]);

        return Integer.max(profitWithout, profitWithIncluded);
    }

    public static int optimizeContractsDPTopDown(Contract[] contracts, int n, int[] cache) {
        if (n == 1) {
            return contracts[0].price;
        }

        if(cache[n-1] != -1)
            return cache[n-1];

        int profitWithIncluded = contracts[n - 1].price;
        int j = latestNonConflictBinarySearch(contracts, n);

        if (j != -1)
            profitWithIncluded += optimizeContractsDPTopDown(contracts, j + 1, cache);
        int profitWithout = optimizeContractsDPTopDown(contracts, n - 1, cache);

        cache[n-1] = Integer.max(profitWithout, profitWithIncluded);

        return cache[n-1];
    }



//    static int optimizeContractsDP(Contract[] contracts, int n) {
//        int[] cache = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (i == 0)
//                cache[i] = contracts[i].price;
//            else {
//                int inclProf = contracts[i].price;
//                int l = latestNonConflict(contracts, i);
//                if (l != -1)
//                    inclProf += cache[l];
//                cache[i] = Math.max(inclProf, cache[i - 1]);
//            }
//        }
//        return cache[n-1];
//    }

    public static void main(String[] args) {

//        Contract c1 = new Contract("Contract1", 0, 5, 10);
//        Contract c2 = new Contract("Contract2", 3, 7, 14);
//        Contract c3 = new Contract("Contract3", 5, 9, 8);
//        Contract c4 = new Contract("Contract4", 10, 9, 7);

        Contract c1 = new Contract("Contract1", 3, 7, 20);
        Contract c2 = new Contract("Contract2", 1, 1, 50);
        Contract c3 = new Contract("Contract3", 10, 13, 100);
        Contract c4 = new Contract("Contract4", 23 , 98, 200);

//        arr[0] = new Job(3, 10, 20);
//        arr[1] = new Job(1, 2, 50);
//        arr[2] = new Job(6, 19, 100);
//        arr[3] = new Job(2, 100, 200);


        Contract[] contracts = new Contract[]{c1, c2, c3, c4};
        int[] cache = new int[contracts.length];
        Arrays.fill(cache, -1);
        Arrays.sort(contracts, new Comparator<Contract>() {
            @Override
            public int compare(Contract c1, Contract c2) {
                return (c1.startHour + c1.duration) - (c2.startHour + c2.duration);
            }
        });

        Set<Contract> finalSet = new HashSet<>();
        int output = optimizeContracts(contracts, contracts.length, finalSet);

        int outputDP = optimizeContractsDPTopDown(contracts, contracts.length, cache);

        System.out.println("Optimized for profit...");
        System.out.println("output = " + output);
        System.out.println("outputDP = " + outputDP);

//        for (Contract c : finalSet)
//            System.out.println(c);

    }
}
