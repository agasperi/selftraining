public class MyString{
    public static void main(String... args) {
        String str1 = new String("hola");
        String str2 = new String("hola");
        String str3 = "hola";
        String str4 = "hola";

        System.out.print((str1 == str2) + " ");
        System.out.print(str3 == str4);
    }
}