package com.web.dragmetalcbr.parser.xml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public  class Metall {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<RecordMetal> Record = new ArrayList<RecordMetal>();

    public List<RecordMetal> getRecorde() {
        return Record;
    }
}



