package practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //Calling
		
		int sum = add(20, 10); //30
		System.out.println(sum);
	    System.out.println(add(sum, sum));;
	    
	    add(2, 3, 6);
		
		
	}
	
	
	//method to add
	public static int add(int a, int b) // called - generic method
	{
		int c = a+b;
		return c;
		
	}
	
	public static int add(int a, int b, int s) // called - generic method
	{
		int c = a+b+s;
		return c;
		
	}
}
