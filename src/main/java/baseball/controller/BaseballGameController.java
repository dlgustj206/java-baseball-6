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
    private ClientNumber clientNumber;

    public BaseballGameController(InputView inputView, OutputView outputView, ComputerNumber computerNumber,
                                  ClientNumber clientNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computerNumber = computerNumber;
        this.clientNumber = clientNumber;
    }

    public void startGame() {
        outputView.printGameStartMessage();

        do {
            // 게임 초기화
            computerNumber.setComputerNumber();

            try {
                playGame();
            } catch (IllegalArgumentException e) {
                return;
            }
        } while (getRestartOption());
    }

    private void playGame() {
        boolean gameEnded = false;

        while (!gameEnded) {
            try {
                String userNumber = inputView.setUserNumber();
                clientNumber = new ClientNumber(userNumber);

                // 게임 로직 처리
                int strikes = countStrikes(userNumber);
                int balls = countBalls(userNumber);

                // 결과 출력
                outputView.printGameResult(strikes, balls);

                if (strikes == 3) {
                    outputView.printGameSetMessage();
                    gameEnded = true;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean getRestartOption() {
        return new RestartNumber(inputView.getActionInput())
                .getRestartNumber()
                .equals("1");
    }

    private int countStrikes(String userNumber) {
        int strikes = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) == computerNumber.getComputerNumber().charAt(i)) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(String userNumber) {
        int balls = 0;
        for (int i = 0; i < userNumber.length(); i++) {
            char num = userNumber.charAt(i);
            if (computerNumber.getComputerNumber().contains(String.valueOf(num)) && computerNumber.getComputerNumber().indexOf(num) != i) {
                balls++;
            }
        }
        return balls;
    }
}