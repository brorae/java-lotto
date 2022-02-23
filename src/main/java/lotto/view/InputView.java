package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요";
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";

    private static final Scanner input = new Scanner(System.in);

    public static String inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return input.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MESSAGE);
        return input.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return input.nextLine();
    }
}
