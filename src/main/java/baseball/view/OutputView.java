package baseball.view;

public class OutputView {

    public void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printGameResult(int strikes, int balls) {
        if(strikes > 0 && balls > 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        }
        else if(strikes > 0) {
            System.out.println(strikes + "스트라이크");
        }
        else if(balls > 0) {
            System.out.println(balls + "볼");
        }
        else {
            System.out.println("낫싱");
        }
    }
}
