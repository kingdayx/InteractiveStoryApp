package com.daotec.Interactivestoryapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daotec.Interactivestoryapp.R;
import com.daotec.Interactivestoryapp.model.Page;
import com.daotec.Interactivestoryapp.model.Story;

public class StoryActivity extends AppCompatActivity {

    private int textId;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice2Button;
    private Button choice1Button;
    private Page[] pages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        choice1Button = (Button) findViewById(R.id.choice1Button);
        choice2Button = (Button) findViewById(R.id.choice2Button);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));


        loadPage(0);

    }

    private Story story = new Story();

    private void loadPage(int pageNumber) {
        Page page = story.getPage(pageNumber);
        Drawable image = ContextCompat.getDrawable(this, page.getImageId());
        storyImageView.setImageDrawable(image);
        Intent intent = getIntent();
        String name = intent.getStringExtra(getString(R.string.key_name));
        String pageText = getString(getTextId());
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);
        choice1Button.setText(page.getChoice1().getTextId());
        choice2Button.setText(page.getChoice2().getTextId());
    }


    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }
}

 
