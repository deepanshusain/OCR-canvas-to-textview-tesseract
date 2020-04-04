package com.example.tesseractmodule3.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class WritingView extends View {

    public ViewGroup.LayoutParams params;
    private Path mpath;
    private Paint mpaint;
    public Canvas canvas;

    public WritingView(Context context)
    {
        super(context);
        init();

    }

    public WritingView(Context context, AttributeSet attrs){
        super(context, attrs);
        init();
    }

    private void init(){

        setDrawingCacheEnabled(true);
        setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mpaint = new Paint();
        mpaint.setAntiAlias(true);
        mpaint.setColor(Color.BLACK);
        mpaint.setStyle(Paint.Style.STROKE);
        mpaint.setStrokeJoin(Paint.Join.MITER);
        mpaint.setStrokeWidth(8f);
        mpath = new Path();
        params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        float pointx = event.getX();
        float pointy = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                mpath.moveTo(pointx,pointy);
                return true;
            case MotionEvent.ACTION_MOVE:
                mpath.lineTo(pointx,pointy);
                performClick();
                invalidate();
                return true;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
        canvas.drawPath(mpath, mpaint);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        Bitmap bm = Bitmap.createBitmap(w,h,Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bm);

    }

    public void ClearCanvas(){
        mpath.reset();
        postInvalidate();
    }
}

