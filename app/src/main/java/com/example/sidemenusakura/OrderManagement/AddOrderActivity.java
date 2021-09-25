package com.example.sidemenusakura.OrderManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class AddOrderActivity extends AppCompatActivity {

    EditText editText_name,editText_quantity,editText_delivery;
    Button button_add,button_view,button_deliver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addorder);

        editText_name = findViewById(R.id.edittext_name);
        editText_quantity = findViewById(R.id.edittext_quantity);
        editText_delivery = findViewById(R.id.edittext_delivery);

        button_add = findViewById(R.id.button_add);
        button_view = findViewById(R.id.button_viewd);
        button_deliver = findViewById(R.id.button_deliver);



        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = editText_name.getText().toString();
                String stringQuantity = editText_quantity.getText().toString();
                String stringDelivery = editText_delivery.getText().toString();

                if (stringName.length() <=0 || stringQuantity.length() <=0|| stringDelivery.length() <=0){
                    Toast.makeText(AddOrderActivity.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(AddOrderActivity.this);
                    OrderModelClass orderModelClass = new OrderModelClass(stringName,stringQuantity,stringDelivery);
                    databaseHelperClass.addEmployee(orderModelClass);
                    Toast.makeText(AddOrderActivity.this, "Add Order Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddOrderActivity.this, ViewOrderActivity.class);
                startActivity(intent);
            }
        });

        button_deliver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddOrderActivity.this, orderdeliveryActivity.class);
                startActivity(intent);
            }
        });



    }
}
