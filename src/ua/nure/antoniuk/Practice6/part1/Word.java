package ua.nure.antoniuk.Practice6.part1;

import java.util.Objects;

/**
 * Created by Max on 05.12.2017.
 */
public class Word implements Comparable<Word> {

    private String word;

    private int frequency;

    public Word(String word) {
        this.word = word;
        frequency = 1;
    }

    public void addWord(){
        frequency++;
    }

    @Override
    public String toString() {
        return
                word +
                " : " + frequency;
    }

    @Override
    public boolean equals(Object o) {
        return Objects.equals(word, ((Word)o).word);
    }

    @Override
    public int hashCode() {
        int result = word != null ? word.hashCode() : 0;
        result = 31 * result;
        return result;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency(){
        return frequency;
    }

    @Override
    public int compareTo(Word o) {
        if (frequency == o.frequency) {
            return word.compareTo(o.word);
        } else {
            return -frequency + o.frequency;
        }
    }
}
