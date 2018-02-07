package ua.nure.antoniuk.Practice6.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Max on 05.12.2017.
 */
public class WordContainer {
    List<Word> words = new ArrayList<>();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        words.sort((a1, b) ->{
            if(a1.getFrequency() < b.getFrequency()){
                return 1;
            } else if(a1.getFrequency() > b.getFrequency()){
                return -1;
            } else{
                return a1.getWord().compareTo(b.getWord());
            }
        });
        for (Word w : words) {
            sb.append(w.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public boolean add(Word o) {
        if(words.contains(o)){
            words.get(words.indexOf(o)).addWord();
            return true;
        } else{
            words.add(o);
            return true;
        }
    }

    public void sort(){
        Collections.sort(words);
    }

    public List<Word> getWords() {
        return words;
    }

    public static void main(String[] args) {
        WordContainer wc = new WordContainer();
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s;
        while (sc.hasNext()) {
            s = sc.nextLine();
            if ("stop".equals(s)) {
                break;
            }
            sb.append(s).append(" ");
        }
        System.out.println(sb);
        sc.close();
        String[] strings = sb.toString().split("\\s+");
        for(int i = 0; i < strings.length; i++) {

            wc.add(new Word(strings[i]));
        }
        System.out.println(wc);
    }
}
