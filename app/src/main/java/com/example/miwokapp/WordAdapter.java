package com.example.miwokapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdapter(@NonNull Context context, ArrayList<Word> words, int colorResourceId) {
        super(context,0, words);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwok_text_view = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        // Get the miwok text from the currentWord object and
        // set this text on the miwok_text_view TextView
        miwok_text_view.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID default_text_view
        TextView default_text_view = (TextView) listItemView.findViewById(R.id.default_text_view);

        // Get the miwok text from the currentWord object and
        // set this text on the default_text_view TextView
        default_text_view.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID word_image
        ImageView word_image = (ImageView) listItemView.findViewById(R.id.word_image);

        if(currentWord.hasImage()){
            // Get the image resource ID from the current AndroidFlavor object and
            // set the image to iconView
            word_image.setImageResource(currentWord.getImageResourceId());
        }
        else{
            word_image.setVisibility(View.GONE);
        }
        // set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);

        // find the color that the resource id maps to
        int color =  ContextCompat.getColor(getContext(),mColorResourceId);

        textContainer.setBackgroundColor(color);

        return listItemView;

    }
}
