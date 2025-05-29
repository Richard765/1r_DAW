package ACT11_2E;

import java.util.Set;

public class Article implements Comparable<Article> {
    private int productId;
    private String productName;
    private int productPrice;

    public Article(int productId, String productName, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
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

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int compareTo(Article o) {
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
        final Article other = (Article) obj;
        return this.productId == other.productId;
    }

    @Override
    public String toString() {
        return "Article{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + '}';
    }



}
