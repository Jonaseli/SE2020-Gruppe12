package dataHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface JSONReadable<E> {

    default ArrayList<E> readFromFile(String filePath, Class<E[]> valueType){

        List<E> objects = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            E[] objectsArray = (objectMapper.readValue(new File(filePath), valueType));
            objects = Arrays.asList(objectsArray);
        } catch(IOException e) {
            e.printStackTrace(System.out);
        }
        return new ArrayList<>(objects);
    }

}
