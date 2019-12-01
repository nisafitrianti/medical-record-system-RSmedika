/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medical.record.Controller;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import medical.record.Model.Dokter;
import medical.record.View.ViewLogin;
import sun.rmi.transport.Connection;

/**
 *
 * @author Acer
 */
public class Main {
    
    public static void main(String[] args) {
        new ViewLogin().setVisible(true);
    }
}
