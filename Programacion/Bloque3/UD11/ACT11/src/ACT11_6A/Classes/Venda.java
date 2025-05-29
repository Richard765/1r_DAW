package ACT11_6A.Classes;

import java.time.LocalDate;
import java.util.Set;

public class Venda {
    int id;
    LocalDate dataVenda;
    Client client;
    Set<Producte> productes;

    public Venda(int id, LocalDate dataVenda, Client client, Set<Producte> productes) {
        setId(id);
        setDataVenda(dataVenda);
        setClient(client);
        setProductes(productes);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        if (dataVenda == null || dataVenda.getYear() < 2000)
            throw new IllegalArgumentException ("Venda.Data incorrecte");
        else
            this.dataVenda = dataVenda;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Set<Producte> getProductes() {
        return productes;
    }

    public void setProductes(Set<Producte> productes) {
        this.productes = productes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id;
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
        final Venda other = (Venda) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        String text = "Venda{" + "id=" + id + ", dataVenda=" + dataVenda + ", client=" + client + ", productes=";
        double total = 0;
        for (Producte p : this.productes) {
            text += "\n\t\t" + p.toString();
            total += p.getPreu();
        }
        
        text += "\n\tTOTAL: " + total;
        return text;
    }
    
}