/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servico;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SuppressWarnings("unchecked")
public class DAOGenericoJPA<PK, T> {
    private static final String PERSISTENCE_UNIT_NAME = "restauranteUP";
    private static EntityManagerFactory factory;
    private static FabricaDAOJPA instance = null;   
    private final EntityManager em;
 
    public DAOGenericoJPA() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        this.em = factory.createEntityManager();
    }
    
    public EntityManager getEm(){
        return this.em;
    }
 
    public T getById(PK pk) {
        return (T) em.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
 
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
 
    public void delete(T entity) throws Exception{
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.remove(entity);
        em.getTransaction().commit();
    }
 
    public List<T> findAll() {
        return em.createQuery(("FROM " + getTypeClass().getName())).getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}