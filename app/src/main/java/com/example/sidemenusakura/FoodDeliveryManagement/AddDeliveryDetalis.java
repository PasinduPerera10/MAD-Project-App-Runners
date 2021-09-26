package com.example.sidemenusakura.FoodDeliveryManagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class AddDeliveryDetalis extends AppCompatActivity {


    private EditText customername, address, contactnumber, totalprice;
    private Button add;
    private DbHandler dbHandler;
    private Context context;

    Button btnback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delivery_detalis);

        btnback = findViewById(R.id.btnback);






        customername = findViewById(R.id.editTextCustomerName);
        address = findViewById(R.id.editTextAddress);
        contactnumber = findViewById(R.id.editTextContactNumber);
        totalprice = findViewById(R.id.editTextTotalPrice);
        add = findViewById(R.id.buttonAdd);
        context = this;

        dbHandler = new DbHandler(context);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userCustomerName = customername.getText().toString();
                String userAddress = address.getText().toString();
                String userContactNumber = contactnumber.getText().toString();
                String userTotalPrice = totalprice.getText().toString();
//                long started = System.currentTimeMillis();

                Delivery_Management deliveryManagement = new Delivery_Management(userCustomerName,userAddress,userContactNumber,userTotalPrice,0,0);
                dbHandler.addToDo(deliveryManagement);

                startActivity(new Intent(context, MainActivityDriver1.class));
            }
        });

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivityDriver1.class);
                startActivity(i);
            }
        });


    }
}