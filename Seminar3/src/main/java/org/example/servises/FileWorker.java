package org.example.servises;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;

/**
 * Задание 1: Создайте класс Person с полями name и age. Реализуйте сериализацию и десериализацию этого класса в файл
 */
public interface FileWorker {
    ObjectMapper MAPPER = new ObjectMapper();

    static <T> void serializeObject(T object, String path) {
        try {
            MAPPER.configure(SerializationFeature.INDENT_OUTPUT, true);
            MAPPER.writeValue(new File(path), object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static <T> T deserializeObject(String path, Class<T> clazz) {
        try {
            File file = new File(path);
            return MAPPER.readValue(file, MAPPER.getTypeFactory().constructType(clazz));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
