package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getActionInput() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String action = Console.readLine();
        return action;
    }

    public String setUserNumber() {
        System.out.print("숫자를 입력해주세요: ");
        String num = Console.readLine();
        return num;
    }
}
