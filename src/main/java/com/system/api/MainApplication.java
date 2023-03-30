package com.system.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainApplication {
    public static void main(String[] args) throws InterruptedException {

        while (true) {
            List<String> finalData = new ArrayList<>();
            ReadAndWriter readAndWriter = new ReadAndWriter();

            List<String> dataRead = readAndWriter.readFilesInPath();

            finalData.add(GetData.countCustomers(dataRead));
            finalData.add(GetData.countSellers(dataRead));
            finalData.add(GetData.moreExpansiveSalle(dataRead));
            finalData.add(GetData.worstSeller(dataRead));

            readAndWriter.writerFile(finalData);

            TimeUnit.SECONDS.sleep(1);
        }
    }
}