package dataHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public interface JSONWritable<E> {

    default void writeToFile(String filePath, ArrayList<E> objects) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), objects);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

}
