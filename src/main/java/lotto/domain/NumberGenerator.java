package lotto.domain;

import java.util.List;

public interface NumberGenerator {
    List<Integer> generate(int size);
}