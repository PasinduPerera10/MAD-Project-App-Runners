package com.example.sidemenusakura.OrderManagement;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidemenusakura.R;

import java.util.List;

public class ViewOrderActivity extends AppCompatActivity {




    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);





        DatabaseHelperClass databaseHelperClass = new DatabaseHelperClass(this);
        List<OrderModelClass> orderModelClasses = databaseHelperClass.getEmployeeList();

        if (orderModelClasses.size() > 0){
            OrderAdapterClass employeeadapterclass = new OrderAdapterClass(orderModelClasses, ViewOrderActivity.this);
            recyclerView.setAdapter(employeeadapterclass);
        }else {
            Toast.makeText(this, "There is no orders in the cart", Toast.LENGTH_SHORT).show();
        }


    }

}

