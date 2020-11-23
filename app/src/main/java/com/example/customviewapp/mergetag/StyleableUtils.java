package com.example.customviewapp.mergetag;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customviewapp.R;

import java.util.StringJoiner;

class StyleableUtils {
    private StyleableUtils() {
    }

    static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] attrs) {
        return context.obtainStyledAttributes(attributeSet, attrs);
    }

    static DefaultAttributes getDefaultAttributes(Context context, AttributeSet attributeSet) {
        TypedArray ta = obtainStyledAttributes(context, attributeSet, DefaultAttributes.STYLEABLE);
//        TypedArray ta = context.obtainStyledAttributes(attributeSet, DefaultAttributes.STYLEABLE);
        DefaultAttributes defaultAttributes = new DefaultAttributes();
        try {
            defaultAttributes.textObtained = ta.hasValueOrEmpty(DefaultAttributes.STYLEABLE_TEXT);
            boolean hasValue = ta.hasValue(DefaultAttributes.STYLEABLE_TEXT);
            boolean hasValueOrEmpty = ta.hasValueOrEmpty(DefaultAttributes.STYLEABLE_TEXT);
            if (defaultAttributes.textObtained) {
                defaultAttributes.text = ta.getString(DefaultAttributes.STYLEABLE_TEXT);
            }
            Log.d(StyleableUtils.class.getSimpleName(), "[CUSTOM_ATTR_TEST]hasValue=" + hasValue + ", hasValueOrEmpty=" + hasValueOrEmpty + ", text=" + defaultAttributes.text);

            defaultAttributes.srcObtained = ta.hasValueOrEmpty(DefaultAttributes.STYLEABLE_SRC);
            if (defaultAttributes.srcObtained) {
                defaultAttributes.src = ta.getResourceId(DefaultAttributes.STYLEABLE_SRC, -1);
            }

            defaultAttributes.backgroundObtained = ta.hasValueOrEmpty(DefaultAttributes.STYLEABLE_BACKGROUND);
            if (defaultAttributes.backgroundObtained) {
                defaultAttributes.background = ta.getResourceId(DefaultAttributes.STYLEABLE_BACKGROUND, -1);
            }
        } finally {
            ta.recycle();
        }
        return defaultAttributes;
    }

    static void setText(@NonNull View view, @Nullable String text) {
        setText(view, text, null);
    }

    static void setText(@NonNull View view, @Nullable String text, @Nullable DefaultAttributes defaultAttributes) {
        if (view instanceof TextView) {
            ((TextView)view).setText(((defaultAttributes != null) && defaultAttributes.textObtained) ? defaultAttributes.text : text);
        }
    }

    static void setSrc(@NonNull View view, @DrawableRes int res) {
        setSrc(view, res, null);
    }

    static void setSrc(@NonNull View view, @DrawableRes int res, @Nullable DefaultAttributes defaultAttributes) {
        if (view instanceof ImageView) {
            ((ImageView)view).setImageResource(((defaultAttributes != null) && defaultAttributes.srcObtained) ? defaultAttributes.src : res);
        }
    }

    static void setBackground(@NonNull View view, @DrawableRes int res) {
        setBackground(view, res, null);
    }

    static void setBackground(@NonNull View view, @DrawableRes int res, @Nullable DefaultAttributes defaultAttributes) {
        view.setBackgroundResource(((defaultAttributes != null) && defaultAttributes.backgroundObtained) ? defaultAttributes.background : res);
    }


    static class DefaultAttributes {
        @StyleableRes
        private static final int[] STYLEABLE = R.styleable.DefaultStyleable;
        @StyleableRes
        private static final int STYLEABLE_TEXT = R.styleable.DefaultStyleable_android_text;
        @StyleableRes
        private static final int STYLEABLE_SRC = R.styleable.DefaultStyleable_android_src;
        @StyleableRes
        private static final int STYLEABLE_BACKGROUND = R.styleable.DefaultStyleable_android_background;
        boolean textObtained;
        @Nullable
        String text;
        boolean srcObtained;
        @IdRes
        int src;
        boolean backgroundObtained;
        @IdRes
        int background;

        @Override
        public String toString() {
            return new StringJoiner(", ", DefaultAttributes.class.getSimpleName() + "[", "]")
                    .add("textObtained=" + textObtained)
                    .add("text='" + text + "'")
                    .add("srcObtained=" + srcObtained)
                    .add("src=" + src)
                    .add("backgroundObtained=" + backgroundObtained)
                    .add("background=" + background)
                    .toString();
        }
    }
}
