package ProblemSolving;

public class JavaArrayProblems {
	
	public static void sumOfAnArray(int[] arr) {
		int sum=0;
		for(int i : arr) {
			sum = sum +i;
		}
		System.out.println("Sum of an Array Is : "+sum);
	}
	
	public static void minValInArray(int[] arr) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i< arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		System.out.println("Min Value in an Array Is : "+min);
	}
	
	public static void maxValInArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("Max Value in an Array Is : "+max);
	}
	
	public static void secondMinInArray(int[] arr) {
		int min = Integer.MAX_VALUE;
		int sMin = Integer.MAX_VALUE;
		
		for(int i=0; i< arr.length; i++) {
			if(min > arr[i]) {
				sMin = min;
				min = arr[i];
			} else if(min != sMin && arr[i] < sMin) {
				sMin = arr[i];
			}
		}
		System.out.println("Min Value is  : "+min);
		System.out.println("Second Min value is  : "+sMin);
	}
	
	public static void secondMaxInArray(int[] arr) {
		int max = Integer.MIN_VALUE;
		int sMax = Integer.MAX_VALUE;
		
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i]) {
				sMax = max;
				max = arr[i];
			}else if(max != sMax && sMax < arr[i]) {
				sMax = arr[i];
			}
		}
		System.out.println("Max Vallue in Array Is : "+max);
		System.out.println("Second Max Value in Array Is : "+sMax);
	}
	
	public static void searchEleInArray(int[] arr, int ele) {
		for(int i=0; i< arr.length; i++) {
			if(arr[i] == ele) {
				System.out.println(ele +" Is found at "+i+" Index");
				break;
			}else {
				System.out.println("Given Element not found in the Array");
			}
		}
	}
	
	public static void moveZerosToRight(int[] arr) {
		int count =0;
		int len = arr.length;
		for(int i=0; i< len; i++) {
			if(arr[i] != 0)
				arr[count++] = arr[i];		
		}
		
		while(len > count)
			arr[count++] = 0;
		
		System.out.println("Print moveZerosToRight - Result :");
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	public static void moveZerosToLeft(int[] arr) {
		int count = arr.length-1;
		int len = arr.length-1;
		for(int i=len; i >= 0; i--) {
			if(arr[i] != 0)
				arr[count--] = arr[i];
		}
		
		while(count >= 0)
			arr[count--] = 0;
		
		System.out.println("Print moveZerosToLeft - Result :");
		for(int i : arr)
			System.out.print(i+" ");
	}
	
	public static int[] leftLeftAnArray(int[] arr) {
		int temp =arr[0];
		
		for(int i=0; i<arr.length-1; i++)
			arr[i] = arr[i+1];
		
		arr[arr.length-1] = temp;		
		return arr;
	}
	
	public static int[] rightRotateAnArray(int[] arr) {
		int last = arr.length-1;
		int temp = arr[last];
		
		for(int i = last; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = temp;
		
		return arr;
	}
	
	public static void main(String[] args) {		
		System.out.println("Java Array Problems...!");
		
		int[] arr = {4,5,1,3,2};
		System.out.println("Length of an Array Is : "+arr.length);
		
		sumOfAnArray(arr);
		minValInArray(arr);
		maxValInArray(arr);
		secondMinInArray(arr);
		secondMaxInArray(arr);
		searchEleInArray(arr,5);
		
		int[] arrZero = {5,0,1,4,0,3};
		moveZerosToRight(arrZero);
		moveZerosToLeft(arrZero);
		
		int noOfLeftPositions = 13;
		noOfLeftPositions = noOfLeftPositions % arr.length;
		for(int i=0; i< noOfLeftPositions ; i++  ) {
			arr = leftLeftAnArray(arr);
		}
		System.out.println();
		for(int i: arr) {
			System.out.print(i+" ");
		}
		
		int[] arrRight = {4,6,2,1,3};
		
		
		int noOfRightPositions = 13;
		noOfRightPositions = noOfRightPositions % arr.length;
		for(int i=0; i<= noOfRightPositions ; i++  ) {
			arrRight = rightRotateAnArray(arrRight);
		}	
		
		System.out.println("Right rotate of an Array : ");
		for(int i : arrRight) {
			System.out.print(i+" ");
		}
		
		
		

	}

}
