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
