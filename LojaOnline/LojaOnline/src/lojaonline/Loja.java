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
        cliente.setid(this.clientes.size() + 1);
        this.clientes.add(cliente);
        salvarDados();
    }

    // admin 
    public void adicionarAdmin(Admin admin)
    {
        admin.setid(this.adm.size() + 1);
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

                System.out.println("");
                System.out.println(" -- Produto removido com sucesso !! -- ");
                
                return;
            }
        }
        System.out.println("\n Produto não encontrado");
    }

    public void visualizarMeuCarrinho(boolean verApenasCarrinho)
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

        if (!this.carrinho.isEmpty() && !verApenasCarrinho)
        {
            System.out.print("\n DIGITE O ID DO PRODUTO QUE PRETENDE REMOVER: ");
            int id = leia.nextInt();

            leia.nextLine();

            this.removerDoCarrinho(id);
        }
    }

    public float finalizarCompra()
    {
        float precoFinal = 0;

        if (carrinho.isEmpty())
        {
            System.out.println("\nO seu carrinho está vazio.");
            return 0;
        }

        long idFatura = System.currentTimeMillis() % 100000;
        String nomeFicheiroFatura = "./faturas/fatura_" + idFatura + ".txt";

        try (PrintWriter fileWriter = new PrintWriter(new FileWriter(nomeFicheiroFatura)))
        {
            String cabecalho = "=====================================================================\n"
                    + "                      LOJA ONLINE - FATURA RECIBO                    \n"
                    + "=====================================================================\n\n"
                    + " Fatura Nº: FT-2026-" + idFatura + "\n"
                    + " Data de Emissão: 20/06/2026\n"
                    + " Estado do Pagamento: PAGO\n\n"
                    + "---------------------------------------------------------------------\n"
                    + String.format("%-5s | %-30s | %-5s | %-15s\n", "ID", "Produto", "Qtd", "Preço Total")
                    + "---------------------------------------------------------------------";

            System.out.println("\n" + cabecalho);
            fileWriter.println(cabecalho);

            // CORPO DA FATURA (Processamento de Itens)
            for (int i = 0; i < carrinho.size(); i++)
            {
                Produto p = carrinho.get(i);
                int qtd = Math.min(quantidade.get(i), p.getEstoque()); // Prevenção básica de estouro de stock

                // Atualizar stock local
                for (Produto p2 : produtos)
                {
                    if (p.getId() == p2.getId())
                    {
                        p2.setEstoque(p2.getEstoque() - qtd);
                    }
                }

                float custoItem = p.getPrecoproduto() * qtd;
                precoFinal += custoItem;

                // Formatação da linha do item
                String linhaItem = String.format("%-5d | %-30s | %-5d | %-12.2f AKZ",
                        p.getId(),
                        p.getNomeproduto(),
                        qtd,
                        custoItem
                );

                System.out.println(linhaItem);
                fileWriter.println(linhaItem);
            }

            // RODAPÉ (Totais e Fecho)
            String rodape
                    = "---------------------------------------------------------------------\n"
                    + String.format("\n TOTAL DA COMPRA: %.2f AKZ\n", precoFinal)
                    + "\n=====================================================================\n"
                    + "        Obrigado pela preferência! Volte sempre ao nosso sistema.    \n"
                    + "=====================================================================\n";

            System.out.println(rodape);
            fileWriter.println(rodape);

            System.out.println("\n[INFO] Ficheiro físico de fatura exportado com sucesso: " + nomeFicheiroFatura + "\n");

            salvarDados();

            carrinho.clear();
            quantidade.clear();

            fileWriter.close();
            
            return precoFinal;
        }
        catch (Exception e)
        {
            System.out.println("\n[ERRO] Não foi possível gerar o arquivo físico da fatura: " + e.getMessage());
            System.out.println();
            
            return -1;
        }
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
            
            writer.close();
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
            
            writer.close();
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
            
            writer.close();
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
            
            reader.close();
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
            
            reader.close();
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
            
            reader.close();
        }
        catch (IOException e)
        {
            // Ficheiro ainda não criado
        }
    }
}
