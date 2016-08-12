package com.example.android.sunshine.app;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by gaabs on 11/08/16.
 */
public class LocationEditTextPreference extends EditTextPreference{
    private int mMinLength;
    private static final int DEFAULT_MIN_LENGTH = 2;

    public LocationEditTextPreference(Context context, AttributeSet attrs){
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(
            attrs,
            R.styleable.LocationEditText,
            0, 0);

        try {
            mMinLength = a.getInteger(R.styleable.LocationEditText_minLength, DEFAULT_MIN_LENGTH);
            Log.i(this.getClass().toString(), "Min len: " + mMinLength);
        } finally {
            a.recycle();
        }

    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        EditText editText = getEditText();
        final Dialog dialog = getDialog();


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                AlertDialog alertDialog = null;
                if (dialog instanceof AlertDialog){
                    alertDialog = (AlertDialog) dialog;
                }

                if (alertDialog != null) {
                    Button positiveButton = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    if (editable.length() >= mMinLength) {
                        positiveButton.setEnabled(true);
                    } else {
                        positiveButton.setEnabled(false);
                    }
                }
            }
        });
    }
}
