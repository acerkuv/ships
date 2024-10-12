package org.example;


public class Main {
    public static void main(String[] args) {

        int[] weight = {50, 120, 74, 60, 100, 82};
        int maxShipCargo = 135;

        System.out.println("Распределение маряков по весам в  лодки: ");
        for (int i: weight) findMinDifBeetwinTwoSailors(weight, maxShipCargo);
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