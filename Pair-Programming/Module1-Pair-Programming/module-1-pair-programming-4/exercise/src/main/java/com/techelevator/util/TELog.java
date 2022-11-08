package com.techelevator.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class TELog {

    public static void log(String message) {
        String auditPath = "exercise\\logs\\search.log";
        File teLogFile = new File(auditPath);
        try (PrintWriter writeToLog = new PrintWriter(new FileOutputStream(teLogFile, true))) {
            writeToLog.append(message).append("\n");
        }
        catch (FileNotFoundException e) {
            throw new TELogException(message);
        }
    }
}
