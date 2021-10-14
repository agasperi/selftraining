import java.util.Scanner;

public class Fibonacci{
	public static void main(String... args){
		Scanner in = new Scanner(System.in);
		System.out.print("Indique el número inicial que desea para su sequencia fibonacci: ");
		int n = in.nextInt();
		if (n < 0){
			System.out.println("Error! el valor debe ser mayor a cero");
		}
		else{
			System.out.print("0");
			if(n == 1){
				System.out.print(" 1");
			}
			else{
				int t1 = 0;
				int t2 = 1;
				for (int i = 1; i <= n; ++i){
					System.out.print(" " + t2);
					int sum = t1 + t2;
					t1 = t2;
					t2 = sum;
				}
			}
		}
		in.close();
	}
}