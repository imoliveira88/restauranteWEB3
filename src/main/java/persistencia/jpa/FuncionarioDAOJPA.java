/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jpa;

import modelo.Funcionario;
import javax.persistence.EntityManager;
import persistencia.FuncionarioDAO;

/**
 *
 * @author Iury
 */
public class FuncionarioDAOJPA extends DAOGenericoJPA<Long, Funcionario> implements FuncionarioDAO{

    public FuncionarioDAOJPA() {
        super();
    }
    
    @Override
    public Funcionario getById(long pk) {
        return super.getById(pk);
    }
}
