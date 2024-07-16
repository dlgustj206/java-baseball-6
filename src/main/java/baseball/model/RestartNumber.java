package baseball.model;

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
        if(!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("ERROR: 종료 및 재시작 입력이 잘못 되었습니다.");
        }
    }
}
