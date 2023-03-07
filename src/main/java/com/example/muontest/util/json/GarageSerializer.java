package com.example.muontest.util.json;

import com.example.muontest.model.Car;
import com.example.muontest.model.Garage;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class GarageSerializer extends JsonSerializer<Garage> {

    @Override
    public void serialize(Garage garage, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", garage.getId());
        jsonGenerator.writeStringField("name", garage.getName());

        jsonGenerator.writeArrayFieldStart("cars");

        for (Car car : garage.getCars()) {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField("id", car.getId());
            jsonGenerator.writeStringField("driverName", car.getDriverName());
            jsonGenerator.writeStringField("brand", car.getBrand());
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}