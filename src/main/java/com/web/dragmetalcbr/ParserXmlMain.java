package com.web.dragmetalcbr;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.web.dragmetalcbr.model.DragMetalCB;
import com.web.dragmetalcbr.parser.xml.Metall;
import com.web.dragmetalcbr.repositore.DragMetalRepo;
import com.web.dragmetalcbr.service.DragMetalCBService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParserXmlMain {


    public static void main(String[] args) throws IOException {

        DateTimeFormatter CUSTOM_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDateTime dateTime = LocalDateTime.now();
        String resultDate = dateTime.format(CUSTOM_FORMAT);

        final String urlDragMetalCB = "https://www.cbr.ru/scripts/xml_metall.asp?date_req=" + resultDate + "&date_req2=" + resultDate;
        ObjectMapper xmlMapper = new XmlMapper();
        Metall recordMetal = xmlMapper.readValue(new URL(urlDragMetalCB).openStream(), Metall.class);


        for (int i = 0; i < recordMetal.getRecorde().size(); i++) {
            BigDecimal buy1 = BigDecimal.valueOf(
                            Double.parseDouble(recordMetal.getRecorde().get(i).getSell().replace(',', '.')) * 0.9)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            BigDecimal sell1 = BigDecimal.valueOf(
                            Double.parseDouble(recordMetal.getRecorde().get(i).getSell().replace(',', '.')) * 1.1)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
            String date = recordMetal.getRecorde().get(i).getDate();

            switch (recordMetal.getRecorde().get(i).getCode()) {
                case "1":
                    System.out.println("AU " + "buy: " + buy1 + " sell: " + sell1 + " " + date);
                    break;
                case "2":
                    System.out.println("AG " + "buy: " + buy1 + " sell: " + sell1 + " " + date);
                    break;
                case "3":
                    System.out.println("PT " + "buy: " + buy1 + " sell: " + sell1 + " " + date);
                    break;
                case "4":
                    System.out.println("PD " + "buy: " + buy1 + " sell: " + sell1 + " " + date);
                    break;
            }
        }
    }
}
