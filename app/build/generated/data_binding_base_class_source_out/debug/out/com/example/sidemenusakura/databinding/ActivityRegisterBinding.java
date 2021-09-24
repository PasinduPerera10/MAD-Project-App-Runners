// Generated by view binder compiler. Do not edit!
package com.example.sidemenusakura.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.sidemenusakura.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonRegister;

  @NonNull
  public final EditText editTextCnfPassword;

  @NonNull
  public final EditText editTextContactnumber;

  @NonNull
  public final EditText editTextEmail;

  @NonNull
  public final EditText editTextName;

  @NonNull
  public final EditText editTextPassword;

  @NonNull
  public final EditText editTextUsername;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView36;

  @NonNull
  public final TextView textViewLogin;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonRegister, @NonNull EditText editTextCnfPassword,
      @NonNull EditText editTextContactnumber, @NonNull EditText editTextEmail,
      @NonNull EditText editTextName, @NonNull EditText editTextPassword,
      @NonNull EditText editTextUsername, @NonNull TextView textView3, @NonNull TextView textView36,
      @NonNull TextView textViewLogin) {
    this.rootView = rootView;
    this.buttonRegister = buttonRegister;
    this.editTextCnfPassword = editTextCnfPassword;
    this.editTextContactnumber = editTextContactnumber;
    this.editTextEmail = editTextEmail;
    this.editTextName = editTextName;
    this.editTextPassword = editTextPassword;
    this.editTextUsername = editTextUsername;
    this.textView3 = textView3;
    this.textView36 = textView36;
    this.textViewLogin = textViewLogin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonRegister;
      Button buttonRegister = rootView.findViewById(id);
      if (buttonRegister == null) {
        break missingId;
      }

      id = R.id.editTextCnfPassword;
      EditText editTextCnfPassword = rootView.findViewById(id);
      if (editTextCnfPassword == null) {
        break missingId;
      }

      id = R.id.editTextContactnumber;
      EditText editTextContactnumber = rootView.findViewById(id);
      if (editTextContactnumber == null) {
        break missingId;
      }

      id = R.id.editTextEmail;
      EditText editTextEmail = rootView.findViewById(id);
      if (editTextEmail == null) {
        break missingId;
      }

      id = R.id.editTextName;
      EditText editTextName = rootView.findViewById(id);
      if (editTextName == null) {
        break missingId;
      }

      id = R.id.editTextPassword;
      EditText editTextPassword = rootView.findViewById(id);
      if (editTextPassword == null) {
        break missingId;
      }

      id = R.id.editTextUsername;
      EditText editTextUsername = rootView.findViewById(id);
      if (editTextUsername == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = rootView.findViewById(id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView36;
      TextView textView36 = rootView.findViewById(id);
      if (textView36 == null) {
        break missingId;
      }

      id = R.id.textViewLogin;
      TextView textViewLogin = rootView.findViewById(id);
      if (textViewLogin == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, buttonRegister,
          editTextCnfPassword, editTextContactnumber, editTextEmail, editTextName, editTextPassword,
          editTextUsername, textView3, textView36, textViewLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}