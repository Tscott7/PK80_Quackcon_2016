package com.example.taylor.pk80;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import static com.example.taylor.pk80.R.styleable.View;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Button fbButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fbButton = (Button) findViewById(R.id.loginWithFB_button);
        fbButton.setOnClickListener(this);

    }

    ;


    @Override
    public void onClick(View arg0) {
        if (arg0.getId() == R.id.loginWithFB_button) {
            Intent intent = new Intent(this, activity_facebook.class);
            this.startActivity(intent);
        }
    }
}




