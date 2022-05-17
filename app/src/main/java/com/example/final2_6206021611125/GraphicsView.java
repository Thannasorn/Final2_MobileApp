package com.example.final2_6206021611125;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

class GraphicsView extends View implements View.OnTouchListener {

    private int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;
    private int screenHeight = Resources.getSystem().getDisplayMetrics().heightPixels;

    private String drawType = "Line";
    private String colorText = "RED";

    private Paint mPaint, mPaintStroke,p1;
    private int Type =0;
    private int color =0;
    private float x1, x2,y1,y2;
    private boolean isDraw = false;
    private boolean isFirst = true;


    public GraphicsView(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        setOnTouchListener(this);
        mPaint = new Paint();
        mPaintStroke = new Paint();
        p1 = new Paint();

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float x = event.getX();
        float y = event.getY();

        if(x > 0 && x < 100){
            if(y > 0 && y < 100) {
                drawType = "Line";
                Type = 1;
            }
        }
        else if (x > 100 && x < 290){
            if(y > 0 && y < 100){
                drawType = "Rectangle";
                Type = 2;
            }
        }
        else if (x > 290 && x < 400){
            if(y > 0 && y < 100){
                drawType = "Circle";
                Type = 3;
            }
        }

        // Color Button
        if( x > screenWidth / 2 -250 && x < screenWidth / 2 - 100){
            if (y > 0 && y < 100){
                colorText = "RED";
                color = 1;
            }

        }
        else if (x > screenWidth / 2 - 100  && x < screenWidth / 2 + 50){
            if (y > 0 && y < 100){
                colorText = "GREEN";
                color = 2;
            }

        }
        else if (x > screenWidth / 2 + 50 && x < screenWidth + 200 ){
            if (y > 0 && y < 100){
                colorText = "BLUE";
                color = 3;
            }

        }

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            if (isFirst){
                x1 = event.getX();
                y1 = event.getY();
                isDraw = isFirst = false;
            }
            else {
                x2 = event.getX();
                y2 = event.getY();
                isDraw = true;
                isFirst = true;
            }
        }
        invalidate();
        Log.d("TYPE" , drawType);
        Log.d("COLOR" , colorText);
        Log.d("POSITION" , x + " x " + y);
        return true;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);

        mPaintStroke.setColor(Color.BLACK);
        mPaintStroke.setStyle(Paint.Style.STROKE);
        mPaintStroke.setStrokeWidth(4);

        canvas.drawRect(screenWidth / 2 + 380, 0, screenWidth, 100, mPaint);
        canvas.drawRect(screenWidth / 2 + 380, 0, screenWidth, 100, mPaintStroke);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("62-060216-1112-5 Thannasorn Metta", screenWidth / 2 + 390, 55, mPaint);
        // Line
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0 , 0 , 100 , 100 , mPaint);
        canvas.drawRect(0,0,100,100,mPaintStroke);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        canvas.drawText("LINE" , 24 , 60 , mPaint);

        // Rectangle
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(100 , 0 , 290 , 100 , mPaint);
        canvas.drawRect(100,0,290,100,mPaintStroke);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Rectangle" , 130 , 60 , mPaint);

        // Circle
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(290 , 0 , 400 , 100 , mPaint);
        canvas.drawRect(290,0,400,100,mPaintStroke);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.BLACK);
        canvas.drawText("Circle" , 300 , 60 , mPaint);

        // Type Rec
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(400 , 0 , 600 , 100 , mPaint);
        canvas.drawRect(400,0,600,100,mPaintStroke);
        mPaint.setTextSize(30);
        mPaint.setColor(Color.RED);
        canvas.drawText(drawType , 420 , 60 , mPaint);

        // Color Red
        mPaint.setColor(Color.RED);
        canvas.drawRect(screenWidth/2 -250 , 0 , screenWidth/2 - 100 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 -250 , 0 , screenWidth/2 - 100 , 100 , mPaintStroke);

        // Color Green
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(screenWidth/2 -100 , 0 , screenWidth/2 +50 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 -100 , 0 , screenWidth/2 +50, 100 , mPaintStroke);

        // Color Blue
        mPaint.setColor(Color.BLUE);
        canvas.drawRect(screenWidth/2 +50  , 0 , screenWidth/2 + 200 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 + 50 , 0 , screenWidth/2 + 200 , 100 , mPaintStroke);

        // Text Color
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(screenWidth/2 + 200  , 0 , screenWidth/2 + 350 , 100 , mPaint);
        canvas.drawRect(screenWidth/2 + 200 , 0 , screenWidth/2 + 350 , 100 , mPaintStroke);
        mPaint.setColor(Color.BLACK);
        mPaint.setTextSize(30);
        canvas.drawText(colorText , screenWidth / 2 + 220 , 60 , mPaint);

        if(Type == 1){
            if (color == 1){
                p1.setColor(Color.RED);
                p1.setStrokeWidth(3);
                if (isDraw){
                    canvas.drawLine(x1,y1,x2,y2,p1);
                }
            }
            else if (color == 2){
                p1.setColor(Color.GREEN);
                p1.setStrokeWidth(3);
                if (isDraw){
                    canvas.drawLine(x1,y1,x2,y2,p1);
                }
            }
            else if (color == 3){
                p1.setColor(Color.BLUE);
                p1.setStrokeWidth(3);
                if (isDraw){
                    canvas.drawLine(x1,y1,x2,y2,p1);
                }
            }
        }
        if(Type == 2){
            if (color == 1){
                p1.setColor(Color.RED);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawRect(x1,y1,x2,y2,p1);
                }
            }
            else if (color == 2){
                p1.setColor(Color.GREEN);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawRect(x1,y1,x2,y2,p1);
                }
            }
            else if (color == 3){
                p1.setColor(Color.BLUE);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawRect(x1,y1,x2,y2,p1);
                }
            }
        }
        if(Type == 3)
            if (color == 1){
                p1.setColor(Color.RED);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawCircle(x1,y1,100,p1);
                }
            }
            else if (color == 2){
                p1.setColor(Color.GREEN);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawCircle(x1,y1,100,p1);
                }
            }
            else if (color == 3){
                p1.setColor(Color.BLUE);
                p1.setStyle(Paint.Style.STROKE);
                if (isDraw){
                    canvas.drawCircle(x1,y1,100,p1);
                }
            }
        }
}
