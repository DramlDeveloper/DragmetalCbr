package com.web.dragmetalcbr.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.web.dragmetalcbr.model.DragMetalCB;
import com.web.dragmetalcbr.parser.xml.Metall;
import com.web.dragmetalcbr.repositore.DragMetalRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RequiredArgsConstructor
@Service
public class DragMetalCBService {
/*    @Autowired
    private final DragMetalRepo repo;*/


    DateTimeFormatter CUSTOM_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDateTime dateTime = LocalDateTime.now();
    String resultDate = dateTime.format(CUSTOM_FORMAT);

    final String urlDragMetalCB = "https://www.cbr.ru/scripts/xml_metall.asp?date_req1=" + resultDate + "&date_req2=" + resultDate;
    ObjectMapper xmlMapper = new XmlMapper();
    Metall recordMetal;

    {
        try {
            recordMetal = xmlMapper.readValue(new URL(urlDragMetalCB).openStream(), Metall.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    BigDecimal buy = BigDecimal.valueOf(
                    Double.parseDouble(recordMetal.getRecorde().get(0).getSell().replace(',', '.')) * 0.9)
            .setScale(4, BigDecimal.ROUND_HALF_UP);
    BigDecimal sell = BigDecimal.valueOf(
                    Double.parseDouble(recordMetal.getRecorde().get(0).getSell().replace(',', '.')) * 1.1)
            .setScale(4, BigDecimal.ROUND_HALF_UP);

/*    @Scheduled(cron = "0 24 21 * * *")
    public DragMetalCB saveDragMetal() {
        DragMetalCB dragMetalCB = new DragMetalCB();
        dragMetalCB.setDate(dateTime);
        dragMetalCB.setCode(Integer.parseInt(recordMetal.getRecorde().get(0).getCode()));
        dragMetalCB.setBuy(buy);
        dragMetalCB.setSell(sell);
        return repo.save(dragMetalCB);
    }*/
}
