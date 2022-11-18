package com.techelevator.audit;

import java.io.*;
import java.sql.SQLOutput;

public class Audit implements Closeable {

    private File auditFile;
    private PrintWriter writer;

    public Audit(String pathName) {
        this.auditFile = new File (pathName);

        if (this.auditFile.exists()) {
            try {
                this.writer = new PrintWriter(new FileWriter(auditFile, true));
            } catch (IOException e) {
                System.out.println("Error opening this file.");;
            }
        }
        else {
            try {
                this.writer = new PrintWriter(this.auditFile);
            } catch (FileNotFoundException e) {
                System.out.println("Error opening this file.");
            }
        }
    }


    @Override
    public void close() throws IOException {
        this.writer.close();
    }

    public void write(String message) {
        this.writer.println(message);
        this.writer.flush();
    }

}
