package com.karan.unifynd.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.karan.unifynd.R;


public class CustomDialog extends Dialog {

    private CustomDialog(@NonNull Context context) {
        super(context);
    }

    // Create an instance of the Dialog with the input
    public static CustomDialog newInstance(Context ctx) {
      CustomDialog dialog = new CustomDialog(ctx);
        dialog.setContentView(R.layout.custom_dialog);
        return dialog;
    }

    public CustomDialog setTitle(String title){
        ((TextView) this.findViewById(R.id.title_tv)).setText(title);
        return this;
    }

    public CustomDialog setImage(int icon){
        ((ImageView) this.findViewById(R.id.imageView_dialog)).setImageResource(icon);
        return this;
    }

    public CustomDialog setMessage(String message){
        ((TextView) this.findViewById(R.id.message_tv)).setText(message);
        return this;
    }

    // interface to handle the dialog click back to the Activity
    public interface OnPositiveClickListener {
        void onClick();
    }

    public interface OnNegativeClickListener {
        void onClick();
    }

}
