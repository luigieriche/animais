/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animais;

import javax.swing.JOptionPane;

/**
 *
 * @author luiz.ferreira
 */
public class Controle {
    Animal primeiro = new Animal();
    
    public void casoBase(){
        primeiro.nome = "raiz";
        
        Animal caso1 = new Animal();
        caso1.nome = "tubarao";
        caso1.caracteristica = "vive na água";
        
        primeiro.proximos.add(caso1);
        
        Animal caso2 = new Animal();
        caso2.nome = "macaco";
        caso2.caracteristica = "vive na terra";
        
        primeiro.proximos.add(caso2);
    }

    public int verifica(Animal objeto){
        Animal auxiliar = new Animal();
        
        for ( int x = 0; x < objeto.proximos.size(); x++){
            auxiliar = objeto.proximos.get(x);
            System.out.println(auxiliar.nome);
            
            int confirma = JOptionPane.showConfirmDialog(null, "O seu animal " + auxiliar.caracteristica + "?");
            
            if (auxiliar.proximos.isEmpty() && confirma == 0){
                confirma = JOptionPane.showConfirmDialog(null, "O seu animal é o " + auxiliar.nome + "?");   
                if (confirma == 0){
                    JOptionPane.showMessageDialog(null, "Acerto!");
                    return 0;
                }
                
                Animal novo = new Animal();
                novo.nome = JOptionPane.showInputDialog("Qual o animal que você escolheu?");
                novo.caracteristica = JOptionPane.showInputDialog("O que este " + novo.nome +" faz que o " + auxiliar.nome + " não?");
                auxiliar.proximos.add(novo);
                
                return 0;
            }
            else if(confirma == 0){
                this.verifica(auxiliar);
                return 0;
            }
        }
        
        Animal novo = new Animal();
        novo.nome = JOptionPane.showInputDialog("Qual o animal que você escolheu?");
        novo.caracteristica = JOptionPane.showInputDialog("O que este " + novo.nome +" faz que o " + auxiliar.nome + " não?");
        objeto.proximos.add(novo);
        return 0;
    }
}
