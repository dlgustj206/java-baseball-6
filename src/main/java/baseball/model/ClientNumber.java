package baseball.model;

import baseball.utils.ValidationError;
import baseball.utils.Validator;

public class ClientNumber {

    public ClientNumber() {}

    public void validateClientNumber(String number) {
        try {
            Validator.validateUserNumber(number);
        } catch (ValidationError e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
