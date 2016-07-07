/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Magalhães Oliveira
 */
public interface UsuarioDAO {
    public Usuario getById(long pk);
 
    public void save(Usuario b);
 
    public void delete(Usuario b) throws Exception;
    
    public String retornaSenha(String telefone);
 
    public List<Usuario> findAll();
}
