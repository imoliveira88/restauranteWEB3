/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import modelo.Cliente;

public class ClienteServico extends UsuarioServico{

    public ClienteServico() {
        super();
    }
    
    public Cliente getById(long pk) {
        return (Cliente) super.getById(pk);
    }
    
}
