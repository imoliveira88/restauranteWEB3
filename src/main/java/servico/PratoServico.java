/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.util.List;
import modelo.Prato;
import javax.persistence.NoResultException;
import javax.persistence.Query;

public class PratoServico extends DAOGenericoJPA<Long, Prato>{

    public PratoServico() {
        super();
    }
    
    @Override
    public void delete(Prato prato) throws Exception{
        super.getEm().getTransaction().begin();
        Query query = super.getEm().createNamedQuery("Prato.RetornaId");
        query.setParameter("nome", prato.getNome());
        
        Long id = (Long) query.getSingleResult();
        
        Prato p = super.getEm().find(Prato.class,id);
        
        try{
            super.getEm().remove(p);
            super.getEm().getTransaction().commit();
        }catch(Exception e){
            
        }
    }
    
    @Override
    public void update(Prato pr){
        super.getEm().getTransaction().begin();
        Prato prato = getPrato(pr.getNome());
        prato = super.getEm().merge(prato);
        prato.setDescricao(pr.getDescricao());
        prato.setDescricao(pr.getDescricao());
        super.getEm().getTransaction().commit();
    }

    public Prato getById(long pk) {
        return super.getById(pk);
    }
    
    public Prato getPrato(String pr){
        String query = "select e from Prato e";
        List<Prato> pratos = super.getEm().createQuery(query, Prato.class).getResultList();
        try{
            for(Prato prato : pratos){
                if(prato.getNome().equals(pr)) return prato;
            }
            return null;
        }
        catch(NoResultException e){
            return null;
        }
    }
    
    public boolean existePrato(Prato p){
        String query = "select e from Prato e";
        List<Prato> pratos = super.getEm().createQuery(query, Prato.class).getResultList();
        try{
            for(Prato prato : pratos){
                if(prato.equals(p))return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public List<Prato> findAll() {
        String query = "SELECT e FROM Prato e ORDER BY e.nome";
        List<Prato> pratos = super.getEm().createQuery(query, Prato.class).getResultList();
        return pratos;
    }
    
    @Override
    public void save(Prato b) {
        if(!existePrato(b)){
            super.getEm().getTransaction().begin();
            super.getEm().persist(b);
            super.getEm().getTransaction().commit();
        }
    }
    
    
    
}
