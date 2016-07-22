package beans;

import servico.ClienteServico;
import java.text.ParseException;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Bandeira;
import modelo.Cartao;
import modelo.Cliente;
import modelo.Endereco;
import servico.BandeiraServico;

@ManagedBean(name = "cadastroC")
@SessionScoped
public class ClienteMB{
    private String bandeira;
    private String numeroCartao;
    private Date validade;
    private String tipologradouro;
    private String logradouro;
    private int numero;
    private String cep;
    private String cidade;
    private String estado;
    private String nome;
    private String telefone;
    private String senha;
    
    public ClienteMB() {
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getTipologradouro() {
        return tipologradouro;
    }

    public void setTipologradouro(String tipologradouro) {
        this.tipologradouro = tipologradouro;
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
    
    public String cadastraCliente() throws ParseException{
        ClienteServico cli = new ClienteServico();
        BandeiraServico bServico = new BandeiraServico();
        
        try {
            Bandeira bandMan = bServico.retornaBandeira(bandeira);
            
            Cartao cartao = new Cartao(bandMan, numeroCartao, validade);
            
            Endereco endereco = new Endereco(tipologradouro, logradouro, numero, cep, cidade, estado);
            Cliente cliente = new Cliente(nome, senha, telefone, endereco, cartao);
            
            if (cli.salvar(cliente)) {
                this.adicionaMensagem("Cadastro feito com sucesso! Realize login!","destinoAviso");
                return "login";
            } else {
                this.adicionaMensagem("Já existe um usuario com este login (telefone)!","destinoAviso");
                return "cliente";
            }
        } catch (Exception e) {
            this.adicionaMensagem("Houve um erro no cadastro! Tente novamente!","destinoAviso");
            return "cliente";
        }  
        
    }
    
    private void adicionaMensagem(String mensagem, String destino){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.FACES_MESSAGES,mensagem);
        context.addMessage(destino, msg);
    }
    

}
        
