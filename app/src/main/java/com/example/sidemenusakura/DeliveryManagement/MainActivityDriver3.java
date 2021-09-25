package com.example.sidemenusakura.DeliveryManagement;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivityDriver3 extends AppCompatActivity {


//    private Button add;
    private ListView listView;
    private TextView count;
    Context context;
    private DbHandler dbHandler;
    private List<Delivery_Management> deliveryManagements;
    ImageButton add;

    Button button;
    Button button1;
    Button button3;
    Button button4;
    Button buttonback;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_driver3);
        context = this;

        dbHandler = new DbHandler(context);
        add = findViewById(R.id.add);
        listView = findViewById(R.id.delivery_managementlist);
        count = findViewById(R.id.delivery_managementcount);
        deliveryManagements = new ArrayList<>();

        deliveryManagements = dbHandler.getAllToDos();

        Delivery_ManagementAdapter adapter = new Delivery_ManagementAdapter(context,R.layout.activity_single_delivery_details, deliveryManagements);

        listView.setAdapter(adapter);


        button = findViewById(R.id.btndriver1);
        button1 = findViewById(R.id.btndriver2);
        button3 = findViewById(R.id.btndriver3);
        button4 = findViewById(R.id.btndriver4);
        buttonback = findViewById(R.id.btnback);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivityDriver1.class);
                startActivity(i);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivityDriver2.class);
                startActivity(i);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivityDriver3.class);
                startActivity(i);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),MainActivityDriver4.class);
                startActivity(i);
            }
        });

        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        //get delivery_management counts from the table
        int countTodo = dbHandler.countToDo();
        count.setText("You have "+countTodo+" delivery");


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context,AddDeliveryDetalis.class));
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                final Delivery_Management delivery_management = deliveryManagements.get(position);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
//                builder.setTitle(delivery_management.getCustomername());
                builder.setMessage(delivery_management.getAddress());
                builder.setTitle(delivery_management.getContactnumber());
//                builder.setMessage(delivery_management.getTotalprice());
                builder.setPositiveButton("Delivery Completed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delivery_management.setFinished(System.currentTimeMillis());
                        dbHandler.updateSingleToDo(delivery_management);
                        startActivity(new Intent(context, MainActivityDriver1.class));
                    }
                });

//                builder.setPositiveButton("Started", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        delivery_management.setStarted(System.currentTimeMillis());
//                        dbHandler.updateSingleToDo(delivery_management);
//                        startActivity(new Intent(context, MainActivityDriver1.class));
//                    }
//                });


                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dbHandler.deleteToDo(delivery_management.getId());
                        startActivity(new Intent(context, MainActivityDriver1.class));
                    }
                });
                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context,UpdateDeliveryDetails.class);
                        intent.putExtra("id",String.valueOf(delivery_management.getId()));
                        startActivity(intent);
                    }
                });
                builder.show();
            }
        });


    }
}