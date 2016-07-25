package modelo;

import beans.BaseEntity;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@NamedQuery(name = "Prato.RetornaId",query= " SELECT max(u.id) FROM Prato u WHERE u.nome = :nome")
@Table(name = "TB_PRATO")
public class Prato implements Serializable, BaseEntity {
    private static final long serialVersionUID = 1L;
    
    public Prato(){
        this.pratos = new ArrayList<>();
    }
    
    
    public Prato(String nome, double preco, String descricao, String imagem){
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
        this.imagem = imagem;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRATO")
    private Long id;
    
    @NotBlank
    @Size(min = 3, max = 30)
    @Column(name = "PRATO_NOME")
    private String nome;
    
    @NotNull
    @Min(0)
    @Column(name = "PRATO_PRECO")
    private Double preco;
    
    @NotBlank
    @Size(min = 3, max = 300)
    @Column(name = "PRATO_DESCRICAO")
    private String descricao;
    
    //Nome da imagem, no diretório imagens
    @Column(name = "PRATO_IMAGEM")
    private String imagem;
    
    @Transient
    private ArrayList<Prato> pratos;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagem() {
        return imagem;
    }

    public ArrayList<Prato> getPratos() {
        return pratos;
    }

    public void setPratos(ArrayList<Prato> pratos) {
        this.pratos = pratos;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    
    @Override
    public String toString() {
        return this.nome;
    }

    public boolean equals(Prato outro) {
        return this.nome.equals(outro.nome); 
    }
    
    
    
}
