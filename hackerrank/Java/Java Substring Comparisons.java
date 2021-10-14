import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
  
    public static String getSmallestAndLargest(String s, int k) {
        List<String> subString = new ArrayList<>();
        
        for(int i = 0; i <= s.length() - k; i++){
            subString.add(s.substring(i,i+k));
        }
        
        subString.sort(String::compareTo);
        
        return subString.get(0) + "\n" + subString.get(subString.size()-1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
