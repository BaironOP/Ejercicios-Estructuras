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
                    + "2. Mover a otra lista"
                    + "3. Imprimir lista"
                    + "4. Buscar contacto");
            boolean existente=false;
            if (input.equals("1")){
                nNombre = JOptionPane.showInputDialog("Inserte el Nombre");
                nTelefono = JOptionPane.showInputDialog("Inserte el telefono");
                nCiudad = JOptionPane.showInputDialog("Inserte la ciudad");
                lista = JOptionPane.showInputDialog("A que lista quiere añadirlo?"+""
                        + "1. Lista Nacional"+""
                        + "2. Lista Internacional");
                nContacto = new Contacto(nNombre, nTelefono, nCiudad);
                
                if (lista.equals("1")){
                    for (int i = 0; i<contactNat.getSize(); i++){
                        existente = contactNat.get(i).equals(nContacto);
                    }
                    if (!existente){
                        contactNat.add(nContacto);
                    }else{
                        JOptionPane.showMessageDialog(null, "El contacto ya existe en esta lista");
                    }
                } else if (lista.equals("2")){
                    for (int i = 0; i<contactInter.getSize(); i++){
                        existente = contactInter.get(i).equals(nContacto);
                    }
                    if (!existente){
                        contactInter.add(nContacto);
                    }else{
                        JOptionPane.showMessageDialog(null, "El contacto ya existe en esta lista");
                    }
                }
            }else if (input.equals("2")){
                int index=0;
                input = JOptionPane.showInputDialog("En que lista esta el contacto que quiere mover?"
                        + "1. Lista nacional"
                        + "2. Lista internacional");
                if (input.equals("1")){
                    input = JOptionPane.showInputDialog("Digite el nombre o el numero de contacto a cambiar");
                    for (int i = 0; i<contactNat.getSize(); i++){
                        existente = contactNat.get(i).getNombre().equals(input);
                        existente = contactNat.get(i).getTelefono().equals(input);
                        if (existente) index = i;
                    }
                    if (existente){
                        contactInter.add(contactNat.get(index));
                        contactNat.delete(contactNat.get(index));
                    } else {
                        JOptionPane.showMessageDialog( null, "El contacto no existe");
                    }
                } else if (input.equals("2")){
                    input = JOptionPane.showInputDialog("Digite el nombre o el numero de contacto a cambiar");
                    for (int i = 0; i<contactInter.getSize(); i++){
                        existente = contactInter.get(i).getNombre().equals(input);
                        existente = contactInter.get(i).getTelefono().equals(input);
                        if (existente) index = i;
                    }
                    if (existente){
                        contactNat.add(contactInter.get(index));
                        contactInter.delete(contactInter.get(index));
                    } else {
                        JOptionPane.showMessageDialog( null, "El contacto no existe");
                    }
                } else if (input.equals("3")){
                    input = JOptionPane.showInputDialog("Cual lista quiere imprimir?"
                            + "1. Lista nacional"
                            + "2. Lista internacional"
                            + "3. Todas las listas");
                    if (input.equals("1")){
                        for (int i = 0; i<contactNat.getSize(); i++){
                            System.out.println(contactNat.get(i).nombre+""+contactNat.get(i).telefono+""+contactNat.get(i).ciudad);
                        }
                    }else if (input.equals("2")){
                        for (int i = 0; i<contactInter.getSize(); i++){
                            System.out.println(contactInter.get(i).nombre+""+contactInter.get(i).telefono+""+contactInter.get(i).ciudad);
                        }
                    }else if (input.equals("3")){
                        for (int i = 0; i<contactNat.getSize(); i++){
                            System.out.println(contactNat.get(i).nombre+""+contactNat.get(i).telefono+""+contactNat.get(i).ciudad);
                        }
                        for (int i = 0; i<contactInter.getSize(); i++){
                            System.out.println(contactInter.get(i).nombre+""+contactInter.get(i).telefono+""+contactInter.get(i).ciudad);
                        }
                    }
                }else if (input.equals("4")){
                    input = JOptionPane.showInputDialog("En que lista esta el contacto que quiere buscar?"
                        + "1. Lista nacional"
                        + "2. Lista internacional");
                    if (input.equals("1")){
                        input = JOptionPane.showInputDialog("Digite el nombre o el numero de contacto a buscar");
                        for (int i = 0; i<contactNat.getSize(); i++){
                            existente = contactNat.get(i).getNombre().equals(input);
                            existente = contactNat.get(i).getTelefono().equals(input);
                            if (existente) index = i;
                        }
                        if (existente){
                            JOptionPane.showMessageDialog( null, contactNat.get(index).toString());
                        } else {
                            JOptionPane.showMessageDialog( null, "El contacto no existe");
                        }
                    } else if (input.equals("2")){
                        input = JOptionPane.showInputDialog("Digite el nombre o el numero de contacto a buscar");
                        for (int i = 0; i<contactInter.getSize(); i++){
                            existente = contactInter.get(i).getNombre().equals(input);
                            existente = contactInter.get(i).getTelefono().equals(input);
                            if (existente) index = i;
                        }
                        if (existente){
                            JOptionPane.showMessageDialog( null, contactInter.get(index).toString());
                        } else {
                            JOptionPane.showMessageDialog( null, "El contacto no existe");
                        }
                        
                    }
                }
            }
        }
    }
}
