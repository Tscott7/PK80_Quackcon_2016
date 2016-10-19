package com.example.taylor.pk80;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class activity_facebook extends LoginActivity implements View.OnClickListener {

    private Button fb_ok_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);
        fb_ok_button = (Button) findViewById(R.id.fb_ok_button);
        fb_ok_button.setOnClickListener(this);

    }

    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.fb_ok_button) {
            Intent intent = new Intent(this, activity_teamSelect.class);
            this.startActivity(intent);
        }
    }
}


