package com.DataProject.DataJPA.enumerates;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum FileStatusEnum {
	
	//file caricato
    UPLOADED("UPLOADED", "file uploaded"),

    //file validato
    VALIDATED("VALIDATED", "file validated"),

    //file respinto
    REJECTED("REJECTED", "file rejected");

    private final String cod;
    private final String desc;

    FileStatusEnum(String cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public String getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }


    public static FileStatusEnum getFileStatusEnumByCode(String status) {
        for(FileStatusEnum s: FileStatusEnum.values()){
            if(s.getCod().equals(status.toUpperCase())) {
                return s;
            }
        }
        return null;
    }

    public static String getValueString(){
        return UPLOADED.cod + ", " +  VALIDATED.cod + ", " + REJECTED.cod;
    }

}
