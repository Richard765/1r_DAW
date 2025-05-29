package ACT11_2D;

public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private int numWarehouses;

    public Product(int productId, String productName, int numWarehouses) {
        this.productId = productId;
        this.productName = productName;
        this.numWarehouses = numWarehouses;
    }

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
    public int compareTo(Product o) {
        return this.productName.compareTo(o.productName); // Ordenar per Name
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.productId;
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
        return this.productId == other.productId;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", numWarehouses=" + numWarehouses + '}';
    }

}
