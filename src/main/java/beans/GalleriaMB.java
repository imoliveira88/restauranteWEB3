/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Magalhães Oliveira
 */
@ManagedBean(name = "galleriaMB")
@SessionScoped
public class GalleriaMB {  
    private final ArrayList<String> imagens;  
    private String effect = "fade";  
    private int i;  
  
   public GalleriaMB(){  
        imagens = new ArrayList<>();  
  
        for(i=1;i<=5;i++) {  
            imagens.add(i+ ".jpg");  
        }  
    }  
  
    public ArrayList<String> getImagens() {  
        return imagens;  
    }  
  
    public String getEffect() {  
        return effect;  
    }  
}  
