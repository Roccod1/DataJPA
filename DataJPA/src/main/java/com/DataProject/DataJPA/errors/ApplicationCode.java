package com.DataProject.DataJPA.errors;

import com.DataProject.DataJPA.enumerates.FileFormatEnum;
import com.DataProject.DataJPA.enumerates.FileStatusEnum;
import com.DataProject.DataJPA.enumerates.UploadSourceEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ApplicationCode {
	
    OBJECT_ID_INVALID(101, "Invalid id"),
    OBJECT_NOT_FOUND(102, "Object not found"),
    OBJECT_INVALID(103, "Object not valid"),
    NEW_OBJECT_ID(104, "Object id must be null"),
    OBJECT_ALREADY_EXIST(105, "Object already exists"),
    DATE_TO_EMPTY(106, "End date must be not empty"),
    DATE_FROM_EMPTY(107, "Start date must be not empty"),
    STATUS_INVALID(108, "Invalid file status; it does not match with the following status types: " + FileStatusEnum.getValueString()),
    INVALID_FORMAT(109, "Invalid file format; it does not match with the following format types: " + FileFormatEnum.getValueString()),
    INVALID_SOURCE(109, "Invalid file source; it does not match with the following source types: " + UploadSourceEnum.getValueString()),
    INTERNAL_SERVER_ERROR(110, "Internal Server Error"),
    MOBILE_INVALID(111, "Mobile value invalid"),
    EMAIL_INVALID(112, "Email value invalid"),
    USERNAME_ALREADY_EXYST(113, "Username already exist"),
    EMAIL_ALREADY_EXIST(114, "Email already exist"),
    UNAUTHORIZED(115, "User Unauthorized"),
    USER_ROLE_NOT_EQUALS(116, "User Role must be not change"),
    INVALID_FILE_FORMAT(117, "File extension not allowed; it must be a text/plain.");


    private final int value;
    private final String description;

    ApplicationCode(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
