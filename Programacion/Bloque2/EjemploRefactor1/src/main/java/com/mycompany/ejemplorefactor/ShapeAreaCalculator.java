/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplorefactor;

/**
 *
 * @author Richard
 */


public class ShapeAreaCalculator {
    final double pi = 3.14;
            
    public static double abs(double value) {
        return Math.abs(value);
    }
    
    public double calculateCircleArea(double radius) {
        return pi * abs(radius) * abs(radius);
    }
    
    public double calculateRectangleArea(double length, double width) {
        return abs(length) * abs(width);
    }
    
    public double calculateSquareArea(double side) {
        return abs(side) * abs(side);
    }
    
    public double calculateTriangleArea(double length, double width) {
        return abs(length) * abs(width) / 2;
    }
}