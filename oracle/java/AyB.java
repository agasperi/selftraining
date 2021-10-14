class ClassA{
    public ClassA (int x){
        System.out.print("ClaseA-" + x);
    }
}

class ClassB extends ClassA{
    public ClassB (){
        super(6);
        System.out.print(" ClaseB-");
    }
}

public class AyB{
    public static void main(String... args) {
        ClassB objB1 = new ClassB();
        ClassB ojbB2;
        System.out.println ("FIN");
    }
}