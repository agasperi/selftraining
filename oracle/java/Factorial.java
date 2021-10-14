import java.util.Scanner;

public class Factorial{

	static int factorial(int n){
		if (n == 0){
			return 1;
		}
		else{
			return(n * factorial(n-1));
		}
	}

	public static void main(String... args){
		Scanner in = new Scanner(System.in);
		System.out.print("Introduzca el número a consultar su factorial: ");
		System.out.println("Su número factorial es: " +
			String.valueOf(
				factorial(
					in.nextInt()
				)
			)
		);
		in.close();
	}
};