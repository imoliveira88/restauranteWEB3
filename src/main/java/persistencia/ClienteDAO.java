/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Cliente;

/**
 *
 * @author Magalhães Oliveira
 */
public interface ClienteDAO {
    public Cliente getById(long pk);
 
    public void save(Cliente b);
 
    public void delete(Cliente b) throws Exception;
 
}
