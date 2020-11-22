package dataHandler.serializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.Account;

public class AccountToStringConverter extends StdConverter<Account, String> {
    @Override
    public String convert(Account account) {
        return account.getAccountId().toString();
    }
}
