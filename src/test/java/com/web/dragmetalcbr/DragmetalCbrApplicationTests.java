package com.web.dragmetalcbr;

import com.web.dragmetalcbr.model.DragMetalCB;
import com.web.dragmetalcbr.repositore.DragMetalRepo;
import com.web.dragmetalcbr.service.DragMetalCBService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@SpringBootTest
class DragmetalCbrApplicationTests {

    @Test
    void contextLoads(@Autowired DragMetalRepo repo) {
        DragMetalCB cb = new DragMetalCB();
        LocalDateTime localDateTime = LocalDateTime.now();
        BigDecimal bigDecimal = BigDecimal.ZERO;

        cb.setDate(localDateTime);
        cb.setCode(1);
        cb.setSell(bigDecimal);
        cb.setBuy(bigDecimal);
        repo.save(cb);
    }

    @Test
    void saveXmlDragMetalCB(@Autowired DragMetalRepo repo) {
        DragMetalCB cb = new DragMetalCB();
        DragMetalCBService dragMetalCBService = new DragMetalCBService(repo);




    }

}
