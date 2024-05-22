package com.example.apppdmfizica;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class PendulumView extends View {

    private Paint paint;
    private float angle = (float) Math.PI / 4;
    private float angularVelocity = 0.0f;
    private float angularAcceleration = 0.0f;
    private float length = 500;
    private float gravity = 9.8f;
    private float originX;
    private float originY;
    private float bobX;
    private float bobY;
    private float bobRadius = 40;

    public PendulumView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(8);
        paint.setAntiAlias(true);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        originX = w / 2;
        originY = h / 4;
        updateBobPosition();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(originX, originY, bobX, bobY, paint);

        canvas.drawCircle(bobX, bobY, bobRadius, paint);

        updatePendulum();

        invalidate();
    }

    private void updateBobPosition() {
        bobX = originX + (float) (length * Math.sin(angle));
        bobY = originY + (float) (length * Math.cos(angle));
    }

    private void updatePendulum() {
        // Update the angular acceleration based on the angle
        angularAcceleration = (float) (-gravity / length * Math.sin(angle));

        // Update the angular velocity and angle
        angularVelocity += angularAcceleration;
        angle += angularVelocity;

        angularVelocity *= 0.99;

        updateBobPosition();
    }

    public void setLength(float length) {
        this.length = length;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setBobRadius(float bobRadius) {
        this.bobRadius = bobRadius;
    }

    public void resetPendulum() {
        angle = (float) Math.PI / 4;  // Reset to initial angle
        angularVelocity = 0.0f;
        angularAcceleration = 0.0f;
        updateBobPosition();
        invalidate();
    }
}
