package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class ClientNumber {

    private final String clientNumber;

    public ClientNumber(String number) {
        isStringLengthCorrect(number);
        isValidDigitClientNumber(number);
        hasNoDuplicateNumber(number);
        this.clientNumber = number;
    }

    public ClientNumber() {
        this.clientNumber = "123";
    }

    public void isStringLengthCorrect(String number) {
        if(number.length() != 3) {
            throw new IllegalArgumentException("ERROR: 입력값은 3자리여야 합니다.");
        }
    }

    public void isValidDigitClientNumber(String number) {
        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c < '1' || c > '9') {
                throw new IllegalArgumentException("ERROR: 입력값은 1에서 9 사이의 숫자여야 합니다.");
            }
        }
    }

    public void hasNoDuplicateNumber(String number) {
        Set<Character> set = new HashSet<>();
        for (char c : number.toCharArray()) {
            if (set.contains(c)) {
                throw new IllegalArgumentException("ERROR: 입력값에 중복된 숫자가 없어야 합니다.");
            }
            set.add(c);
        }
    }
}
