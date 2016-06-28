package com.jack.jack_touchevent_demo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by jack on 2016/6/28.
 */

public class MyViewGroup1 extends LinearLayout {
    public MyViewGroup1(Context context) {
        super(context);
    }

    public MyViewGroup1(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup1(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("jack", "MyViewGroup1:dispatchTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("jack", "MyViewGroup1:dispatchTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("jack", "MyViewGroup1:dispatchTouchEvent->ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("jack", "MyViewGroup1:onInterceptTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("jack", "MyViewGroup1:onInterceptTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("jack", "MyViewGroup1:onInterceptTouchEvent->ACTION_UP");
                break;
        }
        return false;      //默认返回 false
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.e("jack", "MyViewGroup1:onTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.e("jack", "MyViewGroup1:onTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.e("jack", "MyViewGroup1:onTouchEvent->ACTION_UP");
                break;
        }
        return true;
    }
}
