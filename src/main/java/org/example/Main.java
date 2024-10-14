package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] weight = {50, 120, 74, 60, 100, 82};
        int maxShipCargo = 135;

        List<int[]> result =  sitSailorToShipsDown(weight, maxShipCargo);
        for(int[] i:result) System.out.println(Arrays.toString(i));

//        System.out.println("Распределение маряков по весам в  лодки: ");
//        for (int i: weight) findMinDifBeetwinTwoSailors(weight, maxShipCargo);
    }

    public static List<int[]> sitSailorToShipsDown(int[] weight, int maxShipCargo){
        List<int[]> shipRows = new ArrayList<>();
        int [] tempShip = new int[2];
        int[] sortedWeight = Arrays.stream(weight).sorted().toArray();

        int min = 0;
        for (int i = sortedWeight.length - 1; i >=0 ; i--) {
            if(sortedWeight[min] + sortedWeight[i] <= maxShipCargo  && i != min) {
                if (i > min) {
                    shipRows.add(new int[]{sortedWeight[min], sortedWeight[i]});
                    min += 1;
                }
            }

            else shipRows.add(new int[]{sortedWeight[i], 0});


            }
        return shipRows;
        }




    private static int[] findMinDifBeetwinTwoSailors(int[] arr, int maxShipCargo) {
        int bestI =0, bestJ =0;
        int minDiff = maxShipCargo; String bestDoubleSailors ="";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int t = maxShipCargo - arr[i] - arr[j];
                if (arr[i] != arr[j] && t >= 0 && minDiff >= t) {
                    minDiff = t;
                    bestDoubleSailors = arr[i] + " " + arr[j];
                    bestI = i;
                    bestJ = j;
                    }
                }
        }
        arr[bestI] = 0;
        arr[bestJ] = 0;
        if(!bestDoubleSailors.equals(""))  System.out.println("Лодка " + bestDoubleSailors);
        return arr;
    }
}