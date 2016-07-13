/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import modelo.Funcionario;
import javax.persistence.EntityManager;

public class FuncionarioServico extends DAOGenericoJPA<Long,Funcionario>{

    public FuncionarioServico() {
        super();
    }
    
    public Funcionario getById(long pk) {
        return super.getById(pk);
    }
}
