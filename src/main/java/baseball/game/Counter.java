package baseball.game;

import baseball.type.CountSpeaker;

import java.util.List;

public class Counter {

    public int countStrikeBall(String guessNum, List<Integer> theAnswer) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < theAnswer.size(); i++) {
            int answerDigit = theAnswer.get(i);
            int guessDigit = toInt(guessNum.charAt(i));
            if (isStrike(answerDigit, guessDigit)) {
                strikeCount++;
                continue;
            }
            if (isBall(theAnswer, guessDigit)) {
                ballCount++;
            }
        }
        indicator(strikeCount, ballCount);
        return strikeCount;
    }

    private int toInt(char input) {
        return input - '0';
    }
    private boolean isStrike(int answerDigit, int guessDigit) {
        return answerDigit == guessDigit;
    }
    private boolean isBall(List<Integer> theAnswer, int guessDigit) {
        return theAnswer.contains(guessDigit);
    }
    private void indicator(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(CountSpeaker.NOTHING.getCall());
        } else if (strikeCount == 3) {
            System.out.println(strikeCount + CountSpeaker.STRIKE.getCall());
        } else {
            if (strikeCount == 0) {
                System.out.println(ballCount + CountSpeaker.BALL.getCall());
            } else if (ballCount == 0) {
                System.out.println(strikeCount + CountSpeaker.STRIKE.getCall());
            } else {
                System.out.println(ballCount + CountSpeaker.BALL.getCall() + " " + strikeCount + CountSpeaker.STRIKE.getCall());
            }
        }
    }
}
