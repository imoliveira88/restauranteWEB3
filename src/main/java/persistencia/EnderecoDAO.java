/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Endereco;

/**
 *
 * @author Magalhães Oliveira
 */
public interface EnderecoDAO {
    public Endereco getById(long pk);
 
    public void save(Endereco b);
 
    public void delete(Endereco b) throws Exception;
 
}
