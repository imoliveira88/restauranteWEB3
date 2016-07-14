/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Bandeira;

public class BandeiraServico extends DAOGenericoJPA<Long, Bandeira>{

    public BandeiraServico() {
        super();
    }

    public Bandeira getById(long pk) {
        return super.getById(pk);
    }
    
    public Bandeira retornaBandeira(String bandeira){
        TypedQuery<Bandeira> query = super.getEm().createNamedQuery("Bandeira.BANDEIRA_POR_NOME", Bandeira.class);
        
        query.setParameter(1, bandeira);
        
       return query.getSingleResult();
    }
    
    public List<Bandeira> todasBandeiras(){
        TypedQuery<Bandeira> query = super.getEm().createNamedQuery("Bandeira.TODAS", Bandeira.class);
        return query.getResultList();
    }
}
