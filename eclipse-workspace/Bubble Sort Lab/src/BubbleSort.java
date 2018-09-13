
public class BubbleSort {

	public static void sort(int[] nums)
	{
		int s;
		for (int i = 0; i < nums.length; i++)
		{
			for (int j = i; j < nums.length-1; j++)
			{
				if (nums[j] > nums[j+1])
				{
					s = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = s;
				}
			}
			for (int k = nums.length-1; k > i; k--)
			{
				if (nums[k-1] > nums[k])
				{
					s = nums[k-1];
					nums[k-1] = nums[k];
					nums[k] = s;
				}
			}
		}
	}
	
	public static void main(String[] args)
	{
		int[] nums = {4, 7, 2, 1, 9, 8};
		
		System.out.print("Initial array: ");
		for (int x = 0; x < nums.length; x++)
		{
			System.out.print(nums[x]);
		}
		
		BubbleSort.sort(nums);
		System.out.print("Sorted array: ");
		for (int y = 0; y < nums.length; y++)
		{
			System.out.print(nums[y]);
		}
	}
}
