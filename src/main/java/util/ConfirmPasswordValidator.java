package util;

import java.util.ResourceBundle;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.faces.application.FacesMessage;
  
@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator {
  
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {
  
        UIInput passwordComponent = (UIInput) component.getAttributes().get("passwordComponent");
        String password = (String) passwordComponent.getValue();
  
        String confirm = (String) value;
        
        ResourceBundle bundle = ResourceBundle.getBundle("extras.messages");
        String alerta = bundle.getString("notConfirm");
        
        if (!password.equals(confirm)) {
            throw new ValidatorException(new FacesMessage(alerta));
        }
    }
}