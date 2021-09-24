// Generated by view binder compiler. Do not edit!
package com.example.sidemenusakura.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.sidemenusakura.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainDriver1Binding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton add;

  @NonNull
  public final Button btnback;

  @NonNull
  public final Button btndriver1;

  @NonNull
  public final Button btndriver2;

  @NonNull
  public final Button btndriver3;

  @NonNull
  public final Button btndriver4;

  @NonNull
  public final TextView deliveryManagementcount;

  @NonNull
  public final ListView deliveryManagementlist;

  @NonNull
  public final TextView textView;

  @NonNull
  public final TextView textView10;

  @NonNull
  public final TextView textView15;

  @NonNull
  public final TextView textView5;

  @NonNull
  public final TextView textView9;

  private ActivityMainDriver1Binding(@NonNull ConstraintLayout rootView, @NonNull ImageButton add,
      @NonNull Button btnback, @NonNull Button btndriver1, @NonNull Button btndriver2,
      @NonNull Button btndriver3, @NonNull Button btndriver4,
      @NonNull TextView deliveryManagementcount, @NonNull ListView deliveryManagementlist,
      @NonNull TextView textView, @NonNull TextView textView10, @NonNull TextView textView15,
      @NonNull TextView textView5, @NonNull TextView textView9) {
    this.rootView = rootView;
    this.add = add;
    this.btnback = btnback;
    this.btndriver1 = btndriver1;
    this.btndriver2 = btndriver2;
    this.btndriver3 = btndriver3;
    this.btndriver4 = btndriver4;
    this.deliveryManagementcount = deliveryManagementcount;
    this.deliveryManagementlist = deliveryManagementlist;
    this.textView = textView;
    this.textView10 = textView10;
    this.textView15 = textView15;
    this.textView5 = textView5;
    this.textView9 = textView9;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainDriver1Binding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainDriver1Binding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main_driver1, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainDriver1Binding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.add;
      ImageButton add = rootView.findViewById(id);
      if (add == null) {
        break missingId;
      }

      id = R.id.btnback;
      Button btnback = rootView.findViewById(id);
      if (btnback == null) {
        break missingId;
      }

      id = R.id.btndriver1;
      Button btndriver1 = rootView.findViewById(id);
      if (btndriver1 == null) {
        break missingId;
      }

      id = R.id.btndriver2;
      Button btndriver2 = rootView.findViewById(id);
      if (btndriver2 == null) {
        break missingId;
      }

      id = R.id.btndriver3;
      Button btndriver3 = rootView.findViewById(id);
      if (btndriver3 == null) {
        break missingId;
      }

      id = R.id.btndriver4;
      Button btndriver4 = rootView.findViewById(id);
      if (btndriver4 == null) {
        break missingId;
      }

      id = R.id.delivery_managementcount;
      TextView deliveryManagementcount = rootView.findViewById(id);
      if (deliveryManagementcount == null) {
        break missingId;
      }

      id = R.id.delivery_managementlist;
      ListView deliveryManagementlist = rootView.findViewById(id);
      if (deliveryManagementlist == null) {
        break missingId;
      }

      id = R.id.textView;
      TextView textView = rootView.findViewById(id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.textView10;
      TextView textView10 = rootView.findViewById(id);
      if (textView10 == null) {
        break missingId;
      }

      id = R.id.textView15;
      TextView textView15 = rootView.findViewById(id);
      if (textView15 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = rootView.findViewById(id);
      if (textView5 == null) {
        break missingId;
      }

      id = R.id.textView9;
      TextView textView9 = rootView.findViewById(id);
      if (textView9 == null) {
        break missingId;
      }

      return new ActivityMainDriver1Binding((ConstraintLayout) rootView, add, btnback, btndriver1,
          btndriver2, btndriver3, btndriver4, deliveryManagementcount, deliveryManagementlist,
          textView, textView10, textView15, textView5, textView9);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}