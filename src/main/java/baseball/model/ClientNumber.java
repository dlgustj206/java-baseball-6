package baseball.model;

import java.util.HashSet;
import java.util.Set;

public class ClientNumber {

    public ClientNumber() {}

    public void validateClientNumber(String number) {
        if(number.length() != 3) {
            throw new IllegalArgumentException("ERROR: 3자리가 아니요.");
        }

        for(int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if(c < '1' || c > '9') {
                throw new IllegalArgumentException("ERROR: 입력값은 1에서 9 사이의 숫자여야 합니다.");
            }
        }

        Set<Character> set = new HashSet<>();
        for (char c : number.toCharArray()) {
            if (set.contains(c)) {
                throw new IllegalArgumentException("ERROR: 입력값에 중복된 숫자가 없어야 합니다.");
            }
            set.add(c);
        }
    }
}
