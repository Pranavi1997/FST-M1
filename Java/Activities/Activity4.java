import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {34, 12, 9, 56, 1, 89, 23};
		System.out.println("Before Sorting: " + Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("After Sorting: " + Arrays.toString(arr));


	}

}
