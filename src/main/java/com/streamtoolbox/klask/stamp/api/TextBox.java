package com.streamtoolbox.klask.stamp.api;

import java.awt.*;
import java.util.Objects;

public class TextBox  {

    private Color fillColor = Color.lightGray;

    private Color outlineColor = Color.darkGray;

    private float outlineWidth = 4.0f;

    private double radius = 6;

    private double margin = 10;

    private int outlineOpacity = 100;

    private int fillOpacity = 100;

    public TextBox() {
        // intentionally empty
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }

    public float getOutlineWidth() {
        return outlineWidth;
    }

    public void setOutlineWidth(float outlineWidth) {
        this.outlineWidth = outlineWidth;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextBox textBox = (TextBox) o;
        return Float.compare(textBox.outlineWidth, outlineWidth) == 0 &&
                Double.compare(textBox.radius, radius) == 0 &&
                Double.compare(textBox.margin, margin) == 0 &&
                outlineOpacity == textBox.outlineOpacity &&
                fillOpacity == textBox.fillOpacity &&
                Objects.equals(fillColor, textBox.fillColor) &&
                Objects.equals(outlineColor, textBox.outlineColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fillColor, outlineColor, outlineWidth, radius, margin, outlineOpacity, fillOpacity);
    }

    public int getOutlineOpacity() {

        return outlineOpacity;
    }

    public void setOutlineOpacity(int outlineOpacity) {
        this.outlineOpacity = outlineOpacity;
    }

    public int getFillOpacity() {
        return fillOpacity;
    }

    public void setFillOpacity(int fillOpacity) {
        this.fillOpacity = fillOpacity;
    }

    @Override
    public String toString() {
        return "TextBox{" +
                "fillColor=" + fillColor +
                ", outlineColor=" + outlineColor +
                ", outlineWidth=" + outlineWidth +
                ", radius=" + radius +
                ", margin=" + margin +
                '}';
    }
}
