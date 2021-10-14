import java.util.Scanner;

public class Solution {

    static boolean isAnagram(String a, String b) {
        if(a.length() == b.length()){
            String al = a.toLowerCase();
            String bl = b.toLowerCase();
            char[] aal = al.toCharArray();
            char[] abl = bl.toCharArray();
            for(int i = 0; i < a.length();i++){
                boolean encontroCoincidencia = false;
                for(int j = 0; j < b.length();j++){
                    if(aal[i] == abl[j]){
                        abl[j] = 0;
                        encontroCoincidencia=true;
                        break;
                    }
                }
                if(!encontroCoincidencia){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }

  public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
