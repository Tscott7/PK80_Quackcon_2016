package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Taylor on 10/16/2016.
 */

public class activity_ticket extends AppCompatActivity implements View.OnClickListener {
    private Button stadiumButton;
    private Button ticket_homeButton;
    private Button ticket_scheduleButton;
    private Button ticket_linkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        stadiumButton =(Button) findViewById(R.id.stadiumBtn);
        stadiumButton.setOnClickListener(this);

        ticket_homeButton =(Button) findViewById(R.id.ticket_homeBtn);
        ticket_homeButton.setOnClickListener(this);

        ticket_scheduleButton = (Button) findViewById(R.id.ticket_scheduleBtn);
        ticket_scheduleButton.setOnClickListener(this);

        ticket_linkButton = (Button) findViewById(R.id.ticket_linkBtn);
        ticket_linkButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        if(arg0.getId() == R.id.stadiumBtn){
            Intent stadiumIntent = new Intent(this, activity_stadium.class);
            this.startActivity(stadiumIntent);
        }
        else if(arg0.getId() == R.id.ticket_homeBtn)
        {
            Intent homeIntent = new Intent(this, activity_feed.class);
            this.startActivity(homeIntent);
        }
        else if(arg0.getId() == R.id.ticket_scheduleBtn)
        {
            Intent scheduleIntent = new Intent(this, activity_schedule.class);
            this.startActivity(scheduleIntent);
        }
        else if(arg0.getId() == R.id.ticket_linkBtn)
        {
            Intent linkIntent = new Intent(this, activity_links.class);
            this.startActivity(linkIntent);
        }
    }
}
