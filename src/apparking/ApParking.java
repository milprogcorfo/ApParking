/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apparking;

/**
 *
 * @author alejandro
 */
public class ApParking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        vista.Login login = new vista.Login();
        controlador.CtrlLogin main = new controlador.CtrlLogin(login);
    }

}
