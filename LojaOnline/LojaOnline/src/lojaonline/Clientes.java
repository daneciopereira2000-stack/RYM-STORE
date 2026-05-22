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
    
    
     public void menucliente(Clientes cliente, Loja loja){
         
        Scanner leia= new Scanner(System.in);
        int opcao;
      
        
       
        
        
        
        do{


        System.out.println("\n***************[MENU CLIENTE]******************");
        System.out.println("Ola "+cliente.getNome()+", o que deseja?");
        System.out.println("***********************************************\n");
            
        System.out.println(" [ 1 ]- Ver Produtos ");
        System.out.println(" [ 2 ]- Adicionar ao meu Carrinho ");
        System.out.println(" [ 3 ]- Remover do meu carrinho");
        System.out.println(" [ 4 ]- Ver o meu carrinho ");
        System.out.println(" [ 5 ]- Fazer Checkout ");
        System.out.println(" [ 6 ]- Voltar ao MENU PRINCIPAL ");
        System.out.println(" [ 0 ]- Logout  ");
        System.out.print("                                      Sua resposta: ");
        
        opcao=leia.nextInt();
        leia.nextLine();

        
        switch (opcao) {

            case 1->{

                 System.out.println("\n*************** VER PRODUTOS ******************");
                loja.visualizar_produto(); }

            case 2->{

                System.out.println("\n*************** ADICIONAR AO MEU CARRINHO ******************");

   
    loja.visualizar_produto();

    
    System.out.print("Digite o ID do produto: ");
    int id = leia.nextInt();

    
    System.out.print("Digite a quantidade: ");
    int qtd = leia.nextInt();

    
    loja.adicionar_ao_carrinho(qtd, id); }


            case 3->{

                System.out.println("\n*************** REMOVER DO MEU CARRINHO ******************");
                loja.visualizar_produto();
            System.out.print(" DIGITE O ID DO PRODUTO QUE PRETENDE REMOVER: ");
            int id =leia.nextInt();

            loja.remover_do_carrinho(id);  }


            case 4->{

                System.out.println("\n*************** VER MEU CARRINHO ******************");
                loja.visualizar_meu_carrinho();


            }

            case 5->{

                System.out.println("\n************** CHECKOUT ******************");
                loja.finalizar_compra();

            }



}

            
          
        }while(opcao!=0);
       
       
        
   
        
     
    }
  
        
     
}
