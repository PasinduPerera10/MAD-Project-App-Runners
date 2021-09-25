package com.example.sidemenusakura.OrderManagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class payments extends AppCompatActivity {

    EditText editText_holder,editText_card,editText_date;
    Button button_savepay,button_viewpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);


        editText_holder = findViewById(R.id.edittext_holder);
        editText_card = findViewById(R.id.edittext_card);
        editText_date = findViewById(R.id.edittext_date);

        button_savepay = findViewById(R.id.button_savepayments);
        button_viewpay = findViewById(R.id.button_viewpayments);


        button_savepay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String stringHolder = editText_holder.getText().toString();
                String stringCard = editText_card.getText().toString();
                String stringDate = editText_date.getText().toString();

                if (stringHolder.length() <= 0 || stringCard.length() <= 0 || stringDate.length() <= 0) {
                    Toast.makeText(payments.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                } else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(payments.this);
                    OrderModelClass orderModelClass = new OrderModelClass(stringHolder, stringCard, stringDate);
                    databaseHelperClass.addEmployee(orderModelClass);
                    Toast.makeText(payments.this, "Add Order Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });





    }
}
