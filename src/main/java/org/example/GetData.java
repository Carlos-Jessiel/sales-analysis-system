package org.example;

import java.util.Arrays;
import java.util.List;

public class GetData {

    public static String countCustomers(List<String> dataRead) {
        return "Total de clientes: " + count(dataRead, "002");
    }

    public static String countSellers(List<String> dataRead) {
        return "Total de vendedores " + count(dataRead, "001");
    }

    public static Integer count(List<String> dataRead, String id) {
        int count = 0;
        for (String dadosLido : dataRead) {
            if (filterLine(dadosLido).get(0).contains(id)) {
                count += 1;
            }
        }
        return count;
    }

    public static List<String> filterLine(String list) {
        return Arrays.asList(list.split("ç"));
    }
}
