package com.example.apppdmfizica;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SlopeView extends View {

    private Paint paint;
    private float initialVelocity;
    private float weight;
    private float gravity;
    private boolean isSimulationRunning;
    private float squareX, squareY;
    private float slopeHeight;
    private long startTime;

    public SlopeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        //TODO: cu viteza intiiala
        initialVelocity = 20.0f;
        weight = 1.0f;
        gravity = 9.8f;
        slopeHeight = 300;
        isSimulationRunning = false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSlope(canvas);
        if (isSimulationRunning) {
            updateSquarePosition();
        }
        drawSquare(canvas);
        invalidate();
    }

    private void drawSlope(Canvas canvas) {
        Paint slopePaint = new Paint();
        slopePaint.setColor(Color.BLACK);
        slopePaint.setStrokeWidth(5);

        int width = getWidth();
        int height = getHeight();

        // Draw a parabolic path
        float midX = width / 2f;
        float midY = height / 2f;
        for (int x = 0; x < width; x++) {
            float y = height - (4 * slopeHeight * x * (width - x) / (width * width));
            if (x > 0) {
                canvas.drawLine(x - 1, height - (4 * slopeHeight * (x - 1) * (width - (x - 1)) / (width * width)), x, y, slopePaint);
            }
        }
    }

    private void drawSquare(Canvas canvas) {
        canvas.drawRect(squareX - 20, squareY - 20, squareX + 20, squareY + 20, paint);
    }

    private void updateSquarePosition() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;

        float time = elapsedTime / 1000f;

        // Update square position
        float width = getWidth();
        float midX = width / 2f;
        float totalTime = 2 * initialVelocity / gravity;
        float slopeX = time / totalTime * width;

        if (time < totalTime) {
            squareX = slopeX;
            squareY = getHeight() - (4 * slopeHeight * squareX * (width - squareX) / (width * width));
        } else {
            isSimulationRunning = false;
        }
    }

    public void setInitialVelocity(float initialVelocity) {
        this.initialVelocity = initialVelocity;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public void resetSimulation() {
        squareX = 0;
        squareY = getHeight();
        isSimulationRunning = true;
        startTime = System.currentTimeMillis();
        invalidate();
    }
}
