/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

import java.util.Scanner;


/**
 *
 * @author MM
 */
public class Clientes extends Usuario {
    
    
    
    
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
                float  preco_final =loja.finalizar_compra();
                if(preco_final > 0){
                
                System.out.println("*********************************************************************");
                System.out.println("    TOTAL A PAGAR: "+preco_final+" AKZ");
                System.out.println("*********************************************************************");
                System.out.println( " SUCESSO, AGRADECEMOS A SUA PREFERENCIA, VOLTE SEMPRE ! ");
                
                }
                

            }



}
          
        }while(opcao!=0);
        
        loja.esvaziar_o_carrinho();
       
    }
  
        
     
}
