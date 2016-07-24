package beans;

import servico.FuncionarioServico;
import java.text.ParseException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import modelo.Endereco;
import modelo.Funcionario;

@ManagedBean(name = "cadastroF")
@RequestScoped
public class FuncionarioMB{
    private String tipologradouro;
    private String logradouro;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String nome;
    private String telefone;
    private String senha;
    
    
    /**
     * Creates a new instance of cadastroCliente
     */
    public FuncionarioMB() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTipologradouro(String tipologradouro) {
        this.tipologradouro = tipologradouro;
    }
    
    public String getTipologradouro() {
        return tipologradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

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
    
    public String cadastraFuncionario() throws ParseException{
        FuncionarioServico funcionario = new FuncionarioServico();
        
        Endereco endereco = new Endereco(tipologradouro,logradouro,numero,cep,cidade,estado);
        Funcionario func = new Funcionario(nome,senha,telefone,endereco);

        funcionario.save(func);
        
        adicionaMensagem("Cadastro feito com sucesso!","destinoAviso");
        
        return "homeF";
    }
    
    private void adicionaMensagem(String mensagem, String destino){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.FACES_MESSAGES,mensagem);
        context.addMessage(destino, msg);
    }
}
