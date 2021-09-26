package com.example.sidemenusakura.FoodDeliveryManagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.sidemenusakura.BarMenuManagement.BarMenuPage2Activity;
import com.example.sidemenusakura.FoodMenuManagement.Mainnewgui1;
import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.R;

public class MyLatestOrderActivity extends AppCompatActivity {

    ImageView imageButtonhome,imageButtonfood, imageButtonbar, imageButtonorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_latest_order);


        imageButtonhome=findViewById(R.id.imageButtonhome);
        imageButtonfood=findViewById(R.id.imageButtonfood);
        imageButtonbar=findViewById(R.id.imageButtonbar);
        imageButtonorder=findViewById(R.id.imageButtonorder);




        imageButtonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyLatestOrderActivity.this, MainActivity.class));
            }
        });

        imageButtonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyLatestOrderActivity.this, Mainnewgui1.class));
            }
        });

        imageButtonbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyLatestOrderActivity.this, BarMenuPage2Activity.class));
            }
        });

        imageButtonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MyLatestOrderActivity.this,MyLatestOrderActivity.class));
            }
        });

    }
}