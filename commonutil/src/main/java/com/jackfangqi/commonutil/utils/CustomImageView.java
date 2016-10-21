package com.jackfangqi.commonutil.utils;

/**
 * Created by Jack Fang on 2016/10/21, 14:59.
 * Project: CommonUtils
 * Compiler: Android Studio
 * Email: jackfangqi1314@gmail.com
 */

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.jackfangqi.commonutil.R;

/**
 * 自定义ImageView
 */
public class CustomImageView extends View {

    private static final int TYPE_CIRCLE = 0;

    private static final int TYPE_ROUND = 1;

    private int type;

    private Bitmap mSrc;

    private int mRadius;

    private int mWidth;

    private int mHeight;

    public CustomImageView(Context context) {
        this(context, null);
    }

    public CustomImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.CustomImageView, defStyleAttr, 0);
        int indexCount = a.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomImageView_src:
                    mSrc = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;

                case R.styleable.CustomImageView_type:
                    type = a.getInt(attr, 0);
                    break;

                case R.styleable.CustomImageView_borderRadius:
                    mRadius = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                            10f, getResources().getDisplayMetrics()));
                    break;
            }
        }
        a.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int specMode = MeasureSpec.getMode(widthMeasureSpec);
        int specSize = MeasureSpec.getSize(widthMeasureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            mWidth = specSize;
        } else {
            int desireWidth = getPaddingLeft() + getPaddingRight() + mSrc.getWidth();
            if (specMode == MeasureSpec.AT_MOST) {
                mWidth = Math.min(desireWidth, specSize);
            } else {
                mWidth = desireWidth;
            }
        }

        specMode = MeasureSpec.getMode(heightMeasureSpec);
        specSize = MeasureSpec.getSize(heightMeasureSpec);
        if (specMode == MeasureSpec.EXACTLY) {
            mHeight = specSize;
        } else {
            int desireHeight = getPaddingTop() + getPaddingBottom() + mSrc.getHeight();
            if (specMode == MeasureSpec.AT_MOST) {
                mHeight = Math.min(desireHeight, specSize);
            } else {
                mHeight = desireHeight;
            }
        }

        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        switch (type) {
            case TYPE_CIRCLE:
                int min = Math.min(mWidth, mHeight);
                mSrc = Bitmap.createScaledBitmap(mSrc, min, min, false);
                canvas.drawBitmap(createCircleBitmap(mSrc, min), 0, 0, null);
                break;

            case TYPE_ROUND:
                canvas.drawBitmap(createRoundBitmap(mSrc), 0, 0, null);
                break;

            default:
                super.onDraw(canvas);
                break;
        }
    }

    private Bitmap createCircleBitmap(Bitmap source, int min) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap output = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(min / 2, min / 2, min / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return output;
    }

    private Bitmap createRoundBitmap(Bitmap source) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap output = Bitmap.createBitmap(mWidth, mHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        RectF rect = new RectF(0, 0, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rect, mRadius, mRadius, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, 0, 0, paint);
        return output;
    }
}
