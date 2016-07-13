package servico;

import java.util.List;
import modelo.Cartao;
import javax.persistence.NoResultException;

public class CartaoServico extends DAOGenericoJPA<Long, Cartao>{

    public CartaoServico() {
        super();
    }


    public Cartao getById(long pk) {
        return super.getById(pk);
    }
    
    public boolean existeCartao(Cartao car){
        String query = "select e from Cartao e";
        List<Cartao> cartoes = super.getEm().createQuery(query, Cartao.class).getResultList();
        try{
            for(Cartao cartao : cartoes){
                if(cartao.equals(car)) return true;
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    @Override
    public void save(Cartao b) {
        if(!existeCartao(b)){
            super.getEm().getTransaction().begin();
            super.getEm().persist(b);
            super.getEm().getTransaction().commit();
        }
    }
    
}
