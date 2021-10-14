import com.sun.xml.internal.ws.model.RuntimeModelerException;

public class Hilo extends Thread{

    public Hilo (Runnable runnable){
        super(runnable);
        System.out.println("Running...");
    }

    public static void main(String... args) {
        Runnable r = new Runnable();
        Hilo hilo = new Hilo(r);
        hilo.start();
    }
}