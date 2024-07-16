package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public String getActionInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String action = Console.readLine();
        return action;
    }

    public List<Integer> setUserNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String num = Console.readLine();
        return convertStringToList(num);
    }

    private List<Integer> convertStringToList(String input) {
        List<Integer> numberList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            numberList.add(Character.getNumericValue(c));
        }
        return numberList;
    }
}
