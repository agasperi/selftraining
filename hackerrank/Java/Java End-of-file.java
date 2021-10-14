import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numLineas = 0;
        while(sc.hasNext()){
            System.out.println(++numLineas + " " + sc.nextLine());
        }
        sc.close();
    }
}