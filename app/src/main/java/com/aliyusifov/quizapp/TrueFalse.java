package com.aliyusifov.quizapp;

public class TrueFalse {

    private int mQuestionID;
    private boolean mAnswer;

    public TrueFalse(int QuestionID, boolean trueOrFalse){
        mQuestionID = QuestionID;
        mAnswer = trueOrFalse;
    }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int mQuestionID) {
        this.mQuestionID = mQuestionID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
