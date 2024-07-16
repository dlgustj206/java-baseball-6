package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientNumberValidator {

    public static void validateUserNumber(List<Integer> number) {
        isStringLengthCorrect(number);
        isValidDigitClientNumber(number);
        hasNoDuplicateNumber(number);
    }

    private static void isStringLengthCorrect(List<Integer> number) {
        if(number.size() != 3) {
            throw new ValidationError("ERROR: 입력값은 3자리여야 합니다.");
        }
    }

    private static void isValidDigitClientNumber(List<Integer> number) {
        for (int num : number) {
            if (num < 1 || num > 9) {
                throw new ValidationError("ERROR: 입력값은 1에서 9 사이의 숫자여야 합니다.");
            }
        }
    }

    private static void hasNoDuplicateNumber(List<Integer> number) {
        Set<Integer> set = new HashSet<>();
        for (int num : number) {
            if (set.contains(num)) {
                throw new ValidationError("ERROR: 입력값에 중복된 숫자가 없어야 합니다.");
            }
            set.add(num);
        }
    }
}
