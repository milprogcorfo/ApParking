/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class CtrlArrendador implements ActionListener {
    
    modelo.BDArrendador bd;
    vista.FormArrendador form;
    
    public CtrlArrendador(modelo.BDArrendador bd, vista.FormArrendador form) {
        this.bd = bd;
        this.form = form;
        
        form.btnSave.addActionListener(this);
        form.btnClear.addActionListener(this);
        form.btnCancel.addActionListener(this);
        form.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        String ac = ae.getActionCommand();
        switch (ac) {
            case "CMD_SAVE":
                try {
                    modelo.Arrendador a = new modelo.Arrendador();
                    a.setRut(form.txtRut.getText());
                    a.setNombre(form.txtNombre.getText());
                    a.setApellido(form.txtApellido.getText());
                    a.setCiudad(form.txtCiudad.getText());
                    a.setDir(form.txtDir.getText());
                    a.setPlaza(Integer.parseInt(form.txtPlaza.getText()));
                    a.setFono(form.txtFono.getText());
                    a.setMail(form.txtMail.getText());
                    // Antes de asignar el pass, se convierte de 'array de chars' a String.
                    String asd = new String(form.txtPass.getPassword());
                    a.setPass(asd);
                    String asdf = bd.agregarArrendador(a);
                    switch (asdf) {
                        case "OK":
                            JOptionPane.showMessageDialog(form, "¡Felicidades, te has regitrado exitosamente!");
                            form.setVisible(false);
                            break;
                        case "SQL":
                            JOptionPane.showMessageDialog(form, "Error al intentar conectar con la base de datos.");
                            break;
                        case "NUMBER":
                            JOptionPane.showMessageDialog(form, "Error, al parecer ingresaste carácteres inválidos en el campo 'Disponibilidad'. ");
                            break;
                    }
                    break;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(form, "Error, al parecer ingresaste carácteres inválidos en el campo 'Disponibilidad'. ");
                    break;
                }
            case "CMD_CLEAN":
                int op = JOptionPane.showConfirmDialog(form, "¿Estás segur@?");
                if (op == 0) {
                    form.txtRut.setText("");
                    form.txtNombre.setText("");
                    form.txtApellido.setText("");
                    form.txtCiudad.setText("");
                    form.txtDir.setText("");
                    form.txtPlaza.setText("");
                    form.txtFono.setText("");
                    form.txtMail.setText("");
                    form.txtPass.setText("");
                    JOptionPane.showMessageDialog(form, "¡La pantalla ha sido limpiada!");
                }
                break;
            case "CMD_CANCEL":
                form.setVisible(false);
                break;
        }
    }
}
