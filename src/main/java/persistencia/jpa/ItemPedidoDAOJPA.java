/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jpa;

import modelo.ItemPedido;
import javax.persistence.EntityManager;
import persistencia.ItemPedidoDAO;

/**
 *
 * @author Iury
 */
public class ItemPedidoDAOJPA extends DAOGenericoJPA<Long, ItemPedido> implements ItemPedidoDAO{

    public ItemPedidoDAOJPA() {
        super();
    }
    
}
