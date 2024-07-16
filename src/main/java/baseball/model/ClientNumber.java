package baseball.model;

import baseball.utils.ValidationError;
import baseball.utils.ClientNumberValidator;

public class ClientNumber {

    public ClientNumber() {}

    public void validateClientNumber(String number) {
        try {
            ClientNumberValidator.validateUserNumber(number);
        } catch (ValidationError e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
