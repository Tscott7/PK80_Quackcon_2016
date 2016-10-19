package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Taylor on 10/16/2016.
 */

public class activity_stadium extends AppCompatActivity implements View.OnClickListener{

    private Button stad_homeButton;
    private Button mobileTicketButton;
    private Button stad_linksButton;
    private Button stad_scheduleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium);

        stad_homeButton = (Button) findViewById(R.id.stad_homeBtn);
        stad_homeButton.setOnClickListener(this);

        mobileTicketButton = (Button) findViewById(R.id.mobileTicketBtn);
        mobileTicketButton.setOnClickListener(this);

        stad_linksButton = (Button) findViewById(R.id.stad_linksBtn);
        stad_linksButton.setOnClickListener(this);

        stad_scheduleButton = (Button) findViewById(R.id.stad_scheduleBtn);
        stad_scheduleButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.stad_homeBtn) {
            Intent homeIntent = new Intent(this, activity_feed.class);
            this.startActivity(homeIntent);
        }
        else if(arg0.getId() == R.id.mobileTicketBtn){
            Intent ticketIntent = new Intent(this,activity_ticket.class);
            this.startActivity(ticketIntent);
        }
        else if(arg0.getId() == R.id.stad_linksBtn)
        {
            Intent linksIntent = new Intent(this,activity_links.class);
            this.startActivity(linksIntent);
        }
        else if(arg0.getId() == R.id.stad_scheduleBtn)
        {
            Intent scheduleIntent= new Intent(this,activity_schedule.class);
            this.startActivity(scheduleIntent);
        }

    }
}
