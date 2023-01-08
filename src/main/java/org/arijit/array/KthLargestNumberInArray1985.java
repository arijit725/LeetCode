package org.arijit.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1985: Find the Kth Largest Integer in the Array
 *
 * My Note:
 * Looking at the problem, it looks like a simple heap based problem which is correct.
 * But as numbers are given in string, it can grow to any range, even beyond long.
 * So consider it as kind of bigint and implement the logic to compare two number.
 *
 * [Accecpted by Leetcode]
 * @author Arijit Ghosh
 */
public class KthLargestNumberInArray1985 {

    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> queue = new PriorityQueue<String>(
                new Comparator<String>() {
                    public int compare(String s1, String s2){
                        return compareVal(s1,s2);
                    }
                } );

        for(String n:nums){
            queue.add(n);
        }
        String val="";
        while(!queue.isEmpty() && k>0){
             val = queue.poll();

        }
        return val;
    }

    public int compareVal(String s1, String s2){
        if(s2.length()!=s1.length())
            return s2.length()-s1.length();//if length mismatch we have clear answer.
        int start = 0;
        while(start <s1.length() && s1.charAt(start)==s2.charAt(start)){
            start++;
        }
        if(start==s1.length())
            return 0; //all match
        int s1Val = s1.charAt(start) - '0';
        int s2Val = s2.charAt(start) - '0';
        return s2Val-s1Val;
    }


    public static void main(String ars[]){
        String[] nums = {"3","6","7","10"};
        int k = 4;
        KthLargestNumberInArray1985 solution = new KthLargestNumberInArray1985();
        String kth = solution.kthLargestNumber(nums,k);
        System.out.println(kth);
    }

}
