package com.example.jesseviauandroidtest.pojo;

public class listViewItem {
    private String question;
    private String answer;

    public listViewItem(String answer, String question) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return this.question;
    }
}
