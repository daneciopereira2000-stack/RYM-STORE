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

        
    // para adicionar um novo produto
    public void adicionar_produto(Produto produto){
        produtos.add(produto);
    }
        
   public void visualizar_produto(){
        System.out.println("==========================================================================================================");
        System.out.println("ID    | Nome                 | Categoria                 | Preço                 | Stock           ");
        System.out.println("==========================================================================================================");
        for(Produto p : produtos){           
           System.out.println(p.getId()+ "|"+p.getNomeproduto()+ "|"+p.getCategoriaproduto()+ "|" +p.getPrecoproduto()+ "|" +p.getEstoque()  );
       }
        System.out.println("==========================================================================================================");
   }
    
   
   // funcionalidades do carrinho
    
    public void adicionar_no_carrinho(int qtd, int id){
        
        for (Produto p : produtos){
            if(id == p.getId()){
                if(p.getEstoque() < qtd){
                    System.out.println("ESTOQUE INSUFICIENTE!");
                    System.out.println("Estoque:"+p.getEstoque());
                    System.out.println("Quantidade pedida:"+qtd);
                    return;
                }
                carrinho.add(p);
                quantidade.add(qtd);
                System.out.println("Produto adicionado no carrinho");
                return;
            }
        
        }
        System.out.println("Produto não foi encontrado");
       
    }
    
    public void remover_no_carrinho(int id){
        
        for(int i=0; i<carrinho.size();i++){
            Produto p = carrinho.get(i);
            if(p.getId() == id){
                carrinho.remove(p);
                System.out.println("Remoção foi um succeso ");
            }
                
        }
    
    }
   
    public void visualizar_meu_carrinho(){
        
        for(int i = 0; i< carrinho.size(); i++){
           Produto p = carrinho.get(i);
            int qtd = quantidade.get(i);
            
            System.out.println("Produto: "+p.getNomeproduto());
            System.out.println("Id:"+p.getId());
            System.out.println("Preço:"+p.getPrecoproduto());
            System.out.println("Quantidade: "+qtd);
            
        }
        
    }
    
     public float finalizar_compra(){
        float preco_final =0;
        
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
      
        return preco_final;
        
    }
}
