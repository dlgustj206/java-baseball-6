package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.ClientNumber;
import baseball.model.ComputerNumber;
import baseball.model.RestartNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        ComputerNumber computerNumber = new ComputerNumber();
        ClientNumber clientNumber = new ClientNumber();

        BaseballGameController ctrl = new BaseballGameController(inputView, outputView, computerNumber, clientNumber);
        ctrl.startGame();
    }
}
