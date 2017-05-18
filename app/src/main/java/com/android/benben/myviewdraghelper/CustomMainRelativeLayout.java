package com.android.benben.myviewdraghelper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

/**
 * Time      2017/5/17 15:21 .
 * Author   : LiYuanXiong.
 * Content  :右侧(主界面布局)
 */

public class CustomMainRelativeLayout extends RelativeLayout {
    private DragLayout dl;

    public CustomMainRelativeLayout(Context context) {
        super(context);
    }

    public CustomMainRelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomMainRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setDragLayout(DragLayout dl) {
        this.dl = dl;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        if (dl.getStatus() != DragLayout.Status.Close) {
            return true;
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (dl.getStatus() != DragLayout.Status.Close) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                dl.closeLeft();
            }
            return true;
        }
        return super.onTouchEvent(event);
    }
}
