package baseball.utils;

public class RestartNumberValidator {

    public static void validateRestartNumber(String number) {
        if(!number.equals("1") && !number.equals("2")) {
            throw new ValidationError("ERROR: 종료 및 재시작 입력이 잘못 되었습니다.");
        }
    }
}
