package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;

@ManagedBean(name = "cliente")
@SessionScoped
@Entity
@Table(name = "TB_CLIENTE")
@PrimaryKeyJoinColumn(name = "ID_CLIENTE")
@DiscriminatorValue(value = "C")
public class Cliente extends Usuario {
    private static final long serialVersionUID = 1L;
    
    public Cliente(String nome, String senha, String tel, Endereco end, Cartao cartao){
        super(nome,senha,tel,end); 
        this.pedidos = new ArrayList<>();   
        this.cartao = cartao;
    }
    
    public Cliente(){
        this.pedidos = new ArrayList<>();
    }
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CARTAO", referencedColumnName = "ID_CARTAO")
    private Cartao cartao;
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> pedidos;

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }
    
}
