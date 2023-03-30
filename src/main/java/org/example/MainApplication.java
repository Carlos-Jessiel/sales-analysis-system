package org.example;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {

        final String pathOut = "src/HOMEPATH/data/out/dataOut.txt";

        while (true) {
            List<String> finalData = new ArrayList<>();
            ReadAndWriter readAndWriter = new ReadAndWriter();

            List<String> dataRead = readAndWriter.readFilesInPath();

            finalData.add(GetData.countCustomers(dataRead));
            finalData.add(GetData.countSellers(dataRead));
        }
    }
}