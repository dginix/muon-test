package com.example.muontest.util.json;

import com.example.muontest.model.Car;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CarSerializer extends JsonSerializer<Car> {

    @Override
    public void serialize(Car car, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", car.getId());
        jsonGenerator.writeStringField("driverName", car.getDriverName());
        jsonGenerator.writeStringField("brand", car.getBrand());

            jsonGenerator.writeFieldName("garage");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", car.getGarage().getId());
            jsonGenerator.writeStringField("name", car.getGarage().getName());
            jsonGenerator.writeEndObject();

        jsonGenerator.writeEndObject();
    }
}
