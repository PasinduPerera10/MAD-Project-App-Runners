package com.example.sidemenusakura.FoodMenuManagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.R;

public class AddFoodItem extends AppCompatActivity {

    EditText editText_price,editText_description;
    Button button_additem,button_viewitem,button_viewitem1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfooditem);

        editText_price = findViewById(R.id.edittext_price);
        editText_description = findViewById(R.id.edittext_description);
        button_additem = findViewById(R.id.button_additem);
        button_viewitem = findViewById(R.id.button_viewitem);
//        button_viewitem1 = findViewById(R.id.button_viewitem1);


        button_additem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringPrice = editText_price.getText().toString();
                String stringDescription = editText_description.getText().toString();

                if (stringPrice.length() <=0 || stringDescription.length() <=0){
                    Toast.makeText(AddFoodItem.this, "Enter All Data", Toast.LENGTH_SHORT).show();
                }else {
                    DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(AddFoodItem.this);
                    FoodItemModelClass foodItemModelClass = new FoodItemModelClass(stringPrice,stringDescription);
                    databaseHelperClass.addEmployee(foodItemModelClass);
                    Toast.makeText(AddFoodItem.this, "Add Employee Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(getIntent());
                }
            }
        });


        button_viewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddFoodItem.this, ViewFoodItemList.class);
                startActivity(intent);
            }
        });

//        button_viewitem1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,ViewEmployeeActivity.class);
//                startActivity(intent);
//            }
//        });



    }
}
