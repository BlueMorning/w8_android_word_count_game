package example.codeclan.com.wordcountActivity;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import wordcount.Word;
import wordcount.WordCount;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    WordCount wordCount;
    String text;

    @Before
    public void before(){
        text = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, …";
        wordCount = new WordCount();
        wordCount.setTextToParse(text);
    }


    @Test
    public void hasText(){
        assertEquals(text,
                wordCount.getTextToParse());
    }

    @Test
    public void canParseText(){

        wordCount.parseText(text);

        assertEquals(6,
                wordCount.getResultWordCount().get("it").intValue());

        assertEquals(1,
                wordCount.getResultWordCount().get("incredulity").intValue());
    }

    @Test
    public void canSortResult(){
        wordCount.parseText(text);
        ArrayList<Word> wordCountSorted = wordCount.sortWordByOccurency();

        assertEquals(6, wordCountSorted.get(0).getCount(), 0);
        assertEquals(1, wordCountSorted.get(wordCountSorted.size()-1).getCount(), 0);

    }
















}