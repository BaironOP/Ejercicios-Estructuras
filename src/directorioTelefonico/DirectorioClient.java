/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package directorioTelefonico;

import javax.swing.JOptionPane;
import listas.TwinLinkedList;

/**
 *
 * @author Usuario
 */
public class DirectorioClient {
    
    private static TwinLinkedList<Contacto> contactInter = new TwinLinkedList<>();
    private static TwinLinkedList<Contacto> contactNat = new TwinLinkedList<>();
    private static boolean m = true;
    
    public static void main (String[] args){
        String input;
        String nNombre;
        String nTelefono;
        String nCiudad;
        String lista;
        Contacto nContacto;
        boolean l;
        while (m){
            input = JOptionPane.showInputDialog("Menú Principal"
                    + "1. Añadir contacto"
                    + "2. Mover a otra lista");
            if (input.equals("1")){
                nNombre = JOptionPane.showInputDialog("Inserte el Nombre");
                nTelefono = JOptionPane.showInputDialog("Inserte el telefono");
                nCiudad = JOptionPane.showInputDialog("Inserte la ciudad");
                lista = JOptionPane.showInputDialog("A que lista quiere añadirlo?"+""
                        + "1. Lista Nacional"+""
                        + "2. Lista Internacional");
                nContacto = new Contacto(nNombre, nTelefono, nCiudad);
                boolean existente=false;
                if (lista.equals("1")){
                    for (int i = 0; i<contactNat.getSize(); i++){
                        existente = contactNat.get(i).equals(nContacto);
                    }
                    if (existente){
                        contactNat.add(nContacto);
                    }else{
                        JOptionPane.showMessageDialog(null, "El contacto ya existe en esta lista");
                    }
                } else if (lista.equals("2")){
                    for (int i = 0; i<contactInter.getSize(); i++){
                        existente = contactInter.get(i).equals(nContacto);
                    }
                    if (existente){
                        contactInter.add(nContacto);
                    }else{
                        JOptionPane.showMessageDialog(null, "El contacto ya existe en esta lista");
                    }
                }
            }else if (input.equals("2")){
                input = JOptionPane.showInputDialog("");
            }
            
        }
        
    }
    
}
