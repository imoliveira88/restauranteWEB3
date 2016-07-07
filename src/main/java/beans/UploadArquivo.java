package beans;

import java.io.File;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.event.FileUploadEvent;
	
public class UploadArquivo{

    private String diretorio;
    private String caminho;
    private String nome;

    public UploadArquivo() {
    }

    public String getNome() {
        return nome;
    }

    public String getRealPath() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpServletResponse response = (HttpServletResponse) externalContext.getResponse();

        FacesContext aFacesContext = FacesContext.getCurrentInstance();
        ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();

        return context.getRealPath("/");
    }

    public void fileUpload(FileUploadEvent event, String diretorio) {
        try {
            this.nome = event.getFile().getFileName();
            this.caminho = getRealPath() + diretorio + getNome();

            File file = new File(getRealPath() + diretorio);
            file.mkdirs();

        } catch (Exception ex) {
            System.out.println("Erro no upload do arquivo" + ex);
        }
    }

}
