package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadAndWriter {

    public List<String> readFile(String path) {
        List<String> list = new ArrayList<>();

        try {
            InputStream input = new FileInputStream(path);
            Reader reader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line = bufferedReader.readLine();
            while (line != null){
                list.add(line);
                line = bufferedReader.readLine();
            }
            bufferedReader.close();

            return list;
        } catch (IOException e) {
            return null;
        }
    }

    public List<String> readFilesInPath() {
        String pathReader = "src/HOMEPATH/data/in";

        File file = new File(pathReader);
        String[] files = file.list();
        List<String> listFiles = new ArrayList<>();
        List<String> dataList = new ArrayList<>();

        if (files != null){
            listFiles.addAll(Arrays.asList(files));
            for (String fileNames : listFiles){
                List<String> dataRead = readFile(pathReader + "/" + fileNames);
                dataList.addAll(dataRead);
            }
            return dataList;
        }
        return null;
    }
}
