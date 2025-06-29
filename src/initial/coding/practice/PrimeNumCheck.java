package initial.coding.practice;

import java.util.Scanner;

public class PrimeNumCheck {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number :");
		int num = sc.nextInt();
		
		boolean flag = true;
		
		if(num <= 1)
			flag = false;
		
		for(int i = 2; i <= num/2; i++) {
			if(num%i == 0) {
				flag = false;
				break;
			}
		}
		
		if(flag)
			System.out.println("Its prime number");
		else
			System.out.println("Its not prime number");
			
	}
}
