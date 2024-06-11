package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private String computerNumber;

    public ComputerNumber() {
        setComputerNumber();
    }

    public String getComputerNumber() {
        return computerNumber;
    }

    public void setComputerNumber() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        String number = "";
        for(int num : computer) {
            number += num;
        }
        this.computerNumber = number;
    }
}