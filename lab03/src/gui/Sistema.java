/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Sistema.ContadorDePalavrasJava;
import gui.MainFrame;

/**
 *
 * @author Lurian
 */
public class Sistema {
    
    
    public static void main(String[] args){
        //ContadorDePalavrasJava contador = ContadorDePalavrasJava.getInstance();
        //InterfaceLinhaDeComando gui = new InterfaceLinhaDeComando(contador);
        
        MainFrame mainFrame = new MainFrame();
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
    
}
