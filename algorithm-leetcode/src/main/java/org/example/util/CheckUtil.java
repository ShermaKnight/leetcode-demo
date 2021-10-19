package org.example.util;

public class CheckUtil {

    public static boolean checkArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return true;
        } else if ((nums1 == null && nums2 != null) || (nums1 != null && nums2 == null)) {
            return false;
        }
        if (nums1.length != nums2.length) {
            return false;
        }
        int size = nums1.length;
        for (int i = 0; i < size; i++) {
            boolean exist = false;
            for (int j = 0; j < size; j++) {
                if (nums1[i] == nums2[j]) {
                    exist = true;
                    break;
                }
            }
            if (!exist) {
                return false;
            }
        }
        return true;
    }
}
