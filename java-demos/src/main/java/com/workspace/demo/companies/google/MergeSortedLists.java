package com.workspace.demo.companies.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MergeSortedLists {

  public static void main(String[] args) {

    List<Integer> list1 = Arrays.asList(1, 4, 7, 10, 12, 15);
    List<Integer> list2 = Arrays.asList(2, 4, 6, 9, 14, 19, 20, 25);
    List<Integer> output = mergeLists(list1, list2);
    UtilityFn.printList(output);
  }

  private static List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
    if (list1.isEmpty()) {
      return list2;
    }
    if (list2.isEmpty()) {
      return list1;
    }
    Iterator<Integer> iter1 = list1.iterator();
    Iterator<Integer> iter2 = list2.iterator();
    Integer v1 = iter1.next();
    Integer v2 = iter2.next();
    List<Integer> list = new ArrayList<>();

    do {
      if (v1 <= v2) {
        list.add(v1);
        if (iter1.hasNext()) {
          v1 = iter1.next();
        } else {
          list.add(v2);
          break;
        }
      } else {
        list.add(v2);
        if (iter2.hasNext()) {
          v2 = iter2.next();
        } else {
          list.add(v1);
          break;
        }
      }
    } while (iter1.hasNext() || iter2.hasNext());

    if (!iter1.hasNext()) {
      while (iter2.hasNext())
        list.add(iter2.next());
    }
    if (!iter2.hasNext()) {
      while (iter1.hasNext())
        list.add(iter1.next());
    }
    return list;
  }
}
