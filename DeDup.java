package com.citi.ticketautomation.main;

import java.util.Arrays;

import java.util.LinkedHashSet;

import java.util.Set;

public class DeDup {

               public int[] input = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25,

                                             43, 2, 1, 10000, 11, 16, 19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2,

                                             5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,

                                             3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10,

                                             6, 1, 8, 18, 4, 14, 13, 2, 11 };

               public static void main(String[] args) {

                             DeDup s1 = new DeDup ();

                              int[] output1 = retainInsertionOrder(s1.input);

                              System.out.println(" The Final output is ");

                              for (int i : output1) {

                                             System.out.print(" " + i);

                              }

                              

                              int[] output2 = removeDuplicate(s1.input);

                              System.out.println(" The Final output2 is " + output2.length);

                              for (int i : output2) {

                                             System.out.print(" " + i);

                              }

                              int[] output3 = sortedAndUniqueData(s1.input);

                              System.out.println(" The Final output3 is " + output3.length);

                              for (int i : output3) {

                                             System.out.print(" " + i);

                              }

               }

               public static int[] retainInsertionOrder(int[] args) {

                              Set set1 = new LinkedHashSet();

                              int j = 0;

                              int[] uniq = new int[args.length];

                              for (int i : args) {

                                             if (set1.add(i)) {

                                                            uniq[j++] = i;

                                             }

                              }

                              return Arrays.copyOf(uniq, j);

               }

               

               static int[] removeDuplicate(int withDuplicate[]) {

                              int[] c = new int[withDuplicate.length];

                              int counter = 0;

                              for (int i = 0; i < withDuplicate.length; i++) {

                                             boolean isDupliate = false;

                                             for (int j = 0; j < withDuplicate.length; j++) {

                                                            if (withDuplicate[i] == c[j]) {

                                                                           isDupliate = true;

                                                            }

                                             }

                                             if (!isDupliate) {

                                                            c[counter] = withDuplicate[i];

                                                            counter++;

                                             }

                              }

                              return Arrays.copyOf(c, counter);

               }

               public static int[] sortedAndUniqueData(int[] arr) {

                              /*

                              * Sorting the array to group the similar numbers together

                              */

                              Arrays.sort(arr);

                              

                              int i = 0;int j = 1;

                              int temp = 0;int count = 0;

                              int[] uniq = new int[arr.length];

                              while (j < arr.length) {

                                             if (arr[i] != arr[j]) {

                                                            if (arr[i] == temp) {

                                                                           uniq[count] = arr[j];

                                                                           count++;

                                                            } else {

                                                                           uniq[count] = arr[i];

                                                                           count++;

                                                                           uniq[count] = arr[j];

                                                                           count++;

                                                            }

                                                            temp = arr[j];

                                                            i++;j++;

                                             } else {

                                                            i = j;

                                                            j++;

                                             }

                              }

                              return Arrays.copyOf(uniq, count);

               }

}
