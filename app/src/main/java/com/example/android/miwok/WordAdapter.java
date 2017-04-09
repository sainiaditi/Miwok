package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Dell on 2/5/2017.
 */
public class WordAdapter extends ArrayAdapter<Word> {

    private int mColourResourceId;

    public WordAdapter(Context context, ArrayList<Word> words,int ColourResourceId) {

        super(context, 0, words);
        mColourResourceId = ColourResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        //get the (@link Word) object located at this position in the list
        Word currentWord = getItem(position);


        //find the TextView in the list_item.xml layout with ID default_text_view
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);

        //get the default word from the current Word object and
        //set this text on the defaultTextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        //find the TextView in the list_item.xml layout with the ID miwok_text_view
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);

        //Get Miwok word from the current Word object and
        //set this text on the miwokTextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        //fing a ImageView in list_item.xml layout with image id image
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);

        if(currentWord.hasImage()){
            //set the ImageView to image resource specified in current word
            imageView.setImageResource(currentWord.getmImageResourceId());
            //make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        }
        else{
            //otherwise hide the imageview
            imageView.setVisibility(View.GONE);
        }

        //set theme of the color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find the color that resource id maps to
        int color = ContextCompat.getColor(getContext(),mColourResourceId);
        //set the background color of the text container view
        textContainer.setBackgroundColor(color);

        //return the whole list item layout (containing 2 TextViews)
        //so that it can be shown in the ListView
        return listItemView;
    }
}
