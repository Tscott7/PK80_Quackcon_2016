package com.example.taylor.pk80;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_deals extends AppCompatActivity implements View.OnClickListener {
    private Button backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deals);
        backArrow = (Button) findViewById(R.id.backBtn);
        backArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.backBtn) {
            Intent intent = new Intent(this, activity_links.class);
            this.startActivity(intent);
        }
    }
}