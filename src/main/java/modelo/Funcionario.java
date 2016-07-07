package modelo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.NotBlank;

@ManagedBean(name = "funcionario")
@SessionScoped
@Entity
@Table(name = " TB_FUNCIONARIO")
@PrimaryKeyJoinColumn(name = "ID_FUNCIONARIO")
@DiscriminatorValue(value = "F")
public class Funcionario extends Usuario {
    private static final long serialVersionUID = 1L;
    
    public Funcionario(String nome, String senha, String tel, Endereco end, Double sal, String cargo){
        super(nome,senha,tel,end);    
        this.salario = sal;
        this.cargo = cargo;
    }
    
    public Funcionario(){};
    
    @NotNull
    @Column(name = "FUNC_SALARIO")
    private double salario;
    
    @NotBlank
    @Column(name = "FUNC_CARGO")
    private String cargo;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
