package wordcount;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import example.codeclan.com.wordcountActivity.R;

/**
 * Created by horizon on 22/01/2018.
 */

public class WordAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater mInflater;
    private ArrayList<Word> words;

    public WordAdapter(Context context, ArrayList<Word> words){
        this.context = context;
        this.words   = words;

    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int position) {
        return words.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.display_word, parent, false);
        TextView textViewWord = (TextView) rowView.findViewById(R.id.word);
        textViewWord.setText(words.get(position).getWord());

        TextView textViewCount = (TextView) rowView.findViewById(R.id.count);
        textViewCount.setText(words.get(position).getCount().toString());

        return rowView;
    }
}
