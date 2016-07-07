/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.ItemPedido;

/**
 *
 * @author Magalhães Oliveira
 */
public interface ItemPedidoDAO {
 
    public void save(ItemPedido b);
 
    public void delete(ItemPedido b) throws Exception;
 
}
