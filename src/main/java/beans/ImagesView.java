package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
 
@ManagedBean
@ViewScoped
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<>();
        images.add("Arrumadinho.png");
        images.add("Baião.png");
        images.add("Bobó.png");
        images.add("BodeGuisado.png");
        images.add("Buchada.png");
        images.add("CarneDeSol.png");
        images.add("Dobradinha.png");
        images.add("Feijoada.png");
        images.add("Moranga.png");
        images.add("Peixada.png");
        images.add("Sarapatel.png");
        images.add("Sururu.png");        
    }
 
    public List<String> getImages() {
        return images;
    }
}