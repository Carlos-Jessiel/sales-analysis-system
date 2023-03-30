package com.system.api;

import java.util.List;

public class FilterData {

    public static List<String> saleIdFilter(List<String> dataRead) {
        return dataSales(dataRead, 1);
    }

    public static List<String> worstSellerFilter(List<String> dataRead) {
        return dataSales(dataRead, 3);
    }

    public static List<Double> purchaseValueFilter(List<String> dataRead) {
        return dataRead.stream().filter(line -> {
            List<String> saleContent = List.of(line.split("ç"));
            return saleContent.get(0).startsWith("003");
        }).toList().stream().map(line -> {
            List<String> content1 = List.of(line.split("ç"));
            return content1.get(2);
        }).toList().stream().map(line -> {
            List<String> content2 = List.of(line.split("]"));
            return content2.get(0);
        }).toList().stream().map(line -> {
            List<String> content3 = List.of(line.split(","));
            double amount = 0.0;
            for (String value : content3){
                double result = Double.parseDouble(value.split("-")[1]) * Double.parseDouble(value.split("-")[2]);
                amount += result;
            }
            return amount;
        }).toList();
    }

    public static List<String> dataSales(List<String> dados, Integer valor){
        return dados.stream().filter(linha -> {
            List<String> idContent = List.of(linha.split("ç"));
            return idContent.get(0).startsWith("003");
        }).toList().stream().map(linha -> {
            List<String> idContent1 = List.of(linha.split("ç"));
            return idContent1.get(valor);
        }).toList();
    }
}
