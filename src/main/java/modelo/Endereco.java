package modelo;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;

@ManagedBean(name = "endereco")
@SessionScoped
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Endereco(String tl, String l, int n, String c, String cid, String es){
        this.tipoLogradouro = tl;
        this.logradouro = l;
        this.numero = n;
        this.cep = c;
        this.cidade = cid;
        this.estado = es;                
    }
    
    public Endereco(){};
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENDERECO")
    private Long id;

    @NotBlank
    @Column(name = "END_TIPOLOGRADOURO")
    private String tipoLogradouro;
    
    @NotBlank
    @Column(name = "END_LOGRADOURO")
    private String logradouro;
    
    @NotNull
    @Column(name = "END_NUMERO")
    private int numero;
    
    @NotNull
    @Column(name = "END_CEP")
    private String cep;
    
    @NotBlank
    @Size(max = 40)
    @Column(name = "END_CIDADE")
    private String cidade;
    
    @Size(min = 2, max = 2)
    @Column(name = "END_ESTADO")
    private String estado;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public boolean equals(Endereco end) {
        if(!this.tipoLogradouro.equals(end.getTipoLogradouro())) return false;
        else if(!this.logradouro.equals(end.getLogradouro())) return false;
        else if(!this.cidade.equals(end.getCidade())) return false;
        else if(!this.estado.equals(end.getEstado())) return false;
        else if(!this.cep.equals(end.getCep())) return false;
        else if(this.numero != end.getNumero()) return false;
        
        return true;
    }

    @Override
    public String toString() {
        return "Endereço: " + this.getTipoLogradouro() + " " + this.getLogradouro() + ", " + this.getNumero() + ", " + this.getCep() + ", " + this.getCidade() + "-" + this.getEstado();
    }
    
}
