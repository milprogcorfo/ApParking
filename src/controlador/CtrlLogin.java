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
public class CtrlLogin implements ActionListener {

    vista.Login login;
    modelo.BDUsuario bd = new modelo.BDUsuario();

    public CtrlLogin(vista.Login login) {
        this.login = login;

        login.btnLogin.addActionListener(this);
        login.btnReg.addActionListener(this);
        login.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String cmd = ae.getActionCommand();
        switch (cmd) {
            case "CMD_LOGIN":
                String user = login.txtRut.getText();
                String pass = new String(login.txtPass.getPassword());
                modelo.ModBDArrendador bda = new modelo.ModBDArrendador();

                boolean res = bd.logIn(user, pass);
                if (res == true) {
                    JOptionPane.showMessageDialog(login, "Login realizado con éxito.");
                    // Aquí va la ventana de reserva.
                    modelo.ModArrendador mod = new modelo.ModArrendador();
                    vista.Busqueda busq = new vista.Busqueda();
                    controlador.CtrlBusqueda ctrb = new controlador.CtrlBusqueda(busq, bda, mod);
                } else {
                    JOptionPane.showMessageDialog(login, "Error, Usuario/Contraseña inválido(s).");
                }
                break;
            case "CMD_REG":
                vista.FormUsuario form = new vista.FormUsuario();
                controlador.CtrlRegistro ctrlReg = new controlador.CtrlRegistro(bd, form);
                break;
        }
    }
}
