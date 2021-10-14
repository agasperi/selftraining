import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) <= 0 ? "No" : "Yes");
        char[] texto = A.toCharArray();
        texto[0] = Character.toUpperCase(texto[0]);
        String concatenado = new String(texto);
        texto = B.toCharArray();
        texto[0] = Character.toUpperCase(texto[0]);
        concatenado += " " + (new String(texto));
        System.out.println(concatenado);
    }
}
