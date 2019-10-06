package com.tericcabrel.passify.converters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.io.IOException;
import java.util.Map;

@Converter
public class UserCoordinateConverter implements AttributeConverter<Map, String> {
    private static final Logger logger = LoggerFactory.getLogger(UserCoordinateConverter.class);

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
            logger.error("JSON writing error : " +  e.getMessage());
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
            logger.error("JSON reading error : " +  e.getMessage());
        }

        return coordinate;
    }
}


