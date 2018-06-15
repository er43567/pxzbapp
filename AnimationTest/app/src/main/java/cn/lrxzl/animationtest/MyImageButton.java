package cn.lrxzl.animationtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ImageButton;

/**
 * Created by lrx on 2018/6/12.
 */

public class MyImageButton extends android.support.v7.widget.AppCompatImageView {

    Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            invalidate();
        }
    };

    Thread thread;
    Paint paint = new Paint();
    int t = 0;
    int color = Color.BLACK;

    float r;
    float R0 = 100;
    float R1 = 150;

    float A0 = 100;
    float A1 = 150;

    float speed = 1.0f;

    public MyImageButton(Context context) {
        super(context);
        startThread();
    }

    public MyImageButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        startThread();
    }

    public MyImageButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        startThread();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(color);
        paint.setAlpha((int)(A0 + Math.abs(Math.sin(1.0f * t / 10)) * A1));


        //r = R0 + (float) (Math.abs(Math.sin(1.0f * t / 10)) * (R1-R0));
        r -= speed;
        canvas.drawCircle(this.getLeft() + this.getWidth()/2
                ,this.getTop() + this.getHeight()/2, r, paint);
        t++;
        super.onDraw(canvas);
    }


    public void setRadius(float r) {
        this.r = r;
        invalidate();
    }

    public void setFadeSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * 变化时最小半径
     * 默认100 到 150
     * @param r
     */
    public void fromRadius(float r) {
        this.R0 = r;
    }

    /**
     * 变化时最大半径
     * 默认100 到 150
     * @param r
     */
    public void toRadius(float r) {
        this.R1 = r;
    }

    /**
     * 变化时最小Alpha
     * 默认100 到 150
     * @param alpha
     */
    public void fromAlpha(int alpha) {
        this.A0 = alpha;
    }

    /**
     * 变化时最大Alpha
     * @param alpha
     */
    public void toAlpha(int alpha) {
        this.A1 = alpha;
    }

    /**
     * 变化时的颜色
     * 默认黑色
     * @param color
     */
    public void setAnimColor(int color) {
        this.color = color;
    }


    private void startThread() {
        if (thread == null) {
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (;;) {
                        handler.sendEmptyMessage(0);
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thread.start();
        }
    }

}
