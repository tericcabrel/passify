package com.tericcabrel.passify.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter
public class UserCoordinateConverter implements AttributeConverter<Map, String> {

    @Override
    public String convertToDatabaseColumn(Map customerInfo) {
        if (customerInfo == null) {
            return null;
        }

        String customerInfoJson = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            customerInfoJson = objectMapper.writeValueAsString(customerInfo);
        } catch (final JsonProcessingException e) {
            // TODO add Logger -> logger.error("JSON writing error", e);
            System.out.println("JSON writing error : " +  e.getMessage());
        }

        return customerInfoJson;
    }

    @Override
    public Map convertToEntityAttribute(String coordinateJSON) {
        Map coordinate = null;

        if (coordinateJSON == null) {
            return null;
        }

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            coordinate = objectMapper.readValue(coordinateJSON, Map.class);
        } catch (final IOException e) {
            // TODO add Logger -> logger.error("JSON reading error", e);
            System.out.println("JSON reading error : " +  e.getMessage());
        }

        return coordinate;
    }
}


