/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jpa;

import modelo.Cliente;
import persistencia.ClienteDAO;

/**
 *
 * @author Iury
 */
public class ClienteDAOJPA extends DAOGenericoJPA<Long, Cliente> implements ClienteDAO{

    public ClienteDAOJPA() {
        super();
    }
    
    @Override
    public Cliente getById(long pk) {
        return super.getById(pk);
    }
    
}
