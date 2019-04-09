package pl.training.bank.account;

import org.springframework.jdbc.support.GeneratedKeyHolder;

import java.util.Map;
import java.util.Optional;

public class SimpleKeyHolder extends GeneratedKeyHolder {

    private static final String ID_COLUMN = "id";

    public Optional<Long> getId() {
        Map<String, Object> entries = getKeys();
        if (entries == null) {
            return Optional.empty();
        }
        long key = (Integer) entries.get(ID_COLUMN);
        return Optional.of(key);
     }

}
