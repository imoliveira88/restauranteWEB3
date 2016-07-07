/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.jpa;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import modelo.Bandeira;
import persistencia.BandeiraDAO;

/**
 *
 * @author Iury
 */
public class BandeiraDAOJPA extends DAOGenericoJPA<Long, Bandeira> implements BandeiraDAO{

    public BandeiraDAOJPA() {
        super();
    }

    @Override
    public Bandeira getById(long pk) {
        return super.getById(pk);
    }
    
    public boolean existeBandeira(Bandeira band){
        Bandeira resultado;
        String consulta = "select b from Bandeira b where b.nome = :nome";
        TypedQuery<Bandeira> query = super.getEm().createQuery(consulta, Bandeira.class);
        query.setParameter("nome",band.getNome());
        try{
            resultado = query.getSingleResult();
            return true;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public void save(Bandeira b){
        super.getEm().getTransaction().begin();
        if(!existeBandeira(b)){
            super.getEm().persist(b);
        }
        super.getEm().getTransaction().commit();
    }
}
