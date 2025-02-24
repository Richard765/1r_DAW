/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ejerciciosrepasoed;

import com.mycompany.ejemplorefactor.ShapeAreaCalculator;
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

    /**
     * Test of abs method, of class ShapeAreaCalculator.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        double value = 0.0;
        double expResult = 0.0;
        double result = ShapeAreaCalculator.abs(value);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCircleArea method, of class ShapeAreaCalculator.
     */
    @Test
    public void testCalculateCircleArea() {
        System.out.println("calculateCircleArea");
        double radius = 0.0;
        ShapeAreaCalculator instance = new ShapeAreaCalculator();
        double expResult = 0.0;
        double result = instance.calculateCircleArea(radius);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateRectangleArea method, of class ShapeAreaCalculator.
     */
    @Test
    public void testCalculateRectangleArea() {
        System.out.println("calculateRectangleArea");
        double length = 0.0;
        double width = 0.0;
        ShapeAreaCalculator instance = new ShapeAreaCalculator();
        double expResult = 0.0;
        double result = instance.calculateRectangleArea(length, width);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateSquareArea method, of class ShapeAreaCalculator.
     */
    @Test
    public void testCalculateSquareArea() {
        System.out.println("calculateSquareArea");
        double side = 0.0;
        ShapeAreaCalculator instance = new ShapeAreaCalculator();
        double expResult = 0.0;
        double result = instance.calculateSquareArea(side);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTriangleArea method, of class ShapeAreaCalculator.
     */
    @Test
    public void testCalculateTriangleArea() {
        System.out.println("calculateTriangleArea");
        double length = 0.0;
        double width = 0.0;
        ShapeAreaCalculator instance = new ShapeAreaCalculator();
        double expResult = 0.0;
        double result = instance.calculateTriangleArea(length, width);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
