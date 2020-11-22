package dataHandler.deserializers;

import com.fasterxml.jackson.databind.util.StdConverter;
import model.Account;
import repository.Repository;

import java.util.stream.Collectors;

public class StringToAccountConverter extends StdConverter<String, Account> {
    @Override
    public Account convert(String accountId) {
        return Repository.accounts.stream()
                .filter((account) -> account.getAccountId().toString().equals(accountId))
                .collect(Collectors.toList()).get(0);
    }
}
