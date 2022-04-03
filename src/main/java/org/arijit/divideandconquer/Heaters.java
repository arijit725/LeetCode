package org.arijit.divideandconquer;

import java.util.Arrays;

/**
 * <pre>
 * Winter is coming! During the contest, your first job is to design a standard heater with a fixed warm radius to warm all the houses.
 *
 * Every house can be warmed, as long as the house is within the heater's warm radius range.
 *
 * Given the positions of houses and heaters on a horizontal line, return the minimum radius standard of heaters so that those heaters could cover all houses.
 *
 * Notice that all the heaters follow your radius standard, and the warm radius will the same.
 *
 *
 *
 * Example 1:
 *
 * Input: houses = [1,2,3], heaters = [2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 *
 * Input: houses = [1,2,3,4], heaters = [1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 * </pre>
 */
public class Heaters {

    public int findRadius(int[] houses, int[] heaters) {
        /*
				sort heaters
				Find closest heater from each house
				Max of closest numbers will be distance from heater
		*/
        Arrays.sort(heaters);
        int radius = Integer.MIN_VALUE;
        for(int house:houses){
            int close = findClosestNumber(heaters, house);

            radius = Math.max(radius, close);
        }
        return radius;
    }

    public int findClosestNumber(int[] heaters, int house){
        int high = heaters.length-1;
        int low = 0;
        while((high-low)>1){
            int mid = low + (high-low)/2;
            if(heaters[mid]>house)
                high = mid;
            else
                low = mid;

        }
        return Math.min(Math.abs(heaters[high]-house), Math.abs(heaters[low]-house));
    }

    public static void main(String args[]){
        int [] houses = {1,2,3,4};
        int[] heaters = {1,4};

        System.out.println("Test");
        Heaters h = new Heaters();
        int i = h.findRadius(houses, heaters);
        System.out.println("Radius: "+i);
    }

}
