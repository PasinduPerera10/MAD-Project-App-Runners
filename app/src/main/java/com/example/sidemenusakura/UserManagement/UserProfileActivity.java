package com.example.sidemenusakura.UserManagement;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sidemenusakura.MainActivity;
import com.example.sidemenusakura.R;
import com.google.android.material.snackbar.Snackbar;

public class UserProfileActivity extends AppCompatActivity {
    TextView textViewUserName, textViewUserName1, textViewName, textViewContactNumber, textViewPassword, textViewEmail, textViewLogout;

    Button btnEditDetails, btnChangePassword, button2;

    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private LayoutInflater inflater;

    String textViewUsernameString;
    String textViewUsername1String;
    String textViewNameString;
    String textViewContactnumberString;
    String textViewEmailString;
    String textViewPasswordString;
    int textViewID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userprofile);
        textViewUserName = findViewById(R.id.textViewUserName);
        textViewUserName1 = findViewById(R.id.textViewUserName1);
        textViewName = findViewById(R.id.textViewName);
        textViewContactNumber = findViewById(R.id.textViewContactNumber);
        textViewPassword = findViewById(R.id.textViewPassword);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewLogout = findViewById(R.id.textViewLogout);
        textViewLogout = findViewById(R.id.textViewLogout);
        button2 = findViewById(R.id.button2);

        final Bundle b = getIntent().getExtras();


        textViewID = Integer.parseInt(b.getString("textViewId"));
        textViewUsernameString = b.getString("textViewUsername");
        textViewUsername1String = b.getString("textViewUsername");
        textViewNameString = b.getString("textViewName");
        textViewContactnumberString = b.getString("textViewContactnumber");
        textViewEmailString = b.getString("textViewEmail");
        textViewPasswordString = b.getString("textViewPassword");


        Log.d("Data", String.valueOf(textViewID));
        Log.d("Data", "User name: " + textViewUsernameString);
        Log.d("Data", "name1: " + textViewUsername1String);
        Log.d("Data", "name: " + textViewNameString);
        Log.d("Data", "Contact number: " + textViewContactnumberString);
        Log.d("Data", "Email: " + textViewEmailString);
        Log.d("Data", "password: " + textViewPasswordString);

        textViewUserName.setText("Welcome " + textViewUsernameString);
        textViewUserName1.setText(textViewUsername1String);
        textViewName.setText(textViewNameString);
        textViewContactNumber.setText(textViewContactnumberString);
        textViewPassword.setText(textViewPasswordString);
        textViewEmail.setText(textViewEmailString);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, MainActivity.class));
            }
        });

        textViewLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
            }
        });

        btnEditDetails = findViewById(R.id.btnEditDetails);
        btnEditDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editUserDidals();
            }
        });

        btnChangePassword = findViewById(R.id.btnChangePassword);
        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePassword();
            }
        });
    }

    public void changePassword() {
        alertDialogBuilder = new AlertDialog.Builder(UserProfileActivity.this);
        inflater = LayoutInflater.from(UserProfileActivity.this);
        final View view = inflater.inflate(R.layout.popup_password, null);
        final EditText editTextPasswordPopup = view.findViewById(R.id.editTextPasswordPopup);
        final EditText editTextConfPasswordPopup = view.findViewById(R.id.editTextConfPasswordPopup);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        final User user = new User();
        user.setId(textViewID);
        user.setUserName(textViewUsername1String);
        user.setName(textViewNameString);
        user.setContactNumber(textViewContactnumberString);
        user.setEmail(textViewEmailString);
        user.setPassword(textViewPasswordString);


        final DatabaseHelper db = new DatabaseHelper(UserProfileActivity.this);

        Button saveButtonPassword = view.findViewById(R.id.saveButtonPassword);

        saveButtonPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("check", editTextConfPasswordPopup.getText().toString());
                Log.d("check", editTextPasswordPopup.getText().toString());

                if (Integer.parseInt(editTextPasswordPopup.getText().toString()) == Integer.parseInt(editTextPasswordPopup.getText().toString()) ) {
                    user.setPassword(editTextPasswordPopup.getText().toString());
                    db.updateUser(user);
                    Toast.makeText(UserProfileActivity.this, "hi from if condition ", Toast.LENGTH_SHORT).show();
                    Snackbar.make(v, "Details Saved!", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
                } else{
                    Snackbar.make(view, "Don't save ", Snackbar.LENGTH_LONG).show();
                    Toast.makeText(UserProfileActivity.this, "what else ", Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();

            }
        });
    }


    public void editUserDidals() {
        alertDialogBuilder = new AlertDialog.Builder(UserProfileActivity.this);
        inflater = LayoutInflater.from(UserProfileActivity.this);
        final View view = inflater.inflate(R.layout.popup, null);
        final EditText editTextUsername = view.findViewById(R.id.editTextUsername);
        final EditText editTextName = view.findViewById(R.id.editTextName);
        final EditText editTextContactnumber = view.findViewById(R.id.editTextContactnumber);
        final EditText editTextEmail = view.findViewById(R.id.editTextEmail);

        alertDialogBuilder.setView(view);
        dialog = alertDialogBuilder.create();
        dialog.show();

        final User user = new User();
        user.setId(textViewID);
        user.setUserName(textViewUsername1String);
        user.setName(textViewNameString);
        user.setContactNumber(textViewContactnumberString);
        user.setEmail(textViewEmailString);
        user.setPassword(textViewPasswordString);

        editTextUsername.setText(user.getUserName());
        editTextName.setText(user.getName());
        editTextContactnumber.setText(user.getContactNumber());
        editTextEmail.setText(user.getEmail());

        final DatabaseHelper db = new DatabaseHelper(UserProfileActivity.this);

        Button saveButton = view.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(editTextUsername.getText().toString());
                user.setName(editTextName.getText().toString());
                user.setContactNumber(editTextContactnumber.getText().toString());
                user.setEmail(editTextEmail.getText().toString());


                if (!editTextUsername.getText().toString().isEmpty()
                        && !editTextName.getText().toString().isEmpty()
                        && !editTextContactnumber.getText().toString().isEmpty()
                        && !editTextEmail.getText().toString().isEmpty()) {
                    db.updateUser(user);
                    Snackbar.make(v, "Details Saved!", Snackbar.LENGTH_LONG).show();
                    startActivity(new Intent(UserProfileActivity.this, LoginActivity.class));
                } else {
                    Snackbar.make(view, "Don't save ", Snackbar.LENGTH_LONG).show();
                }
                dialog.dismiss();

            }
        });
    }
}
