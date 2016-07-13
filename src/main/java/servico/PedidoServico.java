/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.ArrayList;
import java.util.List;
import modelo.Pedido;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PedidoServico extends DAOGenericoJPA<Long, Pedido>{

    public PedidoServico() {
        super();
    }
    
    public Pedido getById(long pk) {
        return super.getById(pk);
    }
    
    public List<Pedido> pedidosNAtendidos()throws NoResultException{
        Query query = super.getEm().createNamedQuery("Pedido.NaoAtendido");
        List<Pedido> pedidos;
        
        try{
            pedidos = query.getResultList();
            return pedidos;
        }
        catch(NoResultException e){
            return new ArrayList<Pedido>();
        }
    }
    
    public List<Pedido> pedidosAtendidos()throws NoResultException{
        Query query = super.getEm().createNamedQuery("Pedido.Atendido");
        List<Pedido> pedidos;
        
        try{
            pedidos = query.getResultList();
            return pedidos;
        }
        catch(NoResultException e){
            return new ArrayList<Pedido>();
        }
    }
    
    public void pedidoAtende(Long id)throws NoResultException{
        super.getEm().getTransaction().begin();
        Query query = super.getEm().createNamedQuery("Pedido.Atende");
        query.setParameter("id", id);
        
        int linhasAfetadas = query.executeUpdate();
        super.getEm().getTransaction().commit();
    }
}
