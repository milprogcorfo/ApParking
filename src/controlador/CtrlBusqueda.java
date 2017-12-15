package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.ModArrendador;
import modelo.ModBDArrendador;
import vista.Busqueda;

public class CtrlBusqueda extends JFrame implements ActionListener, MouseListener {
    
    vista.Busqueda reserva;
    modelo.ModBDArrendador bda;
    modelo.ModArrendador ma;
    
    public CtrlBusqueda(Busqueda res, ModBDArrendador bda, ModArrendador mod) {
        this.reserva = res;
        this.bda = bda;
        this.ma = mod;
        this.reserva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        res.btnBuscar2.addActionListener(this);
        res.btnReservar.addActionListener(this);
        res.cbxCiudad.addActionListener(this);
        
        reserva.setVisible(true);
        System.out.println("funcionando");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        String asd;
        boolean res;
        modelo.ModArrendador aux = new modelo.ModArrendador();
        System.out.println(cmd);
        
        switch (cmd) {
            case "comboBox":
                
                ArrayList<modelo.ModArrendador> user;
                DefaultTableModel modelo = (DefaultTableModel) reserva.tabla2.getModel();
                
                modelo.setRowCount(0);
                user = bda.buscarEst(reserva.cbxCiudad.getSelectedItem().toString());
                
                for (modelo.ModArrendador arrendador : user) {
                    Object[] fila = new Object[8];
                    
                    fila[0] = arrendador.getRut();
                    fila[1] = arrendador.getNombre();
                    fila[2] = arrendador.getApellido();
                    fila[3] = arrendador.getCiudad();
                    fila[4] = arrendador.getDir();
                    fila[5] = "" + arrendador.getPlaza();
                    fila[6] = arrendador.getFono();
                    fila[7] = arrendador.getMail();
                    modelo.addRow(fila);
                }
                break;
            
            case "Reservar":
                modelo.Arrendador a = (modelo.Arrendador) reserva.cbxCiudad.getSelectedItem();
                
                try {
                    int ghj;
                    ModArrendador qq = ModArrendador.class.cast(reserva.cbxCiudad.getSelectedItem());
                    qq.setPlaza(bda.Reservar(qq.getRut()));

                    //Código improvisado.
                    DefaultTableModel modelo2 = (DefaultTableModel) reserva.tabla2.getModel();
                    modelo2.setRowCount(0);
                    user = bda.buscarEst(reserva.cbxCiudad.getSelectedItem().toString());
                    for (modelo.ModArrendador arrendador : user) {
                        Object[] fila = new Object[8];
                        
                        fila[0] = arrendador.getRut();
                        fila[1] = arrendador.getNombre();
                        fila[2] = arrendador.getApellido();
                        fila[3] = arrendador.getCiudad();
                        fila[4] = arrendador.getDir();
                        fila[5] = "" + arrendador.getPlaza();
                        fila[6] = arrendador.getFono();
                        fila[7] = arrendador.getMail();
                        modelo2.addRow(fila);
                    }
                    JOptionPane.showMessageDialog(reserva, "Reserva exitosa.");
                    break;
//  
                } catch (NumberFormatException o) {
                    JOptionPane.showMessageDialog(reserva, "Sin Disponibilidad");
                }
                break;
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(e.paramString());
        int row = reserva.tabla2.getSelectedRow();
        System.out.println("fila:" + row);
        String rut = (String) reserva.tabla2.getModel().getValueAt(row, 0);

        //reserva.btnReservar.getActionCommand();
        //reserva.btnReservar.addActionListener(this);
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
