package baseball.model.entity;

public interface AnswerNumber {

    Integer countStrikes(String number);

    Integer countBalls(String number);

    Boolean isNothing(String number);
}
