import java.util.Scanner;

public class Primo{

	static boolean esPrimo(int n){
		if (n < 2){
			return false;
		}

		for (int i=2; i <= n/i; i++){
			if (n%i == 0) return false;
		}

		return true;
	}

	public static void main(String... args){
		Scanner in = new Scanner(System.in);
		System.out.print("¿A cuál número quiere everiguar si es primo o no: ");
		int n = in.nextInt();
		if(esPrimo(n)){
			System.out.println("El número es primo");
		}
		else{
			System.out.println("El número NO es primo");
		}
		in.close();
	}
}