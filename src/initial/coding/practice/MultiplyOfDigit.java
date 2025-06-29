package initial.coding.practice;

import java.util.Scanner;

public class MultiplyOfDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number : ");
		int num = sc.nextInt();
		int mult = 1, rem;
		
		while(num>0) {
			//1. Take last num
			rem = num % 10;
			//2. Multiply with it
			mult = mult * rem;
			//3. Remove that last num
			num = num / 10;
		}
		
		System.out.println("Multiply of number : "+mult);
	}

}
