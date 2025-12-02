import java.util.Arrays;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {10, 77, 10, 54, -11, 10};
		System.out.println("Original Array: " + Arrays.toString(nums));
		int sumOfTens = 0;
		for (int n:nums) 
		{
			if (n==10) 
			{
			sumOfTens += 10;
			}		
		}
		boolean result = (sumOfTens == 30);
		System.out.println("Result: "+result); 
		
	}

}
