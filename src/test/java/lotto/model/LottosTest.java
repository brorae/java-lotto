package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.model.number.LottoNumber;
import lotto.model.number.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init() {
        Lotto lotto = makeLotto(new int[]{1, 2, 3, 4, 5, 6}); //1등
        Lotto lotto1 = makeLotto(new int[]{2, 3, 4, 5, 6, 7}); //2등
        Lotto lotto2 = makeLotto(new int[]{3, 4, 5, 6, 7, 8}); //4등
        lottos = new Lottos(Arrays.asList(lotto,lotto1,lotto2));
    }

    @DisplayName("Lottos 생성 테스트")
    @Test
    void LottosTest() {
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @DisplayName("등수 계산 테스트")
    @Test
    void calculateRanksTest() {
        LottoNumbers winningNumbers = makeLottoNumbers(new int[]{1, 2, 3, 4, 5, 6});
        LottoNumber bonusNumber = new LottoNumber(7);
        Map<Rank, Integer> rankCount = new LinkedHashMap<>();
        rankCount.put(Rank.FIRST, 1);
        rankCount.put(Rank.SECOND, 1);
        rankCount.put(Rank.FOURTH, 1);
        assertThat(lottos.calculateRanks(winningNumbers, bonusNumber)).containsAllEntriesOf(rankCount);
    }

    @DisplayName("Lottos 크기 테스트")
    @Test
    void lottosSizeTest() {
        assertThat(lottos.size()).isEqualTo(3);
    }

    private Lotto makeLotto(int[] numbers) {
        LottoNumbers lottoNumbers = makeLottoNumbers(numbers);
        return new Lotto(lottoNumbers);
    }

    private LottoNumbers makeLottoNumbers(int[] numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int num : numbers) {
            lottoNumbers.add(new LottoNumber(num));
        }
        return new LottoNumbers(lottoNumbers);
    }
}
