package refactoring.ch12.part10;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoring.ch12.part10.before.Bird;
import refactoring.ch12.part10.before.BirdData;
import refactoring.ch12.part10.before.BirdFactory;

public class BeforeBirdTest {

    @Test
    @DisplayName("유럽 제비의 비행 속도를 반환한다.")
    void getAirSpeedVelocity_europeanSwallow() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("유럽 제비");

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getAirSpeedVelocity()).isEqualTo(35);
    }

    @Test
    @DisplayName("아프리카 제비의 비행 속도를 반환한다.")
    void getAirSpeedVelocity_AfricanSwallow() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("아프리카 제비");
        birdData.setNumberOfCoconuts(5);

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getAirSpeedVelocity()).isEqualTo(30);
    }

    @Test
    @DisplayName("노르웨이 파랑 앵무의 비행 속도를 반환한다.")
    void getAirSpeedVelocity_NorwegianBlueParrot() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("노르웨이 파랑 앵무");
        birdData.setNailed(false);
        birdData.setVoltage(20);

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getAirSpeedVelocity()).isEqualTo(12);
    }


    @Test
    @DisplayName("유럽 제비의 깃털을 반환한다.")
    void getPlumage_europeanSwallow() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("유럽 제비");

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getPlumage()).isEqualTo("보통이다");
    }

    @Test
    @DisplayName("아프리카 제비의 깃털을 반환한다.")
    void getPlumage_AfricanSwallow() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("아프리카 제비");

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getPlumage()).isEqualTo("보통이다");
    }

    @Test
    @DisplayName("노르웨이 파랑 앵무의 깃털을 반환한다_1")
    void getPlumage_NorwegianBlueParrot1() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("노르웨이 파랑 앵무");
        birdData.setVoltage(101);

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getPlumage()).isEqualTo("그을렸다");
    }

    @Test
    @DisplayName("노르웨이 파랑 앵무의 깃털을 반환한다_2")
    void getPlumage_NorwegianBlueParrot2() {
        // given
        BirdData birdData = new BirdData();
        birdData.setType("노르웨이 파랑 앵무");

        // when
        Bird bird = BirdFactory.create(birdData);

        // then
        assertThat(bird.getPlumage()).isEqualTo("예쁘다");
    }
}
