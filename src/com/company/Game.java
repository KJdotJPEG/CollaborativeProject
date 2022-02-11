package com.company;
import javafx.scene.canvas.Canvas;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.Dimension;
import java.io.IOException;

public class Game extends Canvas implements Runnable {


    private static final long serialVersionUID = -240840600533728354L;

    public static final int WIDTH = 640;
    public static final int HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public static void createBufferStrategy(java.awt.Canvas component, GraphicsConfiguration conf)
    {
        try
        {
            component.createBufferStrategy(2, conf.getBufferCapabilities());
        }
        catch (final AWTException exception)
        {
            System.out.println(exception);
            component.createBufferStrategy(1);
        }
    }




    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 /amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }

    private void tick(){

    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0,0,WIDTH, HEIGHT);
        g.dispose();
        bs.show();
    }

    private BufferStrategy getBufferStrategy() {

    }

    public static void main(String[] args) {
        // space invader style game

        new Game();




    }

    public void start() {
    }
}
