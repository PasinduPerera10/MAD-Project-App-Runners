package com.example.sidemenusakura.FoodDeliveryManagement;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.sidemenusakura.R;

import java.util.List;

public class Delivery_ManagementAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    List<Delivery_Management> delivery_managements;

    Delivery_ManagementAdapter(Context context, int resource, List<Delivery_Management> delivery_managements){
        super(context,resource,delivery_managements);
        this.context = context;
        this.resource = resource;
        this.delivery_managements = delivery_managements;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView customername = row.findViewById(R.id.customername);
//        TextView address = row.findViewById(R.id.address);
//        TextView contactnumber = row.findViewById(R.id.contactnumber);
        TextView totalprice = row.findViewById(R.id.totalprice);
        TextView orderconfirm = row.findViewById(R.id.onFinished);
        TextView Deliveryconfirm = row.findViewById(R.id.onStarted);


        // delivery_managements [obj1,obj2,obj3]
        Delivery_Management deliveryManagement = delivery_managements.get(position);
        customername.setText(deliveryManagement.getCustomername());
//        address.setText(deliveryManagement.getAddress());
//        contactnumber.setText(deliveryManagement.getContactnumber());
        totalprice.setText(deliveryManagement.getTotalprice());
        orderconfirm.setVisibility(row.INVISIBLE);
        Deliveryconfirm.setVisibility(row.VISIBLE);

        if(deliveryManagement.getFinished() > 0){
            orderconfirm.setVisibility(View.VISIBLE);
        }else if(deliveryManagement.getStarted() > 0){
            Deliveryconfirm.setVisibility(View.INVISIBLE);

        }
        return row;
    }


}

