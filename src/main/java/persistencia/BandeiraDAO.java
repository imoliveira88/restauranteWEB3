/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Bandeira;

/**
 *
 * @author Magalhães Oliveira
 */
public interface BandeiraDAO {
    
    public Bandeira getById(long pk);
 
    public void save(Bandeira b);
 
    public void update(Bandeira b);
 
    public void delete(Bandeira b) throws Exception;
 
    public List<Bandeira> findAll();
    
}
