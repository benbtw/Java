package com.sim2d.engine;

public class FPSClock {

    long startTime = 0;
    long URDTimeMillis = 0;
    long waitTime = 0;
    long totalTime = 0;

    int frameCount = 0;
    int FPS = 0;
    int maxFrameCount = 0;
    double averageFPS;
    long targetTime;

    public FPSClock(int FPS)
    {
        this.FPS = FPS;
        maxFrameCount = FPS;
        targetTime = 1000 / FPS;
    }

    public int tick()
    {
        startTime = System.nanoTime();
        URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
        waitTime = targetTime - URDTimeMillis;

        try {
            Thread.sleep(waitTime);
        } catch (Exception e){
        }

        totalTime += System.nanoTime() - startTime;
        frameCount++;
        if(frameCount == maxFrameCount){
            averageFPS = 1000.0 / ((double) (totalTime / frameCount) / 1000000);
            frameCount = 0;
            totalTime = 0;
        }
        return (int) averageFPS;
    }
}
