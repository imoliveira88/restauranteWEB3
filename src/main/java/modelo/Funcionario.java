package modelo;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = " TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@DiscriminatorValue(value = "F")
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;
    
    public Funcionario(String nome, String senha, String tel, Endereco end){
        super(nome,senha,tel,end);    
    }
    
    public Funcionario(){};
    
    public char tipo(){
        return 'F';
    }
}
