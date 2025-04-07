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
public class Warehouse {
    private int warehouseId;
    private String warehouseName;
    private int numProducts;  // núm. total de productes en el warehouse

    //Constructor
    public Warehouse(int warehouseId, String warehouseName, int numProducts) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.numProducts = numProducts;
    }
    
    //Getters y setters

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public int getNumProducts() {
        return numProducts;
    }

    public void setNumProducts(int numProducts) {
        this.numProducts = numProducts;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.warehouseId;
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
        final Warehouse other = (Warehouse) obj;
        if (this.warehouseId != other.warehouseId) {
            return false;
        }
        if (this.numProducts != other.numProducts) {
            return false;
        }
        return Objects.equals(this.warehouseName, other.warehouseName);
    }

    @Override
    public String toString() {
        return "Warehouse{" + "warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", numProducts=" + numProducts + '}';
    }
    
}
