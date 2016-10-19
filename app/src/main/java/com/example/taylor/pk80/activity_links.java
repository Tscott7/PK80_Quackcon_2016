package com.example.taylor.pk80;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class activity_links extends LoginActivity implements View.OnClickListener {
    private Button deals_btn;
    private Button feed_btn;
    private Button schedule_btn;
    private Button stadium_btn;
    private Button hotel_button;
    private Button deal_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_links);

        feed_btn = (Button) findViewById(R.id.feed_button);
        feed_btn.setOnClickListener(this);
        schedule_btn = (Button) findViewById(R.id.schedule_button);
        schedule_btn.setOnClickListener(this);
        stadium_btn = (Button) findViewById(R.id.stadium_button);
        stadium_btn.setOnClickListener(this);

        hotel_button = (Button) findViewById(R.id.hotelBtn);
        hotel_button.setOnClickListener(this);

        deal_button = (Button) findViewById(R.id.dealBtn);
        deal_button.setOnClickListener(this);
    }
    @Override
    public void onClick(View arg0) {
//        if (arg0.getId() == R.id.deals_button) {
//            Intent intent = new Intent(this, activity_deals.class);
//            this.startActivity(intent);
//        }
         if (arg0.getId() == R.id.feed_button) {
            Intent intent = new Intent(this, activity_feed.class);
            this.startActivity(intent);
        }
        else if (arg0.getId() == R.id.schedule_button) {
            Intent intent = new Intent(this, activity_schedule.class);
            this.startActivity(intent);
        }
        else if (arg0.getId() == R.id.stadium_button) {
            Intent intent = new Intent(this, activity_stadium.class);
            this.startActivity(intent);
        }
        else if(arg0.getId() == R.id.hotelBtn)
         {
             Intent hotelIntent = new Intent(this, webactivity_hotels.class);
             this.startActivity(hotelIntent);
         }
        else if(arg0.getId() == R.id.dealBtn)
         {
             Intent dealIntent = new Intent(this, activity_deals.class);
             this.startActivity(dealIntent);
         }
    }
}