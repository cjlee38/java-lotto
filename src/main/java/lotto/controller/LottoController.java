package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.WinningTicket;
import lotto.dto.LottoTicketResponse;
import lotto.utils.IntegerUtils;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = new Money(IntegerUtils.parse(inputView.inputMoney()));
        LottoTickets tickets = LottoTickets.buy(new RandomNumberGenerator(LottoNumber.MIN, LottoNumber.MAX), money);
        List<LottoTicketResponse> response = LottoTicketResponse.from(tickets);
        outputView.outputTickets(response);

        String inputNumbers = inputView.inputWinningNumber();
        String inputBonusBall = inputView.inputBonusBall();
        WinningTicket winningTicket = new WinningTicket(new LottoTicket(Arrays.stream(inputNumbers.split(", "))
            .map(x -> new LottoNumber(IntegerUtils.parse(x)))
            .collect(Collectors.toList())), new LottoNumber(IntegerUtils.parse(inputBonusBall)));

    }
}
