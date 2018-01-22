package example.codeclan.com.wordcountActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import wordcount.Word;
import wordcount.WordAdapter;
import wordcount.WordCount;

public class WordCountActivity extends AppCompatActivity {

    EditText editTextToAnalyse;
    TextView textViewNbWordFound;
    ListView listViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_count);

        editTextToAnalyse   = findViewById(R.id.editTextToAnalyse);
        textViewNbWordFound = findViewById(R.id.textViewNbWordFound);
        listViewResult      = findViewById(R.id.listViewResult);
    }



    protected void onClickAnalyseText(View buttonAnalyse){
        WordCount wordCount = new WordCount();
        wordCount.parseText(editTextToAnalyse.getText().toString());
        wordCount.sortWordByOccurency();
        listViewResult.setAdapter(new WordAdapter(this, wordCount.getResultWordSorted()));
        textViewNbWordFound.setText(String.format("%s", wordCount.getResultWordCount().size()));
    }


    protected void onClickClearTextAndResult(View buttonClear){
        editTextToAnalyse.setText("");
        textViewNbWordFound.setText("0");
        listViewResult.setAdapter(new WordAdapter(this, new ArrayList<>()));
    }


}
