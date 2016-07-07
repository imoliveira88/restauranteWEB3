/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import modelo.Endereco;
import persistencia.EnderecoDAO;

/**
 *
 * @author Magalhães Oliveira
 */
public class EnderecoDAOJPA extends DAOGenericoJPA<Long, Endereco> implements EnderecoDAO{
    public EnderecoDAOJPA() {
        super();
    }
    
    @Override
    public Endereco getById(long pk) {
        return super.getById(pk);
    }
    
    public boolean existeEndereco(Endereco end){
        String query = "select e from Endereco e";
        List<Endereco> enderecos = super.getEm().createQuery(query, Endereco.class).getResultList();
        try{
            for(Endereco endereco : enderecos){
                if(endereco.equals(end)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public void save(Endereco b) {
        super.getEm().getTransaction().begin();
        if(!existeEndereco(b)){
            super.getEm().persist(b);
        }
        else super.getEm().merge(b);
        super.getEm().getTransaction().commit();
    }
}
