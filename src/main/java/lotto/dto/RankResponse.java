package lotto.dto;

import lotto.domain.LottoRank;

public class RankResponse {

    private final int matchCount;
    private final int prize;
    private final long ticketCount;

    public RankResponse(int matchCount, int prize, long ticketCount) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.ticketCount = ticketCount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrize() {
        return prize;
    }

    public long getTicketCount() {
        return ticketCount;
    }
}
