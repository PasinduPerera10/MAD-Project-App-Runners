package com.example.sidemenusakura.FoodDeliveryManagement;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class UpdateDeliveryDetails extends AppCompatActivity {


    private EditText customername,address,contactnumber,totalprice;
    private Button edit;
    private DbHandler dbHandler;
    private Context context;
    private Long updateDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delivery_details);

        context = this;
        dbHandler = new DbHandler(context);

        customername = findViewById(R.id.editTextCustomerName);
        address = findViewById(R.id.editTextAddress);
        contactnumber = findViewById(R.id.editTextContactNumber);
        totalprice = findViewById(R.id.editTextTotalPrice);
        edit = findViewById(R.id.buttonEdit);


        final String id = getIntent().getStringExtra("id");
        Delivery_Management delivery_management = dbHandler.getSingleToDo(Integer.parseInt(id));

        customername.setText(delivery_management.getCustomername());
        address.setText(delivery_management.getAddress());
        contactnumber.setText(delivery_management.getContactnumber());
        totalprice.setText(delivery_management.getTotalprice());

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String CustomerNameText = customername.getText().toString();
                String AddressText = address.getText().toString();
                String ContatNumberText = contactnumber.getText().toString();
                String TotalPriceText = totalprice.getText().toString();
                updateDate = System.currentTimeMillis();

                Delivery_Management deliveryManagement = new Delivery_Management(Integer.parseInt(id),CustomerNameText,AddressText,ContatNumberText,TotalPriceText,updateDate,0);
                int state = dbHandler.updateSingleToDo(deliveryManagement);
                System.out.println(state);
                startActivity(new Intent(context, MainActivityDriver1.class));
            }
        });
    }
}