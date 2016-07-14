/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.NoResultException;
import modelo.Cliente;

public class ClienteServico extends UsuarioServico{

    public ClienteServico() {
        super();
    }
    
    @Override
    public Cliente getById(long pk) {
        return (Cliente) super.getById(pk);
    }
    
}
