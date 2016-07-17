
package servico;

import java.util.List;
import javax.persistence.*;
import modelo.Usuario;

public class UsuarioServico extends DAOGenericoJPA<Long, Usuario>{

    public UsuarioServico() {
        super();
    }
    
    public Usuario retornaUsuario(String telefone){
        Query query = super.getEm().createNamedQuery("Usuario.RetornaUsuario");
        
        query.setParameter("tel", telefone);
        Usuario usu;
        
        try{
            usu = (Usuario) query.getSingleResult();
            return usu;
        }
        catch(NoResultException e){
            return null;
        }
    }
    
    //Retorna a id caso usuário exista e zero, caso não exista
    public boolean existeUsuario(Usuario usu){
        String query = "select e from Usuario e";
        List<Usuario> usuarios = super.getEm().createQuery(query, Usuario.class).getResultList();
        try{
            for(Usuario usuario : usuarios){
                if(usuario.equals(usu)){
                    return true;
                }
            }
            return false;
        }
        catch(NoResultException e){
            return false;
        }
    }
    
    public boolean salvar(Usuario b) {
        if(!existeUsuario(b)){
            super.getEm().getTransaction().begin();
            super.getEm().persist(b);
            super.getEm().getTransaction().commit();
            return true;
        }
        return false;
    }
    
    public Usuario getById(long pk) {
        return super.getById(pk);
    }
    
}
