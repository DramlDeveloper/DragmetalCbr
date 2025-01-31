package com.web.dragmetalcbr.parser.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public final class RecordMetal {
    @JacksonXmlProperty(localName = "Date", isAttribute = true)
    String date;
    @JacksonXmlProperty(localName = "Code", isAttribute = true)
     String code;
    @JacksonXmlProperty(localName = "Buy")
     String buy;
    @JacksonXmlProperty(localName = "Sell")
     String sell;

    public String getDate() {
        return date;
    }

    public String getCode() {
        return code;
    }

    public String getBuy() {
        return buy;
    }

    public String getSell() {
        return sell;
    }

    @Override
     public String toString() {
         return "RecordMetal [date=" + date + ", code=" + code+ ", buy=" + buy + ", sell=" + sell + "]";
     }
 }






