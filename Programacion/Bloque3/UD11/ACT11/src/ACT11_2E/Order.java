package ACT11_2E;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order implements Comparable<Order> {
    private int orderId;
    private LocalDate orderDate;
    private float orderTotal;
    private List<Article> carrito;

    public Order(int orderId, LocalDate orderDate, float orderTotal) throws IllegalArgumentException {
        setOrderId(orderId);
        setOrderDate(orderDate);
        setOrderTotal(orderTotal);
        this.carrito = new ArrayList<Article>();
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public List<Article> getCarrito() {
        return carrito;
    }

    public void setCarrito(List<Article> carrito) {
        this.carrito = carrito;
    }

    @Override
    public int compareTo(Order o) {
/*        if (this.orderDate.isAfter(o.orderDate)) return 1;
        else if (this.orderDate.isBefore(o.orderDate)) return -1;
        else return 0;
*/
        if (this.orderId > o.orderId) return 1;
        else if (this.orderId < o.orderId) return -1;
        else return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.orderId;
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
        final Order other = (Order) obj;
        return this.orderId == other.orderId;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotal=" + orderTotal + ", carrito=" + carrito.toString() + '}';
    }


    
}
