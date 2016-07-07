/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Cartao;

/**
 *
 * @author Magalhães Oliveira
 */
public interface CartaoDAO {
    public Cartao getById(long pk);
 
    public void save(Cartao b);
 
    public void update(Cartao b);
 
    public void delete(Cartao b) throws Exception;
 
    public List<Cartao> findAll();
}
