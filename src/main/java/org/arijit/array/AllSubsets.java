package org.arijit.array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 78. Subsets
 * My Note: This is a simple problem to generate combination of all length for all element in array.
 * But here point to note is we are using recursive solution.
 * If we use to add result in list directly, we would require to first remove existing element and then add new element in each recursion.
 * To avoid that we are storing values in an array.
 *
 * [Verified in Leetcode]
 * @author Arijit Ghosh
 */
public class AllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        result.add(new ArrayList<>()); //base case

            for (int i = 0; i < nums.length; i++) {
                for (int r = 1; r <= nums.length; r++) {
                int values[] = new int[r];

                combination(nums, i, values, 0, r,result);
//                result.add(Arrays.asList(values));
            }

        }
        return result.stream().collect(Collectors.toList());
    }


    public void combination(int[] nums, int start, int[] values, int index, int r, Set<List<Integer>> result){
        if(index == r){
            System.out.println(Arrays.toString(values));
            List<Integer> list = new ArrayList<>();
             Arrays.stream(values).forEach(v->list.add(v));
             result.add(list);
            return;
        }
        for(int i=start;i<nums.length;i++){
            values[index]= nums[i];
            combination(nums, i+1, values,index+1, r,result);
        }

    }


    public static void main(String args[]){
        AllSubsets allSubsets = new AllSubsets();
        int[] nums = {1,2,3};
        System.out.println(allSubsets.subsets(nums));
    }
}
