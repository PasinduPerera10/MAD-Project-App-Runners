package com.example.sidemenusakura.FoodMenuManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.BarMenuManagement.BarMenuPage2Activity;
import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.R;
import com.example.sidemenusakura.ui.home.HomeFragment;

public class Mainnewgui1 extends AppCompatActivity {
Button button22, button23, button25;
ImageView imageButtonhome,imageButtonfood, imageButtonbar, imageButtonorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnewgui1);

        button22=findViewById(R.id.button22);
        button23=findViewById(R.id.button23);
        button25=findViewById(R.id.button25);
        imageButtonhome=findViewById(R.id.imageButtonhome);
        imageButtonfood=findViewById(R.id.imageButtonfood);
        imageButtonbar=findViewById(R.id.imageButtonbar);
        imageButtonorder=findViewById(R.id.imageButtonorder);

        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this,Mainnewgui3.class));
            }
        });

        button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this,Mainnewgui2.class));
            }
        });

        button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this,Mainnewgui1.class));
            }
        });

        imageButtonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this, MainActivity.class));
            }
        });

        imageButtonfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this,Mainnewgui1.class));
            }
        });

        imageButtonbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this, BarMenuPage2Activity.class));
            }
        });

        imageButtonorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Mainnewgui1.this,Mainnewgui1.class));
            }
        });
    }
}