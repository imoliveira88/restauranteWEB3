/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.FacesException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Usuario;
import servico.UsuarioServico;

/**
 *
 * @author Administrador
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    private String telefone;
    private String senha;
    private String nome;

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //Compara se o telefone digitado corresponde a um usuário válido, e, correspondendo,
    //compara a senha fornecida, com a senha que há no banco
    public boolean validaUsuario()throws SQLException{
        UsuarioServico ud = new UsuarioServico();
        try {
            String senhaRetornada = ud.retornaUsuario(this.telefone).getSenha();
            return this.senha.equals(senhaRetornada);
        } catch (Exception e) {
            return false;
        }
    }
    
    public String doLogin() throws FacesException,ExceptionInInitializerError,SQLException{
        boolean valido;
        char tipo;
        Usuario usu;
        
        try {
            valido = this.validaUsuario();

            if (!valido) {
                adicionaMensagem("Login ou senha incorretos!", "destinoAviso");
                return "login";
            } else {
                UsuarioServico ud = new UsuarioServico();
                usu = ud.retornaUsuario(this.telefone);

                tipo = usu.tipo();
                this.setNome(usu.getNome());
                if (tipo == 'C') {
                    return "homeC";
                } else {
                    return "homeF";
                }
            }
        } catch (Exception e) {
            adicionaMensagem("Login ou senha incorretos!", "destinoAviso");
            return "login";
        }
   
      }
    
    private void adicionaMensagem(String mensagem, String destino){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.FACES_MESSAGES,mensagem);
        context.addMessage(destino, msg);
    }
}
