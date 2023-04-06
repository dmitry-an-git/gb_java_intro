import java.io.IOException;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;


public class logger_ex {
    public static void main(String[] args) throws IOException {
        Logger ll = Logger.getLogger(logger_ex.class.getName());
        String logsPath = "seminar03/logger_ex.txt";
        FileHandler fh = new FileHandler(logsPath, false);
        ll.addHandler(fh);
        SimpleFormatter sf = new SimpleFormatter();
        // XMLFormatter sf = new XMLFormatter();
        fh.setFormatter(sf);
        Random rand = new Random();
        for (int index = 0; index < 10; index++) {
            int a = rand.nextInt(10);
            ll.log(Level.INFO, "element "+a);
        }
        ll.log(Level.WARNING, "some warning");
        ll.info("some message");
        ll.warning("another warning but without using Level");

    }
}
