import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int i = 0;
        int j = A.length()-1;
        
        for(; i<j; i++, j--){
            if(A.charAt(i) != A.charAt(j)){
                System.out.println("No");
                return;
            }
        }
        
        System.out.println("Yes");
    }
}
