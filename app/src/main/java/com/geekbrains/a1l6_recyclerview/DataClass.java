package com.geekbrains.a1l6_recyclerview;

import android.graphics.drawable.Drawable;

public class DataClass {
    Drawable drawable;
    String text;
    boolean isChecked;

    DataClass(Drawable drawable, String text, boolean isChecked) {
        this.drawable = drawable;
        this.text = text;
        this.isChecked = isChecked;
    }
}
