/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;
import java.util.ArrayList;

/**
 *
 * @author MM
 */
public class Loja {
   private ArrayList<Produto> carrinho = new ArrayList<>();
   private ArrayList<Integer> quantidade = new ArrayList<>();
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
    
    //cliente
    public void adicionarclientes( Clientes cliente){
       int id = 0;
        /*adiciona os clientes que foram setados /*
        *//* no objeto clientes la no menu prinicpal */
        for(Clientes cli: clientes){
            id = cli.getid();
        }
        id++;
        cliente.setid(id);
        clientes.add(cliente);
 
     }
    

    // admin 
      public void adicionarAdmin( Admin admin){
          int id =0;
          for(Admin ad: adm){
                id = ad.getid(); 
          }
       
       admin.setid(id);
       adm.add(admin);
      
     }
      
    
        public ArrayList<Admin> obterAdm(){
            /*ESSA FUNCAO NOS AJUDA A OBTER OS CLIENTES E VERIFICAR LA NO LOGIN USANDO ORETORNO*/
        return adm;
    }

        
        
    // funcionalidades do produto
    public void adicionar_produto(Produto produto){
        int id=0; 
        
        for(Produto p: produtos){
            id = p.getId();
        }    
        
        id++;
        produto.setId(id);
        produtos.add(produto);
    }
    
    public void remover_produto(int id){
        
        for(int i = 0; i < produtos.size(); i++){
                
            Produto p = produtos.get(i);
            if(p.getId() == id){
                produtos.remove(p);
                System.out.println("Produto removido com sucesso !!");
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }
        





   public void visualizar_produto(){

    System.out.println("\n===================================== LISTA DE PRODUTOS =====================================");

    System.out.printf("%-6s %-25s %-25s %-15s %-10s%n",
            "ID",
            "Nome",
            "Categoria",
            "Preço (AKZ)",
            "Stock");

    System.out.println("==============================================================================================");

    for(Produto p : produtos){

        System.out.printf("%-6d %-25s %-25s %-15.2f %-10d%n",
                p.getId(),
                p.getNomeproduto(),
                p.getCategoriaproduto(),
                p.getPrecoproduto(),
                p.getEstoque());
    }

    System.out.println("==============================================================================================\n");
} 
   
   public int procurar_produto(int id){
       
       for(Produto p:produtos){
           if(p.getId() == id)
               return 1;
       
       }
       return 0;
   }
   
   public void actualizar_produto(int id, String name, float preco, int qtd){
       
       for(Produto p: produtos){
           if(p.getId()== id){
               
               p.setNomeproduto(name);
               p.setPrecoproduto(preco);
               p.setEstoque(qtd);
               System.out.println(" Os dados do produto foram actualizados !!");
               return;
           }
       
       }
       System.out.println("Produto não encontrado");
   
   }
   
   // funcionalidades do carrinho
   
   public int verficar_no_carrinho(int id){
       int qtd= 0;
       for(int i = 0; i<carrinho.size(); i++){
           Produto p = carrinho.get(i);
           if(p.getId() == id)
               qtd = qtd+ quantidade.get(i);
       }
       return qtd;
   }
    
    public void adicionar_ao_carrinho(int qtd, int id){
        
        for (Produto p : produtos){
            if(id == p.getId()){
                qtd = qtd + verficar_no_carrinho(id);      
                if(p.getEstoque() < qtd){


                    System.out.println("Oooops, essa quantidade ultrapassa o nosso estoque !! ");
                    System.out.println("ESTOQUE: "+p.getEstoque());
                    System.out.println("QUANTIDADE PEDIDA: "+qtd);
                    return;
                }
                
                // caso ja exista no carrinho
            for (int i = 0; i < carrinho.size(); i++){
                    
                    if(carrinho.get(i).getId() == id){
                        
                        quantidade.set(i,qtd);
                        System.out.println("quantidade foi actualizada no produto do carrinho");
                        return; 
                    }
                }
                
                carrinho.add(p);
                quantidade.add(qtd);
                System.out.println(" O seu produto foi adicionado ao carrinho com sucesso !!");
                return;
            }
        
        }
        System.out.println("Oooops, este produto não foi encontrado");
       
    }


    
    public void remover_do_carrinho(int id){
        
        for(int i=0; i<carrinho.size();i++){
            
            if(carrinho.get(i).getId() == id){
                carrinho.remove(i);
                carrinho.remove(i);
                
                System.out.println(" Produto removido com sucesso !! ");
                return;
            }
                
        }
        System.out.println("Produto não encontrado");
    }
   
    
    public void visualizar_meu_carrinho(){
        
        for(int i = 0; i< carrinho.size(); i++){
           Produto p = carrinho.get(i);
            int qtd = quantidade.get(i);
           float  preco_final=0;

            preco_final = preco_final + (p.getPrecoproduto() * qtd);
            
            System.out.println("PRODUTO: "+p.getNomeproduto());
            System.out.println("ID:"+p.getId());
            System.out.println("PRECO:"+p.getPrecoproduto());
            System.out.println("QUANTIDADE: "+qtd);

            System.out.println("*********************************************************************");
            System.out.println("    TOTAL A PAGAR: "+preco_final+" AKZ");
            System.out.println("*********************************************************************");

            
        }
        
    }

     public float finalizar_compra(){
        float preco_final =0;

        if(carrinho.isEmpty()){

        System.out.println("\nO seu carrinho está vazio.");
        return 0;
    }

        
        for (int i = 0; i< carrinho.size(); i++){
            Produto p = carrinho.get(i);
            int qtd = quantidade.get(i);
            
            for(Produto p2: produtos){
                if(p.getId() == p2.getId()){
                    
                    int quant = p2.getEstoque();
                    
                    quant = quant - qtd;
                    
                    p2.setEstoque(quant);
     
                }       
            }
            preco_final = preco_final + (p.getPrecoproduto() * qtd);
        }
        
        carrinho.clear();
        quantidade.clear();
        
        return preco_final;
        
    }

     
     public void esvaziar_o_carrinho(){
         
         carrinho.clear();
         quantidade.clear();
     }
     
}
