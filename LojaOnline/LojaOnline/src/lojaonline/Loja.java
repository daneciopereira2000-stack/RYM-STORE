/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author MM
 */
public class Loja
{

    private ArrayList<Produto> carrinho;
    private ArrayList<Integer> quantidade;
    private ArrayList<Produto> produtos;
    private ArrayList<Clientes> clientes;
    private ArrayList<Admin> adm;

    public Loja()
    {
        this.adm = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.quantidade = new ArrayList<>();
        this.carrinho = new ArrayList<>();
    }

    public ArrayList<Admin> getAdm()
    {
        return this.adm;
    }

    public void setAdm(ArrayList<Admin> adm)
    {
        this.adm = adm;
    }

    public ArrayList<Produto> getProdutos()
    {
        return this.produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos)
    {
        this.produtos = produtos;
    }

    public ArrayList<Clientes> getClientes()
    {
        return this.clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes)
    {
        this.clientes = clientes;
    }

    //cliente
    public void adicionarclientes(Clientes cliente)
    {
        int id = 0;
        /*adiciona os clientes que foram setados /*
         *//* no objeto clientes la no menu prinicpal */
        for (Clientes cli : this.clientes)
        {
            id = cli.getid();
        }

        id++;
        cliente.setid(id);
        this.clientes.add(cliente);
        salvarDados();
    }

    // admin 
    public void adicionarAdmin(Admin admin)
    {
        int id = 0;

        for (Admin ad : this.adm)
        {
            id = ad.getid();
        }

        admin.setid(id);
        this.adm.add(admin);
        salvarDados();
    }

    public ArrayList<Admin> obterAdm()
    {
        /*ESSA FUNCAO NOS AJUDA A OBTER OS CLIENTES E VERIFICAR LA NO LOGIN USANDO ORETORNO*/
        return this.adm;
    }

    // funcionalidades do produto
    public void adicionarProduto(Produto produto)
    {
        int id = 0;

        for (Produto p : this.produtos)
        {
            id = p.getId();
        }

        id++;
        produto.setId(id);
        this.produtos.add(produto);
        salvarDados();
    }

