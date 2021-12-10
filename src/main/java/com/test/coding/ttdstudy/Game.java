package com.test.coding.ttdstudy;

//행위 중심 코드(프로퍼티가 먼저 나오는걸 데이터 중심 코드)
public class Game {
    private int rolls[] = new int[21];  //총 게임횟수
    private int currentRoll = 0;  //몇번째 라운드인지

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int frameIndex = 0;
        //원래 20갸를 직접 더한거고 이걸 수정 아래와 같이
        //10개 라운드를 2번씩 치거나, 스트라이크이면 1번만 치거나, 이걸 계산
        for (int frame = 0; frame<10; frame++) {

            //아래 if~else는 interface로 바꿔주면 좋을 것 같다.
            if (isStrike(rolls[frameIndex])) {  //strike
                score += 10 + strikeBonus(frameIndex);
                frameIndex++;  //한번만 쳤기때문에 다음 2번재는 안친걸로 하고 넘어가야 한다.
            }
            else if (isSpare(frameIndex)) {  //spare
                score += 10 + rolls[frameIndex + 2];
                frameIndex += 2;   //1frame 마다 2번씩 게임을 하기때문에 +2씩 해주기
            } else {
                score += rolls[frameIndex] + rolls[frameIndex + 1];
                frameIndex += 2;   //1frame 마다 2번씩 게임을 하기때문에 +2씩 해주기
            }

        }
        return score;
    }

    private boolean isStrike(int roll) {
        return roll == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }
}
