package lotto.view;

import lotto.client.InputClient;

public class InputView {

    private final InputClient client;

    public InputView(InputClient client) {
        this.client = client;
    }

    public String inputMoney() {
        return client.input("구입금액을 입력해 주세요.\n");
    }

    public String inputWinningNumber() {
        return client.input("지난 주 당첨 번호를 입력해 주세요.\n");
    }

    public String inputBonusBall() {
        return client.input("보너스 볼을 입력해 주세요.\n");
    }
}
