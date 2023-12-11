package subway.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MainMenuTest {
    @Test
    void create() {
        assertThatThrownBy(() -> new MainMenu("b")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}