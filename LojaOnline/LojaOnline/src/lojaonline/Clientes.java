/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author MM
 */
public class Clientes extends Usuario {
    
     /* Cada cliente tem o seu carrinho ///*
         *//* os produtos que estao no carrinho pertencem ao cleitne*/
    private ArrayList<Produto> carrinho = new ArrayList<>(); 

    
    public ArrayList<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(ArrayList<Produto> carrinho) {
        this.carrinho = carrinho;
    }
    
    
    
    
    
     public void menucliente(Clientes cliente){
         
        Scanner leia= new Scanner(System.in);
        int opcao;
      
         
        System.out.println("\n***************[MENU CLIENTE]******************");
        System.out.println("Ola "+cliente.getNome()+", o que deseja?");
        System.out.println("***********************************************\n");
        
        
        
        do{
            
        System.out.println(" [ 1 ]- Ver Produtos ");
        System.out.println(" [ 2 ]- Adicionar ao Carrinho ");
        System.out.println(" [ 3 ]- Remover do carrinho");
        System.out.println(" [ 4 ]- Fazer Checkout ");
        System.out.println(" [ 5 ]- Ver o meu carrinho ");
        System.out.println(" [ 6 ]- Voltar ao MENU PRINCIPAL ");
        System.out.println(" [ 0 ]- Logout  ");
        System.out.print("                 Sua resposta: ");
        
        opcao=leia.nextInt();
        
        }while(opcao!=0);
       
       
        
   
        
     
    }
  
        
     
}
