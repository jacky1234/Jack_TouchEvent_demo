package com.jack.jack_touchevent_demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by jack on 2016/6/28.
 */

public class MyViewGroup3 extends LinearLayout {
    public MyViewGroup3(Context context) {
        super(context);
    }

    public MyViewGroup3(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyViewGroup3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("jack", "MyViewGroup3:dispatchTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("jack", "MyViewGroup3:dispatchTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("jack", "MyViewGroup3:dispatchTouchEvent->ACTION_UP");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("jack", "MyViewGroup3:onInterceptTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("jack", "MyViewGroup3:onInterceptTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("jack", "MyViewGroup3:onInterceptTouchEvent->ACTION_UP");
                break;
        }
        return true;      //默认返回 false
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i("jack", "MyViewGroup3:onTouchEvent->ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i("jack", "MyViewGroup3:onTouchEvent->ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i("jack", "MyViewGroup3:onTouchEvent->ACTION_UP");
                break;
        }
        return false;
    }
}
