/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

import java.util.Scanner;

/**
 *
 *AS CLASSES ADMIN E CLIENTES VAO HERDAR DO USUARIO
 */

public class Admin extends Usuario{
   
   public void menuadmin(Usuario usuario, Loja loja, Admin admin, Clientes clientes){  /*Passagem de objeto por parâmetro */
       
        Scanner leia= new Scanner(System.in);
        
        
        
         int opcao;
        
        do{
        System.out.println("\n***************[MENU ADMIN]*****************************");
        System.out.println("Ola Sr/a Admin " +usuario.getEmail()+ ", o que deseja?");
        System.out.println("********************************************************\n");
        System.out.println(" [ 1 ]- Novo Produto "); 
        System.out.println(" [ 2 ]- Novos Usuarios");
        System.out.println(" [ 3 ]- Ver Produtos");
        System.out.println(" [ 4 ]- Ver Usuarios");
        System.out.println(" [ 5 ]- Actualizar Produtos");
        System.out.println(" [ 6 ]- Actualizar Usuarios");
        System.out.println(" [ 7 ]- Remover Produtos ");
        System.out.println(" [ 8 ]- Remover Usuariose ");
        System.out.println(" [ 9 ]- Voltar ao MENU PRINCIPAL");
        System.out.println(" [ 0 ]- Sair ");
        System.out.print("                 Sua resposta: ");
        opcao= leia.nextInt();
        leia.nextLine();
            
        
        
        
         switch (opcao){
           
            case 2 ->{
                System.out.println("\n*************** Novos Usuarios **************************");
                System.out.println(" [ 1 ]- Novo ADMIN ");
                System.out.println(" [ 2 ]- Novo CLIENTE ");
                System.out.print("                      Sua resposta: ");
                
                    int op=leia.nextInt();
                    leia.nextLine();
                        if(op==1){
                
                System.out.println("\n*************** Novo ADMIN***************************");
                System.out.print("DIGITE O SEU NOME: ");
                String nome= leia.nextLine();
                
                System.out.print("DIGITE O SEU MELHOR EMAIL: ");
                String email=leia.nextLine();
           
                System.out.print("DIGITE A SUA SENHA ");
                String senha=leia.nextLine();
                
                /* verificar o formato de email*/
                System.out.println("\nNovo ADMIN "+nome+", foi cadastrado com sucesso, use estes dados para efectuar o login e gerir o sistema.\n");
               
                admin.setNome(nome);
                admin.setEmail(email);
                admin.setSenha(senha);
                
                loja.adicionarAdmin(admin);
                
                        } else if(op==2){
                     
                System.out.println("\n*************** Novo CLIENTE**************************");
                System.out.print("DIGITE O SEU NOME: ");
                String nome= leia.nextLine();
                
                System.out.print("DIGITE O SEU MELHOR EMAIL: ");
                String email=leia.nextLine();
           
                System.out.print("DIGITE A SUA SENHA ");
                String senha=leia.nextLine();
                
                System.out.println("\nParabens e seja Bem Vindo "+nome+", use os seus dados para efectuar o login e finalizar as suas compras.\n");
                clientes.setNome(nome);
                clientes.setEmail(email);
                clientes.setSenha(senha);
                
                /* adicionei os cleintes a nossa loja passando como parametro o ojbeto completo de */
                /*modos a nao perder os dados */
                loja.adicionarclientes(clientes);
                
                     
                     
                 }
            }
            
            
            
            case 4 ->{
                
                System.out.println("\n*********VER USUARIOS ACTIVOS ");
                
                    System.out.println("***********************ADMIN ACTIVOS*****************************\n");
                for( Admin adm: loja.getAdm() ){
                    System.out.println("*****************************************************************");
                    System.out.println("Nome: "+adm.getNome());
                    System.out.println("Email: "+adm.getEmail());
                    System.out.println("Senha: "+adm.getSenha());
                    System.out.println("*****************************************************************");
                }
                
                    System.out.println("**********************CLIENTES ACTIVOS***************************\n");
                
                for( Clientes cliente: loja.getClientes() ){
                    System.out.println("*****************************************************************");
                    System.out.println("Nome "+cliente.getNome());
                    System.out.println("Email: "+cliente.getEmail());
                    System.out.println("Senha"+cliente.getSenha());
                    System.out.println("*****************************************************************");
                }
            
                
                    System.out.println(" [ 1 ]- Voltar ao MENU ADMIN");
                    System.out.print("                                 Sua resposta: ");
                        
                    int op=leia.nextInt();
                        if(op==1){
                            admin.menuadmin(usuario, loja, admin, clientes);
                        }
                
                
                
                /*System.out.println(" [ 1 ]- Ver ADMIN ");
                System.out.println(" [ 2 ]- Ver CLIENTE ");
                System.out.print("                      Sua resposta: ");
                
                    int op=leia.nextInt();
                    leia.nextLine();*/
                    
                    
                    
            }
            
            case 9 ->{
               return;
            }
            
            case 0 ->{
                return ;
            }
            
        }
         
         
        
        }while(opcao!=0);
        
       
        
        
        
   }

  
  
     
}
