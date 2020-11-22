package deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import model.Account;
import model.ParkingSpot;

import java.io.IOException;

public class ParkingSpotDeserializer extends StdDeserializer<ParkingSpot> {

    public ParkingSpotDeserializer() {
        this(null);
    }

    public ParkingSpotDeserializer(Class<?> vc) {
        super(vc);
    }
    @Override
    public ParkingSpot deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        boolean handicap = node.get("handicap").booleanValue();
        boolean chargingStation = node.get("chargingStation").booleanValue();
        boolean available = node.get("available").booleanValue();

        int width = node.get("width").intValue();
        int length = node.get("length").intValue();
        int height = node.get("height").intValue();

        String postalCode = node.get("postalCode").asText();
        String city = node.get("city").asText();
        String streetAddress = node.get("streetAddress").asText();
        String streetNumber = node.get("streetNumber").asText();
        String pictureURL = node.get("pictureURL").asText();



        String owner = node.get("owner").asText();

        return new ParkingSpot(new Account(), handicap, chargingStation, available, width, length, height,
                postalCode, city, streetAddress, streetNumber, pictureURL);
    }
}
