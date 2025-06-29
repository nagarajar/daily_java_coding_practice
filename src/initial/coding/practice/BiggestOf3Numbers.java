package initial.coding.practice;

import java.util.Scanner;

public class BiggestOf3Numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first number: ");
		int a = sc.nextInt();
		System.out.println("Enter second number: ");
		int b = sc.nextInt();
		System.out.println("Enter third number: ");
		int c = sc.nextInt();
		int ternary = a>=b && a>=c ? a : b>=a && b>=c ? b : c;
		System.out.println("Using ternary : "+ternary);
		int largest;
        if (a >= b && a >= c) {
            largest = a;
        } else if (b >= a && b >= c) {
            largest = b;
        } else {
            largest = c;
        }
        System.out.println("Using if else : "+largest);

		
	}
}
