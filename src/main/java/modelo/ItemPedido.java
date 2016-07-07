package modelo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.persistence.*;
import javax.validation.constraints.*;

@ManagedBean(name = "itempedido")
@SessionScoped
@Entity
@Table(name = "TB_ITEMPEDIDO")
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public ItemPedido(Prato p, int q, Pedido ped){
        this.prato = p;
        this.quantidade = q;
        this.pedido = ped;
        this.subtotal = p.getPreco()*q;
    }
    
    public ItemPedido(){};
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ITEMPEDIDO")
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PRATO", referencedColumnName = "ID_PRATO")
    private Prato prato;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PEDIDO", referencedColumnName = "ID_PEDIDO")
    private Pedido pedido;
    
    @Min(1)
    @Column(name = "ITEMPEDIDO_QUANTIDADE")
    private int quantidade;
    
    @Column(name = "ITEMPEDIDO_SUBTOTAL")
    private double subtotal;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato prato) {
        this.prato = prato;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return Math.round(100*this.subtotal)/100;
    }

    public void setSubtotal(){
        this.subtotal = this.getSubtotal();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Prato: " + this.prato.getNome() + " Quantidade: " + this.quantidade + " Subtotal: " + this.getSubtotal();
    }
    
}
