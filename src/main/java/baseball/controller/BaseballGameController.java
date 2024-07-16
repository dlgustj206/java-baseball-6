package baseball.controller;

import baseball.model.ClientNumber;
import baseball.model.ComputerNumber;
import baseball.model.RestartNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final ComputerNumber computerNumber;
    private final ClientNumber clientNumber;

    public BaseballGameController(InputView inputView, OutputView outputView, ComputerNumber computerNumber, ClientNumber clientNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computerNumber = computerNumber;
        this.clientNumber = clientNumber;
    }

    public void
    startGame() {
        outputView.printGameStartMessage();

        do {
            // 게임 초기화
            String answer = computerNumber.setComputerNumber();

            try {
                playGame(answer);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        } while (getRestartOption());
    }


    private void playGame(String answer) {
        boolean gameEnded = false;

        while (!gameEnded) {
            String userNumber = inputView.setUserNumber();
            clientNumber.validateClientNumber(userNumber);

            // 게임 로직 처리
            int strikes = countStrikes(answer, userNumber);
            int balls = countBalls(answer, userNumber);

            // 결과 출력
            outputView.printGameResult(strikes, balls);

            if (strikes == 3) {
                outputView.printGameSetMessage();
                gameEnded = true;
            }

        }
    }

    private boolean getRestartOption() {
        return new RestartNumber(inputView.getActionInput())
                .getRestartNumber()
                .equals("1");
    }

    private int countStrikes(String answer, String userNumber) { // count
        int strikes = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == answer.charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(String answer, String userNumber) {
        int balls = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            char num = userNumber.charAt(i);
            if (answer.contains(String.valueOf(num)) && answer.indexOf(num) != i) {
                balls++;
            }
        }
        return balls;
    }
}