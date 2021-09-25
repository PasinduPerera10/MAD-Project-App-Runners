package com.example.sidemenusakura.OrderManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class orderdeliveryActivity extends AppCompatActivity {

    Button button_payments, button_viewed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderdelivery);

        button_payments = findViewById(R.id.button_payments);

        button_payments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderdeliveryActivity.this,payments.class);
                startActivity(intent);
            }
        });


    }
}