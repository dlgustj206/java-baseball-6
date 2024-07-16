package baseball.controller;

import baseball.model.ClientNumber;
import baseball.model.AnswerNumber;
import baseball.model.RestartNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final AnswerNumber answerNumber;
    private final ClientNumber clientNumber;

    public BaseballGameController(InputView inputView, OutputView outputView, AnswerNumber answerNumber, ClientNumber clientNumber) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.answerNumber = answerNumber;
        this.clientNumber = clientNumber;
    }

    public void startGame() {
        outputView.printGameStartMessage();

        do {
            // 게임 초기화
            List<Integer> answer = answerNumber.setAnswerNumber();

            try {
                playGame(answer);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        } while (getRestartOption());
    }


    private void playGame(List<Integer> answer) {
        boolean gameEnded = false;

        while (!gameEnded) {
            List<Integer> userNumber = inputView.setUserNumber();
            clientNumber.validateClientNumber(userNumber);

            // 게임 로직 처리
            int strikes = countStrikes(answer, userNumber);
            int balls = countBalls(answer, userNumber);

            // 결과 출력
            outputView.printGameResult(strikes, balls);

            if (strikes == 3) {
                gameEnded = true;
            }

        }
    }

    private boolean getRestartOption() {
        return new RestartNumber(inputView.getActionInput())
                .getRestartNumber()
                .equals("1");
    }

    private int countStrikes(List<Integer> answer, List<Integer> userNumber) {
        int strikes = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            if (userNumber.get(i).equals(answer.get(i))) {
                strikes++;
            }
        }
        return strikes;
    }

    private int countBalls(List<Integer> answer, List<Integer> userNumber) {
        int balls = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            int num = userNumber.get(i);
            if (answer.contains(num) && !userNumber.get(i).equals(answer.get(i))) {
                balls++;
            }
        }
        return balls;
    }
}