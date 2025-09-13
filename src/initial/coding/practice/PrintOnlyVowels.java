package initial.coding.practice;

public class PrintOnlyVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "12abc@#AO%ei56";
		
		//1. convert this into char array
		char[] c = s.toCharArray();
		
		for(int i=0; i<c.length; i++) {
			if(c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u' || c[i] == 'A' || c[i] == 'E' || c[i] == 'I' || c[i] == 'O' || c[i] == 'U') {
				System.out.println(c[i]+" ");
			}
		}

	}

}
