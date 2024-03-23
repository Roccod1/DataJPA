package com.DataProject.DataJPA.enumerates;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum UploadSourceEnum {
	
	//file caricato dal portale web
    WEBPORTAL("WEBPORTAL", "file uploaded by web portal"),

    //file caricato tramite invio di email
    EMAIL("EMAIL", "file uploaded by email");


    private final String cod;
    private final String desc;

    UploadSourceEnum(String cod, String desc) {
        this.cod = cod;
        this.desc = desc;
    }

    public String getCod() {
        return cod;
    }

    public String getDesc() {
        return desc;
    }


    public static UploadSourceEnum getFileSourceEnumByCode(String status) {
        for(UploadSourceEnum s: UploadSourceEnum.values()){
            if(s.getCod().equals(status.toUpperCase())) {
                return s;
            }
        }
        return null;
    }

    public static String getValueString() {
        return WEBPORTAL.cod + ", " + EMAIL.cod;
    }

}
