package generic_utility;

public class ReverseNumAndString {
	public static void main(String[] args) {
	System.out.println("================Q->1======================");
	StringBuilder sb=new StringBuilder("Kunal");
	String ssp=sb.reverse().toString();
	System.out.println(ssp);
	System.out.println("=================Q->2======================");
	
	int n=5;
	printReverse(n);
	
	}
	public static void printReverse(int n) {
		if(n==1) {
			return;
		}
		System.out.println(n);
		printReverse(n-1);
	}
}
