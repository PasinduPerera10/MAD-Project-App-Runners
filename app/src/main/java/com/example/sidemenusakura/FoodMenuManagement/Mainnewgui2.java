package com.example.sidemenusakura.FoodMenuManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.BarMenuManagement.BarMenuPage2Activity;
import com.example.sidemenusakura.FoodDeliveryManagement.MyLatestOrderActivity;
import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.OrderManagement.AddOrderActivity;
import com.example.sidemenusakura.R;

public class Mainnewgui2 extends AppCompatActivity {

    Button button22, button23, button25, buttonorder1, buttonorder2, buttonorder3;
    ImageView imageButtonhome,imageButtonfood, imageButtonbar, imageButtonorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnewgui2);


        button22=findViewById(R.id.button22);
        button23=findViewById(R.id.button23);
        button25=findViewById(R.id.button25);
        imageButtonhome=findViewById(R.id.imageButtonhome);
        imageButtonfood=findViewById(R.id.imageButtonfood);
        imageButtonbar=findViewById(R.id.imageButtonbar);
        imageButtonorder=findViewById(R.id.imageButtonorder);
        buttonorder1=findViewById(R.id.buttonorder1);
        buttonorder2=findViewById(R.id.buttonorder2);
        buttonorder3=findViewById(R.id.buttonorder3);

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,Mainnewgui3.class));
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,Mainnewgui2.class));
            }
        });

        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,Mainnewgui1.class));
            }
        });

        imageButtonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this, MainActivity.class));
            }
        });

        imageButtonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,Mainnewgui1.class));
            }
        });

        imageButtonbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this, BarMenuPage2Activity.class));
            }
        });

        imageButtonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this, MyLatestOrderActivity.class));
            }
        });

        buttonorder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this, AddOrderActivity.class));
            }
        });

        buttonorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,AddOrderActivity.class));
            }
        });

        buttonorder3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui2.this,AddOrderActivity.class));
            }
        });



    }
}