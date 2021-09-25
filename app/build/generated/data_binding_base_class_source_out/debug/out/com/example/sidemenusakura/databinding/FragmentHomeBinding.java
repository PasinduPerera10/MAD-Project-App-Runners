// Generated by view binder compiler. Do not edit!
package com.example.sidemenusakura.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.example.sidemenusakura.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton imageButtonbar;

  @NonNull
  public final ImageButton imageButtonfood;

  @NonNull
  public final ImageButton imageButtonhome;

  @NonNull
  public final ImageButton imageButtonorder;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final TextView textView33;

  @NonNull
  public final TextView textView34;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageButton imageButtonbar, @NonNull ImageButton imageButtonfood,
      @NonNull ImageButton imageButtonhome, @NonNull ImageButton imageButtonorder,
      @NonNull ImageView imageView, @NonNull TextView textView33, @NonNull TextView textView34) {
    this.rootView = rootView;
    this.imageButtonbar = imageButtonbar;
    this.imageButtonfood = imageButtonfood;
    this.imageButtonhome = imageButtonhome;
    this.imageButtonorder = imageButtonorder;
    this.imageView = imageView;
    this.textView33 = textView33;
    this.textView34 = textView34;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageButtonbar;
      ImageButton imageButtonbar = rootView.findViewById(id);
      if (imageButtonbar == null) {
        break missingId;
      }

      id = R.id.imageButtonfood;
      ImageButton imageButtonfood = rootView.findViewById(id);
      if (imageButtonfood == null) {
        break missingId;
      }

      id = R.id.imageButtonhome;
      ImageButton imageButtonhome = rootView.findViewById(id);
      if (imageButtonhome == null) {
        break missingId;
      }

      id = R.id.imageButtonorder;
      ImageButton imageButtonorder = rootView.findViewById(id);
      if (imageButtonorder == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.textView33;
      TextView textView33 = rootView.findViewById(id);
      if (textView33 == null) {
        break missingId;
      }

      id = R.id.textView34;
      TextView textView34 = rootView.findViewById(id);
      if (textView34 == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, imageButtonbar, imageButtonfood,
          imageButtonhome, imageButtonorder, imageView, textView33, textView34);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
