package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {
    
    @Test
    @DisplayName("로또 티켓들이 정상적으로 생성되는지 확인")
    void createLottoTickets() {
        // given
        Money money = new Money(3000);
        RandomNumberGenerator generator = new RandomNumberGenerator(0, 45);
        // when
        LottoTickets lottoTickets = LottoTickets.buy(generator, money);
        // then
        Assertions.assertThat(lottoTickets).isNotNull();
    }
}
