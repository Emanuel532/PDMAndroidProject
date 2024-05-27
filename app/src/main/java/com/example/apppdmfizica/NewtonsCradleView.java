package com.example.apppdmfizica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class NewtonsCradleView extends View {

    private Paint paint;
    private int numPendulums;
    private float gravity;
    private float pendulumLength;
    private float[] angles;
    private float[] angularVelocities;
    private long lastUpdateTime;
    private boolean isSimulationRunning;

    public NewtonsCradleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.FILL);

        numPendulums = 2;
        gravity = 9.8f;
        pendulumLength = 200.0f;
        angles = new float[numPendulums];
        angularVelocities = new float[numPendulums];
        isSimulationRunning = false;
//vlaorile default de vizualizate
        for (int i = 0; i < numPendulums; i++) {
            angles[i] = 0f;
            angularVelocities[i] = 0f;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSimulationRunning) {
            updatePositions();
        }
        drawPendulums(canvas);
        invalidate();
    }

    private void drawPendulums(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float centerX = width / 2f;
        float startX = centerX - (numPendulums - 1) * 30;

        for (int i = 0; i < numPendulums; i++) {
            float angle = angles[i];
            float x = startX + i * 60;
            float y = 0;
            float bobX = x + pendulumLength * (float) Math.sin(angle);
            float bobY = y + pendulumLength * (float) Math.cos(angle);
            canvas.drawLine(x, y, bobX, bobY, paint);
            canvas.drawCircle(bobX, bobY, 20.0f, paint);
        }
    }

    private void updatePositions() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;
        float dt = elapsedTime / 1000.0f;

        for (int i = 0; i < numPendulums; i++) {
            float angle = angles[i];
            float angularVelocity = angularVelocities[i];

            float angularAcceleration = -gravity / pendulumLength * (float) Math.sin(angle);
            angularVelocity += angularAcceleration * dt;
            angle += angularVelocity * dt;

            angles[i] = angle;
            angularVelocities[i] = angularVelocity;
        }

        for (int i = 0; i < numPendulums - 1; i++) {
            if (Math.abs(angles[i] - angles[i + 1]) < 0.01f) {
                float temp = angularVelocities[i];
                angularVelocities[i] = angularVelocities[i + 1];
                angularVelocities[i + 1] = temp;
            }
        }

        lastUpdateTime = currentTime;
    }

    public void setNumPendulums(int numPendulums) {
        this.numPendulums = numPendulums;
        angles = new float[numPendulums];
        angularVelocities = new float[numPendulums];
        for (int i = 0; i < numPendulums; i++) {
            angles[i] = 0f;
            angularVelocities[i] = 0f;
        }
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void setPendulumLength(float pendulumLength) {
        this.pendulumLength = pendulumLength;
    }

    public void startSimulation() {
        isSimulationRunning = true;
        lastUpdateTime = System.currentTimeMillis();

        angles[0] = -(float) Math.PI / 4;
        angularVelocities[0] = 0f;

        invalidate();
    }
}
