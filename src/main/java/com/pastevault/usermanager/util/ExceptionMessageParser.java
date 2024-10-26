package com.pastevault.usermanager.util;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.dao.DataIntegrityViolationException;

public class ExceptionMessageParser {

    private static final String ERR_MESSAGE_SEPARATOR_WORD = "Detail:";

    public static String getDataIntegrityViolationExceptionMessage(DataIntegrityViolationException e) {
        String rootCauseMessage = NestedExceptionUtils.getMostSpecificCause(e).getMessage();

        int errMessageStartIndex = rootCauseMessage.indexOf(ERR_MESSAGE_SEPARATOR_WORD);
        if (errMessageStartIndex == -1) {
            return "Invalid data, data integrity violated";
        }

        String errorMessage = rootCauseMessage.substring(
                errMessageStartIndex + ERR_MESSAGE_SEPARATOR_WORD.length()
        );
        return errorMessage.replace("Key", "")
                .replace("(", "")
                .replace(")", "")
                .trim();
    }
}