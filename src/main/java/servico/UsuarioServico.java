
package servico;

import java.util.List;
import javax.persistence.*;
import modelo.Usuario;

public class UsuarioServico extends DAOGenericoJPA<Long, Usuario>{

    public UsuarioServico() {
        super();
    }
    
    public String retornaSenha(String telefone){
        Query query = super.getEm().createNamedQuery("Usuario.RetornaSenha");
        
        query.setParameter("tel", telefone);
        
        try{
            return (String) query.getSingleResult();
        }
        catch(NoResultException e){
            return "";
        }
    }
    
    public long retornaId(String telefone){
        Query query = super.getEm().createNamedQuery("Usuario.RetornaId");
        
        query.setParameter("tel", telefone);
        
        try{
            return (long) query.getSingleResult();
        }
        catch(NoResultException e){
            return 0;
        }
    }
    
    public String tipoUsuario(Usuario usu)throws NoResultException{
        Query query = super.getEm().createNamedQuery("Usuario.loginCliente");
        
        query.setParameter("telefone", usu.getTelefone());
        
        Object tipoC;
        
        try{
            tipoC = query.getSingleResult();
            if(tipoC == null) return "F";
            else return "C";
        }
        catch(NoResultException e){
            return "F";
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
