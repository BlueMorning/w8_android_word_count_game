package wordcount;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by horizon on 22/01/2018.
 */

public class WordCount {

    private String textToParse;
    private HashMap<String, Integer> resultWordCount;

    public WordCount(){

        this.textToParse = "";
        this.resultWordCount = new HashMap<>();
    }

    public HashMap<String, Integer> getResultWordCount(){
        return this.resultWordCount;
    }

    public void setTextToParse(String textToParse){

        this.textToParse = textToParse;
    }

    public String getTextToParse(){

        return this.textToParse;
    }

    public HashMap<String, Integer> parseText(String textToParse){

        this.resultWordCount.clear();

        String[] wordsFound = textToParse.toLowerCase().split(" ");

        for(String word : wordsFound){

            if(! this.resultWordCount.containsKey(word)){
                this.resultWordCount.put(word, 0);
            }

            this.resultWordCount.replace(word, this.resultWordCount.get(word)+1);
        }

        return this.resultWordCount;
    }


    public ArrayList<Word> sortWordByOccurency(){

        ArrayList<Word> words = new ArrayList<>();

        for(String word : this.resultWordCount.keySet()){
            words.add(new Word(word, this.resultWordCount.get(word)));
        }


        words.sort((w1, w2) -> w2.getCount()
                .compareTo(w1.getCount()));

        return words;
    }

}
