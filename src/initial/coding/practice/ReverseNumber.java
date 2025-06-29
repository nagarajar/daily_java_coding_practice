package initial.coding.practice;

import java.util.Scanner;

public class ReverseNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int num = sc.nextInt();
		int rev = 0, rem;
		
		while(num > 0) {
			//1. Take last number
			rem = num % 10;
			//2. Add that number to first
			rev = rev * 10 +rem;
			//3. Remove that last number
			num = num/10;
		}
		
		System.out.println("Reversed number : "+ rev);
	}
}
