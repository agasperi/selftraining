import java.util.Scanner;

public class Pyramid{
	public static void main(String... args){
		Scanner in = new Scanner(System.in);
		System.out.print("Indique el nivel de la pirámide: ");
		int n = in.nextInt();
		int k = 2*n - 2;
		for(int i=0; i<n; i++,k--){

			for(int j=0; j<k; j++){
				System.out.print(" ");
			}

			for(int j=0; j<=i; j++ ){
				System.out.print("* ");
			}

			System.out.println();
		}
		in.close();
	}
}