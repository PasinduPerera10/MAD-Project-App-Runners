package com.example.sidemenusakura.BarMenuManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.FoodDeliveryManagement.MyLatestOrderActivity;
import com.example.sidemenusakura.FoodMenuManagement.Mainnewgui1;
import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.OrderManagement.AddOrderActivity;
import com.example.sidemenusakura.R;

public class BarMenuPage3Activity extends AppCompatActivity {

    Button button31, button32, buttonorder1, buttonorder2;
    ImageView imageButtonhome,imageButtonfood, imageButtonbar, imageButtonorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barmenupage3);

        button31=findViewById(R.id.button31);
        button32=findViewById(R.id.button32);
        imageButtonhome=findViewById(R.id.imageButtonhome);
        imageButtonfood=findViewById(R.id.imageButtonfood);
        imageButtonbar=findViewById(R.id.imageButtonbar);
        imageButtonorder=findViewById(R.id.imageButtonorder);
        buttonorder1=findViewById(R.id.buttonorder1);
        buttonorder2=findViewById(R.id.buttonorder2);

        button31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, BarMenuPage2Activity.class));
            }
        });

        button32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, BarMenuPage3Activity.class));
            }
        });

        imageButtonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, MainActivity.class));
            }
        });

        imageButtonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this,Mainnewgui1.class));
            }
        });

        imageButtonbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, BarMenuPage2Activity.class));
            }
        });

        imageButtonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, MyLatestOrderActivity.class));
            }
        });

        buttonorder1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this, AddOrderActivity.class));
            }
        });

        buttonorder2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BarMenuPage3Activity.this,AddOrderActivity.class));
            }
        });

    }
}