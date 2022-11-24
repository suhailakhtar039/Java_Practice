package com.example.helloworld.DesignPatterns.Structural.Bridge;

interface Renderer {
    void renderCircle(float radius);
}

class VectorRenderer implements Renderer {
    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing a circle of radius " + radius);
    }
}

class RasterRenderer implements Renderer{

    @Override
    public void renderCircle(float radius) {
        System.out.println("Drawing pixels for circle of radius " + radius);
    }
}

abstract class Shape{
    protected Renderer renderer;
    public Shape(Renderer renderer){
        this.renderer = renderer;
    }
    public abstract void draw();
    public abstract void resize(float factor);
}

class Circle extends Shape{
    public float radius;
    public Circle(Renderer renderer) {
        super(renderer);
    }
    public Circle(Renderer renderer,int radius) {
        super(renderer);
        this.radius = radius;
    }
    @Override
    public void draw() {
        renderer.renderCircle(radius);
    }

    @Override
    public void resize(float factor) {
        radius *= factor;
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        RasterRenderer raster = new RasterRenderer();
        VectorRenderer vector = new VectorRenderer();
        Circle circle = new Circle(vector, 5);
        circle.draw();
    }
}
