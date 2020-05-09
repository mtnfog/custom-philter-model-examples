package com.mtnfog.philter.opennlp;

public class PhilterSpan {

    private String text;
    private double score;
    private int start;
    private int end;
    private String tag;

    public PhilterSpan(String text, double score, int start, int end, String tag) {

        this.text = text;
        this.score = score;
        this.start = start;
        this.end = end;
        this.tag = tag;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
