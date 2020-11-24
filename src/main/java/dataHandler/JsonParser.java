package dataHandler;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JsonParser {
    public static <T> ArrayList<T> readFromFile(String filePath, Class<T> valueType) {
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, valueType);

        try {
            return objectMapper.readValue(new File(filePath), type);
        } catch (IOException e) {
            e.printStackTrace(System.out);
            System.out.println("Failed to read from json file.");
            System.exit(1);
        }
        throw new RuntimeException();
    }

    public static <T> void writeToFile(String filePath, T objects) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), objects);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
