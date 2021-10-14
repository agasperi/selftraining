class Padre{}
class ClaseHija extends Padre{}
class ClaseHija2 extends Padre{}


public class MyHerencia{
    public static void main(String... args) {
        Padre b = new Padre();
        ClaseHija s = (ClaseHija) b;
       System.out.println("Ejecutando Aplicacion");
    }
}