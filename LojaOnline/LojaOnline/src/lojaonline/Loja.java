/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;
import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author MM
 */
public class Loja {
   
   private ArrayList<Produto> produtos =  new ArrayList<>();
   private ArrayList<Clientes> clientes =  new ArrayList<>();
   private ArrayList<Admin> adm =  new ArrayList<>();

    public ArrayList<Admin> getAdm() {
        return adm;
    }

    public void setAdm(ArrayList<Admin> adm) {
        this.adm = adm;
    }

   
    
    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
    public void adicionarclientes( Clientes cliente){
       
        /*adiciona os clientes que foram setados /*
        *//* no objeto clientes la no menu prinicpal */
        clientes.add(cliente); 
        
     }
    
        
    
        
        
      public void adicionarAdmin( Admin admin){
       
      
       adm.add(admin);
       
        
     }
    
        public ArrayList<Admin> obterAdm(){
            /*ESSA FUNCAO NOS AJUDA A OBTER OS CLIENTES E VERIFICAR LA NO LOGIN USANDO ORETORNO*/
        return adm;
    }

    
   
    
    
}
