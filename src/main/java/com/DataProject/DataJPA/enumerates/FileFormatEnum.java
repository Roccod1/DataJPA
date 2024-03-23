package com.DataProject.DataJPA.enumerates;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FileFormatEnum {
	
	EDIFACT_PNRGOV("EDI", "file edifact pnr gov"),

    XML_PNRGOV("XML", "file xlm pnr gov"),

    UNKNOWN("UKN", "unknown file format");

    private final String cod;
    private final String desc;

    FileFormatEnum(String cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public String getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }


    public static FileFormatEnum getFileFormatEnumByCode(String status) {
        for(FileFormatEnum s: FileFormatEnum.values()){
            if(s.getCod().equals(status.toUpperCase())) {
                return s;
            }
        }
        return null;
    }

    public static String getValueString(){
        return EDIFACT_PNRGOV.cod + ", " + XML_PNRGOV.cod;
    }

}
