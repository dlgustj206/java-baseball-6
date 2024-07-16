package baseball.model;

import baseball.utils.RestartNumberValidator;
import baseball.utils.ValidationError;

public class RestartNumber {

    private final String restartNumber;

    public RestartNumber(String number) {
        validateActionInput(number);
        this.restartNumber = number;
    }

    public String getRestartNumber() {
        return restartNumber;
    }

    public void validateActionInput(String number) {
        try {
            RestartNumberValidator.validateRestartNumber(number);
        } catch (ValidationError e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
