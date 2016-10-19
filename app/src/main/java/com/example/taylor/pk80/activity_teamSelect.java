package com.example.taylor.pk80;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_teamSelect extends LoginActivity implements View.OnClickListener {
    private Button buttonSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_select);
        buttonSelect = (Button) findViewById(R.id.uoSelect);
        buttonSelect.setOnClickListener(this);
    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.uoSelect) {
            Intent intent = new Intent(this, activity_feed.class);
            this.startActivity(intent);
        }
    }
}
