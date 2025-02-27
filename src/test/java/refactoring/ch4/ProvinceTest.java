package refactoring.ch4;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ProvinceTest {

    private List<Producer> producers = new ArrayList<>();
    private Province province;

    @BeforeEach
    void setUp() {
        province = new Province("Asia", 30, 20, producers);
        producers.add(new Producer("Byzantium", province, 10, 9));
        producers.add(new Producer("Attalia", province, 12, 10));
        producers.add(new Producer("Sinope", province, 10, 6));
    }

    @Test
    @DisplayName("생산부족분을 계산할 수 있다.")
    void shortfall() {
        int expected = province.shortfall();
        assertThat(5).isEqualTo(expected);
    }
}
