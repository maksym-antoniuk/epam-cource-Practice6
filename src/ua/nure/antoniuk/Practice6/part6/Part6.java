package ua.nure.antoniuk.Practice6.part6;

import ua.nure.antoniuk.Practice6.Util;
import ua.nure.antoniuk.Practice6.part1.Word;
import ua.nure.antoniuk.Practice6.part1.WordContainer;

import java.io.FileNotFoundException;
import java.util.*;

public class Part6 {
	public static final int COUNT = 3;
	public static void main(String[] args) throws FileNotFoundException {
        if(!(args[0].equals("-i") || args[0].equals("--input"))){
            return;
        }
        if(!(args[2].equals("-t") || args[2].equals("--task"))){
            return;
        }
        String s[] = Util.getInput(args[1],"cp1251").split(" ");
        if(args[3].equals("frequency")){
            frequency(s);
            return;
        }
        if(args[3].equals("length")){
            length(s);
            return;
        }
        if(args[3].equals("duplicates")){
            duplicates(s);
            return;
        }
	}
	public static void frequency(String []s){
	    WordContainer wc = new WordContainer();
	    for (String string:s){
	        wc.add(new Word(string));
        }
        wc.sort();
        int counter = 0;
        for (Word w:wc.getWords()){
            System.out.println(new StringBuilder().append(w.getWord()).append(" ==> ").append(w.getFrequency()));
            if(++counter == 3){
                break;
            }
        }
    }

    public static void length(String []s){
        Comparator<String> comparator = (o1, o2) -> {
            if (o2.length()!=o1.length())
                return o2.length()- o1.length();
            else {
                return o1.compareTo(o2);
            }
        };
        Set<String> set = new TreeSet<>(comparator);
        for (String st:s){
            set.add(st);
        }
        int counter = 0;
        for (String st:set){
            System.out.println(new StringBuilder().append(st).append(" ==> ").append(st.length()));
            if(++counter == 3){
                break;
            }
        }
    }

    public static void duplicates(String []s){
        WordContainer wc = new WordContainer();
        for (String st:s){
            wc.add(new Word(st));
            if(wc.getWords().size() >= 3){
                wc.sort();
                List<Word> list = wc.getWords();
                boolean flag = false;
                for (int i=0;i<3;i++){
                    if(list.get(i).getFrequency()<2){
                        flag=true;
                        break;
                    }
                }
                if(!flag){
                    for (int i=0;i<3;i++){
                        Word word = list.get(i);
                        System.out.println(new StringBuilder(word.getWord()).reverse().toString().toUpperCase());
                    }
                    break;
                }
            }
        }
    }

}


