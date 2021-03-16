package com.newsum.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BucketSort implements Sortable{
  @Override
  public void sort(int[] ints) {
    List<Integer>[] buckets = new List[10];

    for (int i = 0; i < buckets.length; i++){
      buckets[i] = new ArrayList<Integer>();
    }

    // scattering phase
    for (int i = 0; i < ints.length; i++){
      buckets[hash(ints[i])].add(ints[i]);
    }

    // sorting phase
    for (List bucket : buckets){
      // Collections.sort uses adaptive merge sort
      Collections.sort(bucket);
    }

    // gathering phase
    int j = 0;
    // traverse all buckets
    for (int i = 0; i < buckets.length; i++){
      // traverse each array list in bucket
      for (int value : buckets[i]){
        ints[j++] = value;
      }
    }
  }

  private int hash(int value){
    return value / (int) 10;
  }
}
