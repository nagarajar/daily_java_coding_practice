package initial.coding.practice;

import java.util.Scanner;

public class SumOfDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int num = sc.nextInt();
		int sum = 0, rem;
		
		while(num>0) {
			//1. Take last number
			rem = num % 10;
			//2. Do the sum
			sum = sum+rem;
			//3. Remove the last num
			num = num / 10;
			
		}
		
		System.out.println("Sum of digit : "+sum);
	}
}
