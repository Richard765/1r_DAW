package ACT11_2D;

public class Warehouse implements Comparable<Warehouse> {
    private int warehouseId;
    private String warehouseName;
    private int numProducts;

    public Warehouse(int warehouseId, String warehouseName, int numProducts) {
        this.warehouseId = warehouseId;
        this.warehouseName = warehouseName;
        this.numProducts = numProducts;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        return this.warehouseId == other.warehouseId;
    }

    public int compareTo(Warehouse o) {
        return this.warehouseName.compareTo(o.warehouseName); // Ordenar per Name
    }

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
    public String toString() {
        return "Warehouse{" + "warehouseId=" + warehouseId + ", warehouseName=" + warehouseName + ", numProducts=" + numProducts + '}';
    }
    
}
