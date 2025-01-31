package com.web.dragmetalcbr.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
public class TestSheduler {

    private DragMetalCBService dragMetalCBService;

    TestSheduler(DragMetalCBService dragMetalCBService) {
        this.dragMetalCBService = dragMetalCBService;
    }



/*    @Scheduled(cron = "0 33 21 * * *")
    public void testSheduler(){
        dragMetalCBService.saveDragMetal();
    }*/
}
