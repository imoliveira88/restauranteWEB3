package modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.*;

@ManagedBean(name = "cartao")
@SessionScoped
@Entity
@Table(name = "TB_CARTAO")
public class Cartao implements Serializable{
    private static final long serialVersionUID = 1L;
    
    public Cartao(Bandeira b, String num, Date valid){
        this.bandeira = b;
        this.numero = num;
        this.validade = valid;
    }
    
    public Cartao(){};
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CARTAO")
    private Long id;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "ID_BANDEIRA", referencedColumnName = "ID_BANDEIRA")
    private Bandeira bandeira;
    
    @NotNull
    //@CreditCardNumber
    @Column(name = "CARTAO_NUMERO")
    private String numero;
    
    @NotNull
    @Future
    @Temporal(TemporalType.DATE)
    @Column(name = "CARTAO_VALIDADE")
    private Date validade;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cartao other = (Cartao) obj;
        if (!Objects.equals(this.bandeira, other.bandeira)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.validade, other.validade)) {
            return false;
        }
        return true;
    }
    
    
  
}

