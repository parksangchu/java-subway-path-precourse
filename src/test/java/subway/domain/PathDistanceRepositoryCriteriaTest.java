package subway.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class PathDistanceRepositoryCriteriaTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new PathCriteria("Q")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}