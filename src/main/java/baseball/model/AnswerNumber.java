package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerNumber {

    private String answerNumber;

    public AnswerNumber() {
        setAnswerNumber();
    }

    public String setAnswerNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        String number = "";
        for(int num : answer) {
            number += num;
        }
        return number;
    }
}
