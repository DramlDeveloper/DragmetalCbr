package com.web.dragmetalcbr.controller.dto.response;



public class DragMetalResponse {

    private String date;
    private String code;
    private String bye;
    private String sell;

    public DragMetalResponse(String date, String code, String bye, String sell) {
        this.date = date;
        this.code = code;
        this.bye = bye;
        this.sell = sell;
    }

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public String getBye() {
        return bye;
    }

    public String getSell() {
        return sell;
    }
}