/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Funcionario;

/**
 *
 * @author Magalhães Oliveira
 */
public interface FuncionarioDAO {
    public Funcionario getById(long pk);
 
    public void save(Funcionario b);
 
    public void update(Funcionario b);
 
    public void delete(Funcionario b) throws Exception;
 
    public List<Funcionario> findAll();
}
