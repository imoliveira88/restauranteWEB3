/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Pedido;

/**
 *
 * @author Magalhães Oliveira
 */
public interface PedidoDAO {
    public Pedido getById(long pk);
 
    public void save(Pedido b);
 
    public void update(Pedido b);
 
    public void delete(Pedido b) throws Exception;
 
    public List<Pedido> findAll();
}
