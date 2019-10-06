package com.tericcabrel.passify.converters;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ContactNumberConverter implements AttributeConverter<String[], String> {

    private static final String SEPARATOR = "|";

    /**
     * Convert String[] to a String
     * with format red|green|blue|alpha
     */
    @Override
    public String convertToDatabaseColumn(String[] strings) {
        StringBuilder sb = new StringBuilder();
        int length = strings.length;
        for (int i = 0; i <length; i += 1) {
            sb.append(strings[i]);
            if ( i < length - 1) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    @Override
    public String[] convertToEntityAttribute(String s) {
        return s.split(SEPARATOR);
    }
}
