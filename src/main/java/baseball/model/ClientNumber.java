package baseball.model;

import baseball.utils.ValidationError;
import baseball.utils.ClientNumberValidator;

import java.util.List;

public class ClientNumber {

    public ClientNumber() {}

    public void validateClientNumber(List<Integer> number) {
        try {
            ClientNumberValidator.validateUserNumber(number);
        } catch (ValidationError e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
