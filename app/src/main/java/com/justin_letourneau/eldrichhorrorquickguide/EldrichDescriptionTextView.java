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
        init(context, null);
    }

    public EldrichDescriptionTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public EldrichDescriptionTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public void init(Context context, AttributeSet attrs){
        try {
            Integer textStyle = attrs.getAttributeIntValue("http://schemas.android.com/apk/res/android", "textStyle", 0);
            Log.d("FontFace", textStyle.toString());
            Typeface typeface = null;
            switch (textStyle){
                case Typeface.ITALIC:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arapey-Italic.ttf");
                break;
                default:
                    typeface = Typeface.createFromAsset(context.getAssets(), "fonts/Arapey-Regular.ttf");
                break;
            }
            setTypeface(typeface, 1);
        } catch (Exception e){
            Log.e("FontFace", e.toString());
        }
    }


}
