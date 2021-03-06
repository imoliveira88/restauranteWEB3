package beans;

import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import modelo.Prato;
import org.primefaces.event.FileUploadEvent;
import servico.PratoServico;

@ManagedBean(name = "pratoMB")
@SessionScoped
public class PratoMB {

    private Prato prato;
    private List<Prato> pratos; 

    public PratoMB() {
        this.prato = new Prato();
        this.pratos = new ArrayList<>();
        this.pratos = new PratoServico().findAll();
    }

    public List<Prato> getPratos() {
        return this.pratos;
    }

    public void setPratos(List<Prato> listarPratos) {
        this.pratos = listarPratos;
    }

    public Prato getPrato() {
        return prato;
    }

    public void setPrato(Prato pr) {
        this.prato = pr;
    }

    public void uploadAction(FileUploadEvent event) {
        this.prato.setImagem(event.getFile().getFileName());
    }

    public String salvar() {
        PratoServico pra = new PratoServico();
        if(!pra.existePrato(this.prato)){
            pra.save(prato);
            this.pratos.add(prato);
            this.prato = new Prato();
            adicionaMensagem("Prato adicionado com sucesso!","destinoAviso");
            return "prato";
        }
        else{
            adicionaMensagem("Prato não adicionado! O prato já existe!","destinoAviso");
            return "prato";
        }
    }
    
    public String excluir(Prato pr) throws Exception{
        PratoServico pra = new PratoServico();
        if(pra.deletar(pr)){
            this.pratos.remove(pr);
            adicionaMensagem("Prato removido com sucesso!","destinoAviso");
        }else{
            adicionaMensagem("Prato não pode ser removido, pois pertence a algum item de pedido já feito!","destinoAviso");
        }
        return "prato";
    }
    
    public String atualizar(Prato pr) throws Exception{
        PratoServico pra = new PratoServico();
        System.out.println("Prato preçooooooo: " + pr.getPreco());
        pra.update(pr);

        adicionaMensagem("Prato editado com sucesso!","destinoAviso");
        return "prato";
    }
    
    private void adicionaMensagem(String mensagem, String destino){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.FACES_MESSAGES,mensagem);
        context.addMessage(destino, msg);
    }
}
