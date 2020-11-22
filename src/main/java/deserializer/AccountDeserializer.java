package deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import model.Account;

import java.io.IOException;
import java.util.UUID;

public class AccountDeserializer extends StdDeserializer<Account> {

    protected AccountDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Account deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        UUID accountId = UUID.fromString(node.get("accountId").asText());
        String displayName = node.get("displayName").asText();
        boolean suspended = node.get("suspended").asBoolean();

        return new Account();
    }
}
