package com.justin_letourneau.eldrichhorrorquickguide;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Neil on 4/11/2016.
 */
public class EldrichDescriptionTextView extends TextView{

    public EldrichDescriptionTextView(Context context) {
        super(context);
        init(context);
    }

    public EldrichDescriptionTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public EldrichDescriptionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arapey-Italic.ttf");
            setTypeface(typeface, 1);
        } catch (Exception e){
            Log.e("FontFace", e.toString());
        }
    }
}
