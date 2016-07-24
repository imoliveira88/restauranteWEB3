package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Prato;
import org.primefaces.event.FileUploadEvent;
import servico.PratoServico;

@ManagedBean(name = "pratoMB")
@RequestScoped
public class PratoMB{

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
    
    public String excluir() throws Exception{
        PratoServico pra = new PratoServico();
        pra.delete(prato);
        this.pratos.remove(prato);
        adicionaMensagem("Prato removido com sucesso!","destinoAviso");
        return "prato";
    }
    
    private void adicionaMensagem(String mensagem, String destino){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage msg;
        msg = new FacesMessage(FacesMessage.FACES_MESSAGES,mensagem);
        context.addMessage(destino, msg);
    }
}
