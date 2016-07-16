package beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        images.add("Arrumadinho.png");
        images.add("Baião de dois.png");
        images.add("Bobó de camarão.png");
        images.add("Bode Guisado.png");
        images.add("Buchada.png");
        images.add("Carne de sol.png");
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