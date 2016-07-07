/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.Cliente;
import modelo.ItemPedido;
import modelo.Pedido;
import modelo.Prato;
import persistencia.PedidoDAO;
import persistencia.jpa.ClienteDAOJPA;
import persistencia.jpa.PedidoDAOJPA;

/**
 *
 * @author Magalhães Oliveira
 */
@ManagedBean(name = "pedidoMB")
@SessionScoped
public class PedidoMB{
    private Pedido pedido;
    private int quantidade;
    private Prato prato;
    private List<ItemPedido> itens;
    
    private String mensagem;
    
    public PedidoMB(){
        this.itens = new ArrayList<>();
        this.pedido = new Pedido();
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void addItem(ItemPedido item) {
        this.itens.add(item);
    }
    
    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato p) {
        this.prato = p;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public String adicionaItem(){
        ItemPedido ip = new ItemPedido(this.prato,this.quantidade,pedido);
        
        pedido.addItem(ip);
        this.addItem(ip);
        
        
        setMensagem("Item adicionado ao pedido!");
        return "/faces/cliente/pedido.xhtml";
    }
    
    public String fechaPedido(long id_cliente){
        PedidoDAO pedidoDAO = new PedidoDAOJPA();
        this.pedido.setCliente(new ClienteDAOJPA().getById(id_cliente));
        pedidoDAO.save(pedido);
        
        setMensagem("Pedido realizado!");
        this.itens = new ArrayList<>();
        this.pedido = new Pedido();
        return "/faces/cliente/pedido.xhtml";
    }
    
}
