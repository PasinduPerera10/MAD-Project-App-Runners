package com.example.sidemenusakura.OrderManagement;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sidemenusakura.R;

import java.util.List;


public class OrderAdapterClass extends RecyclerView.Adapter<OrderAdapterClass.ViewHolder> {

    List<OrderModelClass> employee;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public OrderAdapterClass(List<OrderModelClass> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.order_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final OrderModelClass orderModelClass = employee.get(position);

        holder.textViewID.setText(Integer.toString(orderModelClass.getId()));
        holder.editText_Name.setText(orderModelClass.getName());
        holder.editText_Quantity.setText(orderModelClass.getQuantity());
        holder.editText_Delivery.setText(orderModelClass.getDelivery());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringName = holder.editText_Name.getText().toString();
                String stringQuantity = holder.editText_Quantity.getText().toString();
                String stringDelivery = holder.editText_Delivery.getText().toString();

                databaseHelperClass.updateEmployee(new OrderModelClass(orderModelClass.getId(),stringName,stringQuantity,stringDelivery));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(orderModelClass.getId());
                employee.remove(position);
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return employee.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        
        EditText editText_Quantity;
        Button button_payments;
        TextView textViewID;
        EditText editText_Name;
        EditText editText_Delivery;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_cart);
            editText_Name = itemView.findViewById(R.id.edittext_name);
            editText_Quantity = itemView.findViewById(R.id.edittext_quantity);
            editText_Delivery = itemView.findViewById(R.id.edittext_delivery);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);
            button_payments=itemView.findViewById(R.id.button_payments);

        }
    }
}


