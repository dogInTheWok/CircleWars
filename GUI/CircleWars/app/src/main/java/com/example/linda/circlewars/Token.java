package com.example.linda.circlewars;

import android.content.Context;
import android.widget.ImageView;

/**
 * Created by Linda on 04.10.2014.
 */
public class Token extends ImageView {

    private boolean deployed;
    private int deployFieldId;

    public Token(Context context, boolean sent) {
        super(context, null);
        deployed = sent;
    }
}
