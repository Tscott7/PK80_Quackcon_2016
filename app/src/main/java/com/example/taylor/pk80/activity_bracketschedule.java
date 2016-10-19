package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Taylor on 10/16/2016.
 */

public class activity_bracketschedule extends AppCompatActivity implements View.OnClickListener {
    private Button bracket_homeButton;
    private Button bracket_stadiumButton;
    private Button bracket_linksButton;
    private Button bracket_scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bracketschedule);

        bracket_homeButton = (Button) findViewById(R.id.bracket_homeBtn);
        bracket_homeButton.setOnClickListener(this);

        bracket_linksButton = (Button) findViewById(R.id.bracket_linksBtn);
        bracket_linksButton.setOnClickListener(this);

        bracket_stadiumButton = (Button)findViewById(R.id.bracket_stadiumBtn);
        bracket_stadiumButton.setOnClickListener(this);

        bracket_scheduleButton = (Button) findViewById(R.id.bracket_scheduleBtn);
        bracket_scheduleButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0)
    {
        if(arg0.getId() == R.id.bracket_homeBtn)
        {
            Intent homeIntent = new Intent(this,activity_feed.class);
            this.startActivity(homeIntent);
        }
        else if(arg0.getId() == R.id.bracket_linksBtn)
        {
            Intent linksIntent = new Intent(this, activity_links.class);
            this.startActivity(linksIntent);
        }
        else if(arg0.getId() == R.id.bracket_stadiumBtn)
        {
            Intent stadIntent = new Intent(this, activity_stadium.class);
            this.startActivity(stadIntent);
        }
        else if(arg0.getId() == R.id.bracket_scheduleBtn)
        {
            Intent scheduleIntent = new Intent(this, activity_schedule.class);
            this.startActivity(scheduleIntent);
        }
    }
}
