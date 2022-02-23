package lotto.view;

import java.util.List;

import lotto.domain.LottoRank;
import lotto.dto.LottoTicketResponse;
import lotto.dto.RankResponse;
import lotto.dto.StatisticsResponse;

public class OutputView {

    public void outputTickets(List<LottoTicketResponse> responses) {
        System.out.printf("%d개를 구매했습니다.%n", responses.size());
        for (LottoTicketResponse response : responses) {
            outputTicket(response);
        }
        System.out.println();
    }

    private void outputTicket(LottoTicketResponse lottoTicketResponse) {
        System.out.println(lottoTicketResponse.getLottoTicketResponse());
    }

    public void outputStatistics(StatisticsResponse statisticsResponse) {
        displayPrompt();
        displayRanks(statisticsResponse);
        // displayProfit();
    }

    private void displayPrompt() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    private void displayRanks(StatisticsResponse statisticsResponse) {
        for (RankResponse response : statisticsResponse.getRankResponse()) {
            displayStatistics(response);
        }
    }

    private void displayStatistics(RankResponse response) {
        if (response.getMatchCount() < LottoRank.THRESHOLD) {
            return ;
        }
        System.out.printf(findMessageByRank(response.getMatchCount()), response.getPrize(), response.getTicketCount());
    }

    private String findMessageByRank(int matchCount) {
        if (matchCount == LottoRank.SPECIAL_CASE) {
            return "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
        }
        return "%d개 일치 (%d원)- %d개\n";
    }

    private void displayStatistics(LottoRank rank, long count) {
        if (rank == LottoRank.SIXTH) {
            return;
        }
        System.out.printf(findMessageByRank(rank), rank.getMatchCount(), rank.getPrize(), count);
    }

    private String findMessageByRank(LottoRank rank) {
        if (rank == LottoRank.SECOND) {
            return "%d개 일치, 보너스 볼 일치(%d원) - %d개\n";
        }
        return "%d개 일치 (%d원)- %d개\n";
    }

    /*
    당첨 통계
    ---------
    3개 일치 (5000원)- 1개
    4개 일치 (50000원)- 0개
    5개 일치 (1500000원)- 0개
    5개 일치, 보너스 볼 일치(30000000원) - 0개
    6개 일치 (2000000000원)- 0개
    총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
     */
}
