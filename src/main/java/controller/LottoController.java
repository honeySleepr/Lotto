package controller;

import domain.Lotto;
import domain.LottoShop;
import domain.Rank;
import domain.WinningNumbers;
import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoShop lottoShop;

    public LottoController(InputView inputView, OutputView outputView, LottoShop lottoShop) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoShop = lottoShop;
    }

    public void runLotto() {
        int userMoney = inputView.getMoneyInput();
        List<Lotto> purchasedLotteries = lottoShop.order(userMoney);
        outputView.printLotteries(purchasedLotteries);
        WinningNumbers winningNumbers = new WinningNumbers(inputView.getAnswerInput());
        Map<Rank, Integer> result = lottoShop.getResult(purchasedLotteries, winningNumbers);
        outputView.printStatistics(result, userMoney);

    }
}
