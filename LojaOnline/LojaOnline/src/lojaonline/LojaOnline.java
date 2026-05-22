/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lojaonline;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MM
 */



public class LojaOnline {
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner leia= new Scanner(System.in);
        int opcao;
        
        Usuario usuario= new  Usuario();
        Produto produto= new  Produto();
        Clientes clientes = new Clientes();
        Loja loja = new Loja();
        Admin admin= new Admin();
        int id =0;
        
       
        
         Pattern pattern = Pattern.compile("@gmail\\.com$");
         Matcher match;
         
        do{
            System.out.println("");
            System.out.println("");
        
        System.out.println("***************[MENU PRINCIPAL]******************"); 
            
        System.out.println(" [ 1 ]- Login ");
        System.out.println(" [ 2 ]- Cadastrar-me ");
        System.out.println(" [ 3 ]- Ver produtos");
        System.out.println(" [ 0 ]- Sair   ");
        System.out.print("                              Sua resposta: ");
        opcao= leia.nextInt();
        leia.nextLine();
        
        
         switch(opcao){
            case 1 -> {
                
                boolean ativo = false;
                System.out.println("\n*************** LOGIN ***************************");
                
                System.out.print("DIGITE O EMAIL: ");
                String email = leia.nextLine();
                
                
                System.out.print("DIGITE A SENHA: ");
                String senha=leia.nextLine();
                
                usuario.setEmail(email);
                usuario.setSenha(senha);
              
                if("admin@gmail.com".equals(usuario.getEmail()) && "1234".equals(usuario.getSenha())){
                    ativo = true;
                    admin.menuadmin(usuario,loja, admin, clientes,produto); /* CHAMADA DO METODO QUE ESTA NA CLASSE ADMIN*/
                }
                
                for( Clientes cliente: loja.getClientes() ){
                    if(cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)){
                        ativo = true;
                        clientes.menucliente(cliente, loja);
                    }
                 }
                 
                for(Admin administrador: loja.getAdm()){
                    
                    if(administrador.getEmail().equals(email) && administrador.getSenha().equals(senha) ){
                        admin.menuadmin(usuario, loja, admin, clientes,produto);
                    } 
                    
                }
                
                if(!ativo){
                    System.out.println(" Oooops, dados incorrectos, tente novamente !");}
                    
            }
            
            case 2 ->{
               
                    /*USAR NA VISULIZACQO DE CLIENTES ACTIVOS*/
                    
                  /*for( Clientes cliente: loja.getClientes() ){
                    System.out.println(" "+cliente.getEmail());
                    System.out.println(" "+cliente.getNome());
                    System.out.println(" "+cliente.getSenha());
                }*/
                  
                System.out.println("\n*************** CADASTRAR **********************\n");
               
                System.out.print("DIGITE O SEU NOME: ");
                String nome= leia.nextLine();
                
                System.out.print("DIGITE O SEU MELHOR EMAIL: ");
                String email=leia.nextLine();
                
               
                match = pattern.matcher(email);
                
                
                while(match.find() != true){
                    System.out.println("email invalido");
                    System.out.println("Exemplo:user@gmail.com"); 
                    System.out.print("Digite novamente: ");
                    email=leia.nextLine();
                    
                    match = pattern.matcher(email);
                }
                    
     
                
                System.out.print("DIGITE A SUA SENHA ");
                String senha=leia.nextLine();
                
                id++;
                
                /* verificar o formato de email*/
                System.out.println("\nParabens e seja Bem Vindo "+nome+", use os seus dados para efectuar o login e finalizar as suas compras.\n");
               /* System.out.println("*************************************************");*/
                /* setando cada dados no objecto da classe cliente*/
                
                clientes.setNome(nome);
                clientes.setEmail(email);
                clientes.setSenha(senha);
                clientes.setid(id);
                
                        
                
                /* adicionei os cleintes a nossa loja passando como parametro o ojbeto completo de */
                /*modos a nao perder os dados */
                loja.adicionarclientes(clientes);
               
            }
            
            case 3 ->{
                System.out.println("*************** VER PRODUTOS ******************");
                loja.visualizar_produto();
              
            }
            
            case 0 ->{
                return;
            }
         }
         
        
        }while(opcao!=0);
        
       
               
        
    }
    
}
