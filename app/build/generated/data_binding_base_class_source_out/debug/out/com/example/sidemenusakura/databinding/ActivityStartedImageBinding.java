// Generated by view binder compiler. Do not edit!
package com.example.sidemenusakura.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public final class ActivityStartedImageBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final TextView textView16;

  @NonNull
  public final TextView textView17;

  @NonNull
  public final TextView textView18;

  private ActivityStartedImageBinding(@NonNull ConstraintLayout rootView,
      @NonNull ImageView imageView4, @NonNull TextView textView16, @NonNull TextView textView17,
      @NonNull TextView textView18) {
    this.rootView = rootView;
    this.imageView4 = imageView4;
    this.textView16 = textView16;
    this.textView17 = textView17;
    this.textView18 = textView18;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityStartedImageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityStartedImageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_started_image, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityStartedImageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageView4;
      ImageView imageView4 = rootView.findViewById(id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.textView16;
      TextView textView16 = rootView.findViewById(id);
      if (textView16 == null) {
        break missingId;
      }

      id = R.id.textView17;
      TextView textView17 = rootView.findViewById(id);
      if (textView17 == null) {
        break missingId;
      }

      id = R.id.textView18;
      TextView textView18 = rootView.findViewById(id);
      if (textView18 == null) {
        break missingId;
      }

      return new ActivityStartedImageBinding((ConstraintLayout) rootView, imageView4, textView16,
          textView17, textView18);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
