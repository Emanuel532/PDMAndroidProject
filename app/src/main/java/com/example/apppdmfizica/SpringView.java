package com.example.apppdmfizica;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SpringView extends View {

    private Paint paint;
    private float springConstant;
    private float dampingFactor;
    private float mass;
    private float initialDisplacement;
    private float displacement;
    private float velocity;
    private long lastUpdateTime;
    private boolean isSimulationRunning;

    public SpringView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        springConstant = 10.0f;
        dampingFactor = 0.1f;
        mass = 1.0f;
        initialDisplacement = 200.0f;
        displacement = initialDisplacement;
        velocity = 0.0f;
        isSimulationRunning = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isSimulationRunning) {
            updateDisplacement();
        }
        drawSpringAndBlock(canvas);
        invalidate();
    }

    private void drawSpringAndBlock(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float blockSize = 50.0f;
        float blockX = width / 2 - blockSize / 2;
        float blockY = height / 2 + displacement;

        // Draw the spring
        float springTopX = width / 2;
        float springTopY = height / 2 - initialDisplacement;
        float springBottomY = blockY - blockSize / 2;
        int numCoils = 6;
        float coilSpacing = (springBottomY - springTopY) / numCoils;

        float y = springTopY;
        for (int i = 0; i < numCoils; i++) {
            canvas.drawLine(springTopX, y, springTopX - coilSpacing / 2, y + coilSpacing / 2, paint);
            canvas.drawLine(springTopX - coilSpacing / 2, y + coilSpacing / 2, springTopX, y + coilSpacing, paint);
            y += coilSpacing;
        }

        // Draw the block
        Paint blockPaint = new Paint();
        blockPaint.setColor(Color.BLUE);
        blockPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(blockX, blockY - blockSize / 2, blockX + blockSize, blockY + blockSize / 2, blockPaint);
    }

    private void updateDisplacement() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - lastUpdateTime;
        float dt = elapsedTime / 1000.0f;  // Convert to seconds

        // Calculate acceleration due to spring force and damping
        float acceleration = (-springConstant * displacement - dampingFactor * velocity) / mass;

        // Update velocity and displacement using simple Euler integration
        velocity += acceleration * dt;
        displacement += velocity * dt;

        lastUpdateTime = currentTime;

        // Stop the simulation if the velocity is very small
        if (Math.abs(velocity) < 0.1f && Math.abs(displacement) < 0.1f) {
            isSimulationRunning = false;
        }
    }

    public void setSpringConstant(float springConstant) {
        this.springConstant = springConstant;
    }

    public void setDampingFactor(float dampingFactor) {
        this.dampingFactor = dampingFactor;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public void setInitialDisplacement(float initialDisplacement) {
        this.initialDisplacement = initialDisplacement;
        this.displacement = initialDisplacement;
    }

    public void startSimulation() {
        displacement = initialDisplacement;
        velocity = 0.0f;
        isSimulationRunning = true;
        lastUpdateTime = System.currentTimeMillis();
        invalidate();
    }
}
