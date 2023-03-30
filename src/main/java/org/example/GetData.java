package org.example;

import java.util.*;

public class GetData {

    public static String countCustomers(List<String> dataRead) {
        return "Total de clientes: " + count(dataRead, "002");
    }

    public static String countSellers(List<String> dataRead) {
        return "Total de vendedores " + count(dataRead, "001");
    }

    public static String moreExpansiveSalle(List<String> dataRead) {
        List<String> idList = FilterData.saleIdFilter(dataRead);
        List<Double> purchaseValue = FilterData.purchaseValueFilter(dataRead);

        Map<Double, String> mapList = new HashMap<>();
        for (int i = 0; i < idList.size(); i++) {
            mapList.put(purchaseValue.get(i), idList.get(i));
        }
        return "Id da venda mais cara: " + mapList.getOrDefault(Collections.max(purchaseValue), idList.toString());
    }

    public static String worstSeller(List<String> dataRead) {
        List<String> nameSeller = FilterData.worstSellerFilter(dataRead);
        List<Double> purchaseValue = FilterData.purchaseValueFilter(dataRead);

        Map<Double, String> mapList = new HashMap<>();
        for (int i = 0; i < nameSeller.size(); i++) {
            mapList.put(purchaseValue.get(i), nameSeller.get(i));
        }
        return "Pior vendedor: " + mapList.getOrDefault(Collections.min(purchaseValue), nameSeller.toString());
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
