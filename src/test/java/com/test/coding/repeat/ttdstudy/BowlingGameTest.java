package com.test.coding.repeat.ttdstudy;

import com.test.coding.ttdstudy.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BowlingGameTest {

    Game g;

    @BeforeEach
    void setUp() {
        g = new Game();
    }

    @Test
    void testGutterGame() {
        //given
        //when
        rollMany(20, 0);

        //then
        assertThat(g.score()).isEqualTo(0);

    }

    @Test
    void testAllOnes() {

        //given
        //when
        rollMany(20, 20);

        //then
        assertThat(g.score()).isEqualTo(20);
    }



    @Test
    void testOneSpare() {
        //given
        rollSpare();  //10 + 3
        g.roll(3);  //3을 더해서 = 16점
        rollMany(17,0);
        //5, 5 -> 10점
        //3 -> 13 -> + 3점 : 16점

        //when

        //then
        assertThat(g.score()).isEqualTo(16);

    }



    @Test
    void testOneStrike() {
        //given
        rollStrike();  //1, 2 => 10개 + 7점 = 17점
        g.roll(3);  //3
        g.roll(4);  //4
        rollMany(16,0);

        //when

        //then
        assertThat(g.score()).isEqualTo(24);

    }

    @Test
    void testPerfectGame() {
        //given
        rollMany(12, 10);

        //when

        //then
        assertThat(g.score()).isEqualTo(300);
    }



    private void rollStrike() {
        g.roll(10);
    }

    private void rollSpare() {
        g.roll(5);
        g.roll(5);
    }

    private void rollMany(int n, int pins) {
        for(int i = 0; i < n; i++) {
            g.roll(pins);
        }
    }

}

/*
 *  TDD 방법론 : 테스트 코드 -> 실제 로직
 *  빨간색 - 초록색 - 리팩토링(중복 코드 제거, 주석이나 코드 )
 */
