package loggerUtillity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtillity {

    //in aceasta clasa configuram metode pentru a loga informatii
    //ne trebuie o metoda care sa reprezinte inceputul unui test, finalul unui test, info, error

    private static Logger logger = LogManager.getLogger();

    public static void startTestCase(String testCase){
        logger.info("****** EXECUTION STARTED: "+testCase+" ******");
    }

    public static void finishTestCase(String testCase){
        logger.info("****** EXECUTION FINISHED: "+testCase+" ******");
    }

    public static void infoTest(String message){
        logger.info(message);
    }

    public static void errorTest(String message){
        logger.error(message);
    }
}
