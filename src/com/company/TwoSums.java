package com.company;

import java.util.Arrays;

public class TwoSums {

        public static int[] twoSum(int[] nums, int target) {
            int[] a = null;
            for (int i = 0; i < nums.length; i++) {
                System.out.println(nums[i]);
                for (int j = 1; j < nums.length; j++) {
                    int b = nums[i];
                    int c = nums[j];
                    if(b+ c == target){
                         a = new int[]{i, j};
                         return a;
                    }
                }
            }
            return a;
        }

    public static void main(String[] args) {
            int[] a = {3,3};
            int[] b = twoSum(a, 6);
    System.out.println(""+ Arrays.toString(b));
    }
}
