package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author alejandro
 */
public class CtrlRegistro extends JFrame implements ActionListener {

    modelo.BDUsuario bd;
    vista.FormUsuario form;

    public CtrlRegistro(modelo.BDUsuario bd, vista.FormUsuario form) {
        this.bd = bd;
        this.form = form;
        this.form.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para evitar cerrar todo el programa al cerrar la ventana de registro.

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
                    boolean comp = true; // Para comprobar que los datos estén correctos antes de ser guardados (apenas se encuentre un error en el formulario, se cambiará su valor a 'false').

                    char[] asd = form.txtTelefono.getText().toCharArray(); // Comprobamos que el campo de texto 'Teléfono' contenga solo números.
                    for (int i = 0; i < asd.length; i++) {
                        if (asd[i] != '0' || asd[i] != '1' || asd[i] != '2' || asd[i] != '3' || asd[i] != '4' || asd[i] != '5' || asd[i] != '6' || asd[i] != '7' || asd[i] != '8' || asd[i] != '9') {
                            JOptionPane.showMessageDialog(form, "¡Campo 'teléfono' contiene carácteres incorrectos!");
                            comp = false;
                            break;
                        }
                    }

                    if (comp == true) {  // Luego , si no encontraron errores en el campo 'Teléfono', comprobamos que el campo 'Email' contenga un signo arroba y un punto.
                        char[] mail = form.txtEmail.getText().toCharArray();
                        boolean arroba = false;
                        boolean punto = false;
                        for (int i = 0; i < mail.length; i++) {
                            if (mail[i] == '@') {
                                arroba = true;
                            } else if (mail[i] == '.') {
                                punto = true;
                            }
                        }
                        if (arroba == false || punto == false) { // Si falta uno de los signos antes mencionados, se le informa al usuario que los datos ingresados son inválidos.
                            JOptionPane.showMessageDialog(form, "¡Email ingresado es inválido!");
                            comp = false;
                        }
                    }

                    if (comp == true) { // Si no se encontraron errores en el formulario, se procede a ingresar al nuevo usuario en la base de datos.
                        modelo.Usuario c = new modelo.Usuario();
                        c.setRut(form.txtRut.getText());
                        c.setPrimNombre(form.txtPrimNombre.getText());
                        c.setSegNombre(form.txtSegNombre.getText());
                        c.setApPaterno(form.txtApPaterno.getText());
                        c.setApMaterno(form.txtApMaterno.getText());
                        c.setNacimiento(form.txtNacimiento.getDate().toString());
                        c.setPatente(form.txtPatente.getText());
                        c.setDireccion(form.txtDireccion.getText());
                        c.setEmail(form.txtEmail.getText());
                        c.setTelefono(form.txtTelefono.getText());
                        if (form.btnNo.isSelected() == true) {
                            c.setEsPropietario(0);
                        } else {
                            c.setEsPropietario(1);
                        }
                        boolean asdf = bd.agregarConductor(c);
                        if (asdf == true) {
                            JOptionPane.showMessageDialog(form, "¡Te has registrado exitosamente!");
                        } else {
                            JOptionPane.showMessageDialog(form, "Error al intentar registro de usuario.");
                        }
                    }

                    break;
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(form, "Error, al parecer ingresaste carácteres inválidos en el campo 'Disponibilidad'. ");
                    break;
                }
            case "CMD_CLEAN":
                form.txtRut.setText("");
                form.txtPrimNombre.setText("");
                form.txtSegNombre.setText("");
                form.txtApPaterno.setText("");
                form.txtApMaterno.setText("");
                form.txtPatente.setText("");
                form.txtDireccion.setText("");
                form.txtEmail.setText("");
                form.txtTelefono.setText("");
                form.txtPass.setText("");
                form.txtPassConf.setText("");
                break;
            case "CMD_CANCEL": // Decoración.
                break;
        }
    }
}
