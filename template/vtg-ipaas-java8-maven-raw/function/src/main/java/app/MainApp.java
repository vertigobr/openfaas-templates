package app;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

public class MainApp {
    final static Logger logger = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        logger.info("Hello from MainApp");
        System.out.println("Hello from sysout, counting input:");
        int i=0;
        try {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader input = new BufferedReader(in);
            String str;
            while ((str = input.readLine()) != null) {
                i++;
            }
            if (i % 100 == 0) {
                System.out.println("100 lines counted");
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
