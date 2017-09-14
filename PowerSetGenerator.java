package com.company.com.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ravneet on 6/3/17.
 */
public class PowerSetGenerator {

    public static void main(String[] args){
        PowerSetGenerator powerSetGenerator = new PowerSetGenerator();
        List<Integer> list = new ArrayList<Integer>();
        list.add(0);
        list.add(1);
        powerSetGenerator.printArrayList(powerSetGenerator.getPowerSet(list));
    }

    private  void printArrayList(List<List<Integer>> arrayList){
        for(List<Integer> currentList: arrayList){
            for(Integer currentInteger: currentList){
                System.out.print(" "+currentInteger);
            }
            System.out.println();
        }

    }


    public List<List<Integer>> getPowerSet(List<Integer> input){
        if(input == null){
            return null;
        }else if(input.size() == 0){
            List<List<Integer>> resultList = new ArrayList();
            List<Integer> emptySet = new ArrayList<>();
            emptySet.add(null);
            resultList.add(emptySet);
            return resultList;
        }
        else {
            Integer current = input.get(0);
            List<Integer> remainder = input.subList(1, input.size());
            // This method is called for O(n)times
            List<List<Integer>> powerSetForRemainder = getPowerSet(remainder);
            List<List<Integer>> powerSetIncludingCurrent = new ArrayList<>();
            // At every step there are 2^n power sets that are generated that we iterate through
            //
            for(List<Integer> set: powerSetForRemainder){
                List<Integer> newSetWithCurrent = new ArrayList<>();
                newSetWithCurrent.add(current);
                newSetWithCurrent.addAll(set);
                powerSetIncludingCurrent.add(newSetWithCurrent);
            }
            powerSetIncludingCurrent.addAll(powerSetForRemainder);
            return powerSetIncludingCurrent;
        }

    }
}
