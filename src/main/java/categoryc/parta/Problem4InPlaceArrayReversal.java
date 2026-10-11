package categoryc.parta;

import java.util.Arrays;

public class Problem4InPlaceArrayReversal {

    public static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] sample = {11, 22, 33, 44};
        System.out.println("Before: " + Arrays.toString(sample));
        reverseInPlace(sample);
        System.out.println(Arrays.toString(sample));
    }
}
