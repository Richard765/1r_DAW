/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ACT11_2D;

import java.util.Objects;

/**
 *
 * @author Richard
 */
public class Product {
    private int productId;
    private String productName;
    private int numWarehouses; // núm. de warehouses diferents on hi ha aquest producte

    //Constructor
    public Product(int productId, String productName, int numWarehouses) {
        this.productId = productId;
        this.productName = productName;
        this.numWarehouses = numWarehouses;
    }
    
    //Getters y setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getNumWarehouses() {
        return numWarehouses;
    }

    public void setNumWarehouses(int numWarehouses) {
        this.numWarehouses = numWarehouses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.productId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.numWarehouses != other.numWarehouses) {
            return false;
        }
        return Objects.equals(this.productName, other.productName);
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", numWarehouses=" + numWarehouses + '}';
    }  
}
