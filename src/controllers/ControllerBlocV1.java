package controllers;
import views.ViewBlocV1;
import models.ModelBlocV1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jose Felix
 */
public class ControllerBlocV1 {
    ModelBlocV1 modelBlocV1; 
    ViewBlocV1 viewBlocV1;
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewBlocV1.jm_leer) {
                jm_leer_action_performed();
            }
            else if (e.getSource() == viewBlocV1.jm_guardar) { 
                jm_guardar_action_performed();
            }
            else if (e.getSource() == viewBlocV1.jm_cifrar) { 
                jm_cifrar_action_performed();
            }
            else if (e.getSource() == viewBlocV1.jm_decifrar) { 
                jm_decifrar_action_performed();
            }
        }
    };
    
    
    public ControllerBlocV1(ModelBlocV1 modelBlocV1, ViewBlocV1 viewBlocV1) {
        this.modelBlocV1 = modelBlocV1;
        this.viewBlocV1 = viewBlocV1;
        this.viewBlocV1.jm_leer.addActionListener(actionlistener);
        this.viewBlocV1.jm_guardar.addActionListener(actionlistener);
        this.viewBlocV1.jm_cifrar.addActionListener(actionlistener);
        this.viewBlocV1.jm_decifrar.addActionListener(actionlistener);
        initComponents();
    }
    
    
    public void jm_leer_action_performed() {
        modelBlocV1.abrirArchivo();
        modelBlocV1.readFile(modelBlocV1.getPath());
        viewBlocV1.jt_texto.setText(modelBlocV1.getMessage());
    }
    
    
    public void jm_guardar_action_performed() {
        modelBlocV1.setMessage(viewBlocV1.jt_texto.getText()); 
        modelBlocV1.writeFile(modelBlocV1.getPath(), modelBlocV1.getMessage()); 
    }
    
    public void jm_cifrar_action_performed(){
        modelBlocV1.setTexto(viewBlocV1.jt_texto.getText());
        modelBlocV1.jm_cifrar_action_performed();
        viewBlocV1.jt_texto.setText(modelBlocV1.getCifrar());
    }
    public void jm_decifrar_action_performed(){
        modelBlocV1.setTexto(viewBlocV1.jt_texto.getText());
        modelBlocV1.jm_decifrar_action_performed();
        viewBlocV1.jt_texto.setText(modelBlocV1.getDecifrar());
    }
    public void initComponents() {
        viewBlocV1.setVisible(true);
    }
}
