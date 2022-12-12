import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
   
public class RuntimeLoggerInit {

    public static void main(String[] args) throws IOException {
        LogManager.getLogManager().readConfiguration(RuntimeLoggerInit.class.getResourceAsStream("/logging.properties"));
        Logger logger = Logger.getLogger(RuntimeLoggerInit.class.getName());
        logger.log(Level.WARNING, "Danger, Will Robinson!");
    }

}
