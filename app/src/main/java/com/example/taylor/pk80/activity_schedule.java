package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Taylor on 10/16/2016.
 */

public class activity_schedule extends AppCompatActivity implements View.OnClickListener {
    private Button schedule_homeButton;
    private Button schedule_stadiumButton;
    private Button schedule_linksButton;
    private Button bracketButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        schedule_homeButton = (Button) findViewById(R.id.schedule_homeBtn);
        schedule_homeButton.setOnClickListener(this);

        schedule_linksButton = (Button) findViewById(R.id.schedule_linksBtn);
        schedule_linksButton.setOnClickListener(this);

        schedule_stadiumButton = (Button)findViewById(R.id.schedule_stadiumBtn);
        schedule_stadiumButton.setOnClickListener(this);

        bracketButton = (Button) findViewById(R.id.bracketBtn);
        bracketButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0)
    {
        if(arg0.getId() == R.id.schedule_homeBtn)
        {
            Intent homeIntent = new Intent(this,activity_feed.class);
            this.startActivity(homeIntent);
        }
        else if(arg0.getId() == R.id.schedule_linksBtn)
        {
            Intent linksIntent = new Intent(this, activity_links.class);
            this.startActivity(linksIntent);
        }
        else if(arg0.getId() == R.id.schedule_stadiumBtn)
        {
            Intent stadIntent = new Intent(this, activity_stadium.class);
            this.startActivity(stadIntent);
        }
        else if(arg0.getId() == R.id.bracketBtn)
        {
            Intent bracketIntent = new Intent(this, activity_bracketschedule.class);
            this.startActivity(bracketIntent);
        }
    }
}
