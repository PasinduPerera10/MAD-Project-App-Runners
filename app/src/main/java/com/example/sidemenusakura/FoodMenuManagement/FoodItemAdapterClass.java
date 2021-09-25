package com.example.sidemenusakura.FoodMenuManagement;

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

public class FoodItemAdapterClass extends RecyclerView.Adapter<FoodItemAdapterClass.ViewHolder> {

    List<FoodItemModelClass> employee;
    Context context;
    DatabaseHelperClass databaseHelperClass;

    public FoodItemAdapterClass(List<FoodItemModelClass> employee, Context context) {
        this.employee = employee;
        this.context = context;
        databaseHelperClass = new DatabaseHelperClass(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_item_list,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final FoodItemModelClass foodItemModelClass = employee.get(position);

        holder.textViewID.setText(Integer.toString(foodItemModelClass.getId()));
        holder.editText_Price.setText(foodItemModelClass.getPrice());
        holder.editText_Description.setText(foodItemModelClass.getDescription());

        holder.button_Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String stringPrice = holder.editText_Price.getText().toString();
                String stringDescription = holder.editText_Description.getText().toString();

                databaseHelperClass.updateEmployee(new FoodItemModelClass(foodItemModelClass.getId(),stringPrice,stringDescription));
                notifyDataSetChanged();
                ((Activity) context).finish();
                context.startActivity(((Activity) context).getIntent());
            }
        });

        holder.button_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelperClass.deleteEmployee(foodItemModelClass.getId());
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
        TextView textViewID;
        EditText editText_Price;
        EditText editText_Description;
        Button button_Edit;
        Button button_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewID = itemView.findViewById(R.id.text_id);
            editText_Price = itemView.findViewById(R.id.edittext_price);
            editText_Description = itemView.findViewById(R.id.edittext_description);
            button_delete = itemView.findViewById(R.id.button_delete);
            button_Edit = itemView.findViewById(R.id.button_edit);

        }
    }

public class ViewHolder1 extends RecyclerView.ViewHolder{
    TextView textViewID;
    EditText editText_Price;
    EditText editText_Description;
    Button button_Edit;
    Button button_delete;

    public ViewHolder1(@NonNull View itemView) {
        super(itemView);

        textViewID = itemView.findViewById(R.id.text_id);
        editText_Price = itemView.findViewById(R.id.edittext_price);
        editText_Description = itemView.findViewById(R.id.edittext_description);
        button_delete = itemView.findViewById(R.id.button_delete);
        button_Edit = itemView.findViewById(R.id.button_edit);

    }
}
}