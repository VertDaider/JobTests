package util;

import org.apache.log4j.Logger;

public class MyLog {
    private static boolean isLogToConsole;

    public static void setLogToFile(boolean logToFile) {
        isLogToConsole = logToFile;
    }

    public static Logger getLogger() {
        if (isLogToConsole) {
            return Logger.getLogger("logConsole");
        } else {
            return Logger.getLogger("logFile");
        }
    }
}