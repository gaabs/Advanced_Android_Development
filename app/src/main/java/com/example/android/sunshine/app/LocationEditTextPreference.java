package com.example.android.sunshine.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.preference.EditTextPreference;
import android.util.AttributeSet;
import android.util.Log;
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
}
