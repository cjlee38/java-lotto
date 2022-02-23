package lotto.dto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.LottoRank;

public class StatisticsResponse {

    private final Map<LottoRank, Long> map;

    public StatisticsResponse(Map<LottoRank, Long> map) {
        this.map = map;
    }

    public List<RankResponse> getRankResponse() {
        return map.entrySet()
            .stream()
            .map(this::toRankResponse)
            .collect(Collectors.toList());
    }

    private RankResponse toRankResponse(Map.Entry<LottoRank, Long> entry) {
        return new RankResponse(
            entry.getKey().getMatchCount(), entry.getKey().getPrize(), entry.getValue()
        );
    }
}
