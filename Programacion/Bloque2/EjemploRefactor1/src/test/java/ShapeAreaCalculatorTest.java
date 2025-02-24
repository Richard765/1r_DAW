/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import static com.mycompany.ejemplorefactor.ShapeAreaCalculator.abs;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Richard
 */
public class ShapeAreaCalculatorTest {
    
    public ShapeAreaCalculatorTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    final double pi = 3.14;
            
    public static double abs(double value) {
        return Math.abs(value);
    }
    
    @Test
    public void testCalculateCircleArea() {
        double radius = 5.0;
        double expected = pi * radius * radius;
        assertEquals(expected, calculateCircleArea(radius));
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
    // @Test
    // public void hello() {}
}
