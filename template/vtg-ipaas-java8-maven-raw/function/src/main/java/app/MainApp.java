package app;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MainApp {
    final static Logger logger = LogManager.getLogger(MainApp.class);

    public static void main(String[] args) {
        logger.info("Hello from MainApp");
        System.out.println("Hello from sysout");
    }
}