    public void removerProduto(int id)
    {
        for (int i = 0; i < this.produtos.size(); i++)
        {
            Produto p = this.produtos.get(i);
            if (p.getId() == id)
            {
                this.produtos.remove(p);
                System.out.println("Produto removido com sucesso !!");
                salvarDados();
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public void visualizaProduto()
    {
        System.out.println("\n===================================== [LISTA DE PRODUTOS] =====================================\n");

        System.out.printf("%-6s %-25s %-25s %-15s %-10s%n",
                "ID",
                "Nome",
                "Categoria",
                "Preço (AKZ)",
                "Stock");

        System.out.println("------------------------------------------------------------------------------------------------");

        for (Produto p : this.produtos)
        {
            System.out.printf("%-6d %-25s %-25s %-15.2f %-10d%n",
                    p.getId(),
                    p.getNomeproduto(),
                    p.getCategoriaproduto(),
                    p.getPrecoproduto(),
                    p.getEstoque());
            System.out.println("------------------------------------------------------------------------------------------------");
        }
    }

    public int procurarProduto(int id)
    {
        for (Produto p : this.produtos)
        {
            if (p.getId() == id)
            {
                return 1;
            }
        }
        return 0;
    }

    public void actualizarProduto(int id, String name, float preco, int qtd)
    {
        for (Produto p : this.produtos)
        {
            if (p.getId() == id)
            {
                p.setNomeproduto(name);
                p.setPrecoproduto(preco);
                p.setEstoque(qtd);
                System.out.println(" Os dados do produto foram actualizados !!");
                salvarDados();
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    // funcionalidades do carrinho
    public int verficarNoCarrinho(int id)
    {
        int qtd = 0;
        for (int i = 0; i < this.carrinho.size(); i++)
        {
            Produto p = this.carrinho.get(i);
            if (p.getId() == id)
            {
                qtd = qtd + this.quantidade.get(i);
            }
        }
        return qtd;
    }

    public void adicionarAoCarrinho(int qtd, int id)
    {
        for (Produto p : this.produtos)
        {
            if (id == p.getId())
            {
                qtd = qtd + this.verficarNoCarrinho(id);
                if (p.getEstoque() < qtd)
                {
                    System.out.println("Oooops, essa quantidade ultrapassa o nosso estoque !! ");
                    System.out.println("ESTOQUE: " + p.getEstoque());
                    System.out.println("QUANTIDADE PEDIDA: " + qtd);
                    return;
                }

                // caso ja exista no carrinho
                for (int i = 0; i < this.carrinho.size(); i++)
                {
                    if (this.carrinho.get(i).getId() == id)
                    {
                        this.quantidade.set(i, qtd);
                        System.out.println("\n quantidade foi actualizada no produto do carrinho\n");
                        return;
                    }
                }

                this.carrinho.add(p);
                this.quantidade.add(qtd);
                System.out.println("\n O seu produto foi adicionado ao carrinho com sucesso !!");
                return;
            }
        }
        System.out.println("Oooops, este produto não foi encontrado");
    }

    public void removerDoCarrinho(int id)
    {
        for (int i = 0; i < this.carrinho.size(); i++)
        {
            if (this.carrinho.get(i).getId() == id)
            {
                this.carrinho.remove(i);
                this.carrinho.remove(i);

                System.out.println(" Produto removido com sucesso !! ");
                return;
            }
        }
        System.out.println("Produto não encontrado");
    }

    public void visualizarMeuCarrinho()
    {
        Scanner leia = new Scanner(System.in);
        float precoFinal = 0;

        if (this.carrinho.isEmpty())
        {
            System.out.println(" Carinho Vazio !");
        }
        else
        {
            for (int i = 0; i < this.carrinho.size(); i++)
            {
                Produto p = this.carrinho.get(i);
                int qtd = this.quantidade.get(i);

                precoFinal = precoFinal + (p.getPrecoproduto() * qtd);

                System.out.println("PRODUTO: " + p.getNomeproduto());
                System.out.println("ID:" + p.getId());
                System.out.println("PRECO:" + p.getPrecoproduto());
                System.out.println("QUANTIDADE: " + qtd);
                System.out.println("-----------------------------------------------------------------");
            }
        }

        System.out.println("\n*********************************************************************");
        System.out.println("    TOTAL A PAGAR: " + precoFinal + " AKZ");
        System.out.println("*********************************************************************");

        if (!this.carrinho.isEmpty())
        {
            System.out.print("\n DIGITE O ID DO PRODUTO QUE PRETENDE REMOVER: ");
            int id = leia.nextInt();

            leia.nextLine();

            this.removerDoCarrinho(id);
        }
    }

    public float finalizarCompra()
    {
        float preco_final = 0;

        if (this.carrinho.isEmpty())
        {
            System.out.println("\nO seu carrinho está vazio.");
            return 0;
        }

        for (int i = 0; i < this.carrinho.size(); i++)
        {
            Produto p = this.carrinho.get(i);
            int qtd = this.quantidade.get(i);

            for (Produto p2 : this.produtos)
            {
                if (p.getId() == p2.getId())
                {
                    int quant = p2.getEstoque();

                    quant = quant - qtd;

                    p2.setEstoque(quant);
                }
            }
            preco_final = preco_final + (p.getPrecoproduto() * qtd);
        }

        this.carrinho.clear();
        this.quantidade.clear();
        salvarDados();

        return preco_final;
    }

    public void esvaziarCarrinho()
    {
        this.carrinho.clear();
        this.quantidade.clear();
    }

    // Gravar todos os dados em ficheiros independentes
    public void salvarDados()
    {
        salvarProdutos();
        salvarClientes();
        salvarAdmins();
    }

    private void salvarProdutos()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter("produtos.txt")))
        {
            for (Produto p : this.produtos)
            {
                writer.println(p.getId() + ";" + p.getNomeproduto() + ";"
                        + p.getCategoriaproduto() + ";" + p.getPrecoproduto() + ";" + p.getEstoque());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro ao salvar produtos: " + e.getMessage());
        }
    }

    private void salvarClientes()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter("clientes.txt")))
        {
            for (Clientes c : this.clientes)
            {
                writer.println(c.getid() + ";" + c.getNome() + ";" + c.getEmail() + ";" + c.getSenha());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    private void salvarAdmins()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter("admins.txt")))
        {
            for (Admin a : this.adm)
            {
                writer.println(a.getid() + ";" + a.getNome() + ";" + a.getEmail() + ";" + a.getSenha());
            }
        }
        catch (IOException e)
        {
            System.out.println("Erro ao salvar administradores: " + e.getMessage());
        }
    }

    public void carregarDados()
    {
        carregarProdutos();
        carregarClientes();
        carregarAdmins();
    }

    private void carregarProdutos()
    {
        this.produtos.clear(); // Garante que a lista está limpa antes de carregar

        try (BufferedReader reader = new BufferedReader(new FileReader("produtos.txt")))
        {
            String linha;
            while ((linha = reader.readLine()) != null) //  enquanto a leitura do ficheiro nao chegar no final 
            {
                String[] dados = linha.split(";");
                if (dados.length == 5) // se o tamanho dos dados q estao na coluina
                {
                    Produto p = new Produto();
                    p.setId(Integer.parseInt(dados[0]));
                    p.setNomeproduto(dados[1]);
                    p.setCategoriaproduto(dados[2]);
                    p.setPrecoproduto(Float.parseFloat(dados[3]));
                    p.setEstoque(Integer.parseInt(dados[4]));
                    this.produtos.add(p);
                }
            }
        }
        catch (IOException e)
        {
            // Se o ficheiro não existir no primeiro arranque, avança silenciosamente
        }
    }

    private void carregarClientes()
    {
        this.clientes.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("clientes.txt")))
        {
            String linha;
            while ((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(";");
                if (dados.length == 4)
                {
                    Clientes c = new Clientes();
                    c.setid(Integer.parseInt(dados[0]));
                    c.setNome(dados[1]);
                    c.setEmail(dados[2]);
                    c.setSenha(dados[3]);
                    this.clientes.add(c);
                }
            }
        }
        catch (IOException e)
        {
            // Ficheiro ainda não criado
        }
    }

    private void carregarAdmins()
    {
        this.adm.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader("admins.txt")))
        {
            String linha;
            while ((linha = reader.readLine()) != null)
            {
                String[] dados = linha.split(";");
                if (dados.length == 4)
                {
                    Admin a = new Admin();
                    a.setid(Integer.parseInt(dados[0]));
                    a.setNome(dados[1]);
                    a.setEmail(dados[2]);
                    a.setSenha(dados[3]);
                    this.adm.add(a);
                }
            }
        }
        catch (IOException e)
        {
            // Ficheiro ainda não criado
        }
    }
}
