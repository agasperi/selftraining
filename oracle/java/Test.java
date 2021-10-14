class MiClase{
    public int valor;
}

public class Test{
    public static void main(String... args) {
        MiClase a1 = new MiClase();
        MiClase a2 = new MiClase();
        MiClase a3 = new MiClase();
        a1.valor = 150;
        a2.valor = 150;
        a3 = a2;
        if (a1 == a2) {System.out.println("UNO");}
        if (a1 == a3) {System.out.println("DOS");}
        if (a2 == a3) {System.out.println("TRES");}
    }
}