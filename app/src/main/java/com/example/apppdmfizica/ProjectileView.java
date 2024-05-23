package com.example.apppdmfizica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ProjectileView extends View {

    private Paint paint;
    private Paint tracePaint;
    private float weight;
    private float angle;
    private float gravity;
    private float velocityX;
    private float velocityY;
    private float positionX;
    private float positionY;
    private long lastUpdateTime;
    private boolean isSimulationRunning;
    private List<float[]> tracePoints;

    public ProjectileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);

        tracePaint = new Paint();
        tracePaint.setColor(Color.RED);
        tracePaint.setStyle(Paint.Style.FILL);
        tracePaint.setStrokeWidth(5);

        weight = 1.0f;
        angle = 45.0f;
        gravity = 98f;
        positionX = 0.0f;
        positionY = 0.0f;
        isSimulationRunning = false;

        tracePoints = new ArrayList<>();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSimulationRunning) {
            updatePosition();
        }
        drawTrace(canvas);
        drawProjectile(canvas);
        invalidate();
    }

    private void drawProjectile(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float ballRadius = 40.0f;

        float canvasX = positionX;
        float canvasY = height - positionY - ballRadius; // Adjust to start from bottom

        canvas.drawCircle(canvasX, canvasY, ballRadius, paint);
    }

    private void drawTrace(Canvas canvas) {
        int height = getHeight();

        for (int i = 1; i < tracePoints.size(); i++) {
            float[] start = tracePoints.get(i - 1);
            float[] end = tracePoints.get(i);

            float startX = start[0];
            float startY = height - start[1];
            float endX = end[0];
            float endY = height - end[1];

            canvas.drawLine(startX, startY, endX, endY, tracePaint);
        }
    }

    private void updatePosition() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;
        float dt = elapsedTime / 1000.0f;  // Convert to seconds

        // Update position and velocity
        positionX += velocityX * dt;
        positionY += velocityY * dt;
        velocityY -= gravity * dt;

        lastUpdateTime = currentTime;

        // Add current position to trace points
        tracePoints.add(new float[]{positionX, positionY});

        // Stop the simulation if the projectile hits the ground
        if (positionY < 0) {
            isSimulationRunning = false;
        }
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity / 2;
    }

    public void startSimulation() {
        float initialSpeed = 200.0f;
        float angleRad = (float) Math.toRadians(angle);

        velocityX = initialSpeed * (float) Math.cos(angleRad);
        velocityY = initialSpeed * (float) Math.sin(angleRad);
        positionX = 0f;
        positionY = 0f;
        isSimulationRunning = true;
        lastUpdateTime = System.currentTimeMillis();
        tracePoints.clear();
        invalidate();
    }
}
