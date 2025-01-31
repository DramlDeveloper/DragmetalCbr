package com.web.dragmetalcbr.controller;

import com.web.dragmetalcbr.controller.dto.response.DragMetalResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CbrDragMetalController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/drag")
    public ResponseEntity<DragMetalResponse> dragMetal(
            @RequestParam String date,
            @RequestParam String code,
            @RequestParam String bye,
            @RequestParam String sell
            ) {
        DragMetalResponse dragMetalResponse =  new  DragMetalResponse(date, code, bye, sell);
        return ResponseEntity.ok(dragMetalResponse);
    }
}
