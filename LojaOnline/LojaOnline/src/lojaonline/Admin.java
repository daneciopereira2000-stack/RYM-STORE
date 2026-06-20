/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

import java.util.Scanner;

/**
 * AS CLASSES ADMIN E CLIENTES VAO HERDAR DO USUARIO
 */
public class Admin extends Usuario
{

    public void menuadmin(Usuario usuario, Loja loja, Admin admin, Clientes clientes, Produto produto)
    {
        /* Passagem de objeto por parâmetro */
        Scanner leia = new Scanner(System.in);
        int opcao = 0;

        do
        {
            System.out.println("\n==================================================================");
            System.out.println("                            [MENU ADMIN]                          ");
            System.out.println("==================================================================\n");
            System.out.println(" Olá Sr/a Admin " + usuario.getEmail() + ", o que deseja gerir?\n");
            System.out.println("------------------------------------------------------------------");
            System.out.println(" [ 1 ] - Novo Produto ");
            System.out.println(" [ 2 ] - Novos Usuários");
            System.out.println(" [ 3 ] - Ver Produtos");
            System.out.println(" [ 4 ] - Ver Usuários");
            System.out.println(" [ 5 ] - Actualizar Produtos");
            System.out.println(" [ 6 ] - Remover Produtos ");
            System.out.println(" [ 7 ] - Remover Usuários ");
            System.out.println(" [ 0 ] - Logout");
            System.out.print("------------------------------------------------------------------\n");
            System.out.print("                                      Sua resposta: ");

            if (!leia.hasNextInt())
            {
                System.out.println("\n[ERRO] Por favor, introduza um número válido!");
                leia.next();
                continue;
            }
            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao)
            {
                case 1 ->
                {
                    produto = new Produto();
                    System.out.println("\n*************** [NOVO PRODUTO] **************************\n");

                    System.out.print("Digite o nome do produto: ");
                    String nome = leia.nextLine();

                    String categoria = "ELECTRONICOS";

                    System.out.print("Digite a quantidade em estoque: ");
                    int estoque = leia.nextInt();

                    System.out.print("Digite o preço: ");
                    float preco = leia.nextFloat();
                    leia.nextLine();

                    produto.setNomeproduto(nome);
                    produto.setCategoriaproduto(categoria);
                    produto.setPrecoproduto(preco);
                    produto.setEstoque(estoque);

                    // Gerar um ID automático incremental com base no tamanho da lista
                    int novoId = loja.getProdutos().size() + 1;
                    produto.setId(novoId);

                    loja.adicionarProduto(produto);
                    System.out.println("\n Sucesso, o seu produto foi adicionado com sucesso ao estoque!");
                }
                case 2 ->
                {
                    System.out.println("\n********************** [NOVO USUARIO] **************************\n");
                    System.out.println(" [ 1 ] - Novo ADMIN ");
                    System.out.println(" [ 2 ] - Novo CLIENTE ");
                    System.out.print(" Sua resposta: ");

                    int op = leia.nextInt();
                    leia.nextLine();
                    boolean existe;

                    if (op == 1)
                    {
                        existe = false;
                        admin = new Admin();

                        System.out.println("\n********************* [NOVO ADMIN] ***************************\n");
                        System.out.print("DIGITE O SEU NOME: ");
                        String nome = leia.nextLine();

                        System.out.print("DIGITE O SEU MELHOR EMAIL: ");
                        String email = leia.nextLine();

                        System.out.print("DIGITE A SUA SENHA: ");
                        String senha = leia.nextLine();

                        for (Clientes c : loja.getClientes())
                        {
                            if (c.getEmail().equals(email))
                            {
                                System.out.println("\n** ERRO Email ja existe! **");
                                existe = true;
                                break;
                            }
                        }

                        for (Admin a : loja.getAdm())
                        {
                            if (a.getEmail().equals(email))
                            {
                                System.out.println("\n** ERRO Email ja existe! **\n");
                                existe = true;
                                break;
                            }
                        }

                        if (!existe)
                        {
                            System.out.println("\nNovo ADMIN " + nome + ", foi cadastrado com sucesso!");
                            admin.setNome(nome);
                            admin.setEmail(email);
                            admin.setSenha(senha);
                            admin.setid(loja.getAdm().size() + 1);

                            loja.adicionarAdmin(admin);
                        }
                    }
                    else if (op == 2)
                    {
                        existe = false;
                        clientes = new Clientes();

                        System.out.println("\n********************* [NOVO CLIENTE] **************************\n");
                        System.out.print("DIGITE O SEU NOME: ");
                        String nome = leia.nextLine();

                        System.out.print("DIGITE O SEU MELHOR EMAIL: ");
                        String email = leia.nextLine();

                        System.out.print("DIGITE A SUA SENHA: ");
                        String senha = leia.nextLine();

                        for (Clientes c : loja.getClientes())
                        {
                            if (c.getEmail().equals(email))
                            {
                                System.out.println("\n** ERRO Email ja existe! **");
                                existe = true;
                                break;
                            }
                        }

                        for (Admin a : loja.getAdm())
                        {
                            if (a.getEmail().equals(email))
                            {
                                System.out.println("\n** ERRO Email ja existe! **");
                                existe = true;
                                break;
                            }
                        }

                        if (!existe)
                        {
                            System.out.println("\nParabéns e seja Bem Vindo " + nome + "!");
                            clientes.setNome(nome);
                            clientes.setEmail(email);
                            clientes.setSenha(senha);
                            clientes.setid(loja.getClientes().size() + 1);

                            loja.adicionarclientes(clientes);
                        }
                    }
                }
                case 3 ->
                {
                    System.out.println("\n****************** [VER PRODUTOS] ******************\n");
                    loja.visualizaProduto();
                }
                case 4 ->
                {
                    System.out.println("\n=======================================================================================");
                    System.out.println("                                  RELATÓRIO DE UTILIZADORES                            ");
                    System.out.println("=======================================================================================");

                    System.out.println("\n>>> [ADMINISTRADORES ACTIVOS]");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.printf("| %-5s | %-25s | %-30s | %-15s |\n", "ID", "NOME", "EMAIL", "SENHA");
                    System.out.println("---------------------------------------------------------------------------------------");

                    if (loja.getAdm().isEmpty())
                    {
                        System.out.printf("| %-83s |\n", "Nenhum administrador registado no sistema.");
                    }
                    else
                    {
                        for (Admin adm : loja.getAdm())
                        {
                            System.out.printf("| %-5d | %-25s | %-30s | %-15s |\n",
                                    adm.getid(), adm.getNome(), adm.getEmail(), adm.getSenha());
                        }
                    }
                    System.out.println("---------------------------------------------------------------------------------------");

                    System.out.println("\n>>> [CLIENTES ACTIVOS]");
                    System.out.println("---------------------------------------------------------------------------------------");
                    System.out.printf("| %-5s | %-25s | %-30s | %-15s |\n", "ID", "NOME", "EMAIL", "SENHA");
                    System.out.println("---------------------------------------------------------------------------------------");

                    if (loja.getClientes().isEmpty())
                    {
                        System.out.printf("| %-83s |\n", "Nenhum cliente registado no sistema.");
                    }
                    else
                    {
                        for (Clientes clt : loja.getClientes())
                        {
                            System.out.printf("| %-5d | %-25s | %-30s | %-15s |\n",
                                    clt.getid(), clt.getNome(), clt.getEmail(), clt.getSenha());
                        }
                    }
                    System.out.println("---------------------------------------------------------------------------------------");
                }
                case 5 ->
                {
                    System.out.println("\n*************** [ACTUALIZAR PRODUTO] **************************");
                    loja.visualizaProduto();

                    System.out.print("\nDigite o ID do produto que deseja actualizar: ");
                    int idBusca = leia.nextInt();
                    leia.nextLine();

                    Produto prodEncontrado = null;
                    for (Produto p : loja.getProdutos())
                    {
                        if (p.getId() == idBusca)
                        {
                            prodEncontrado = p;
                            break;
                        }
                    }

                    if (prodEncontrado != null)
                    {
                        System.out.println("\nProduto Encontrado: " + prodEncontrado.getNomeproduto());

                        System.out.print("Novo nome (ou Enter para manter '" + prodEncontrado.getNomeproduto() + "'): ");
                        String novoNome = leia.nextLine();

                        if (!novoNome.trim().isEmpty())
                        {
                            prodEncontrado.setNomeproduto(novoNome);
                        }

                        System.out.print("Nova quantidade em estoque (actual: " + prodEncontrado.getEstoque() + " | ou Enter para manter): ");
                        String entradaEstoque = leia.nextLine(); // Lemos como texto para aceitar o "Enter" vazio

                        if (!entradaEstoque.trim().isEmpty())
                        {
                            try
                            {
                                int novoEstoque = Integer.parseInt(entradaEstoque);
                                if (novoEstoque >= 0)
                                {
                                    prodEncontrado.setEstoque(novoEstoque);
                                }
                                else
                                {
                                    System.out.println("[AVISO] Quantidade inválida! O estoque não foi alterado.");
                                }
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("[AVISO] Entrada incorreta! Digite apenas números. O estoque não foi alterado.");
                            }
                        }

                        System.out.print("Novo preço (actual: " + prodEncontrado.getPrecoproduto() + " AKZ | ou Enter para manter): ");
                        String entradaPreco = leia.nextLine(); // Lemos como texto para evitar quebras de buffer

                        if (!entradaPreco.trim().isEmpty())
                        {
                            try
                            {
                                // Substitui vírgulas por pontos caso o utilizador digite no formato "1500,50"
                                float novoPreco = Float.parseFloat(entradaPreco.replace(",", "."));

                                if (novoPreco >= 0)
                                {
                                    prodEncontrado.setPrecoproduto(novoPreco);
                                }
                                else
                                {
                                    System.out.println("[AVISO] Preço inválido! O preço não foi alterado.");
                                }
                            }
                            catch (NumberFormatException e)
                            {
                                System.out.println("[AVISO] Entrada incorreta! Digite um valor decimal válido. O preço não foi alterado.");
                            }
                        }
                        
                        loja.salvarDados();

                        loja.salvarDados();
                        
                        System.out.println("\n [SUCESSO] Processo de atualização concluído!");
                    }
                    else
                    {
                        System.out.println("\n [ERRO] Produto com o ID introduzido não foi encontrado!");
                    }
                }
                case 6 ->
                {
                    System.out.println("\n*************** [REMOVER PRODUTO] **************************");
                    loja.visualizaProduto();

                    System.out.print("\nDigite o ID do produto que pretende apagar definitivamente: ");
                    int idRemover = leia.nextInt();
                    leia.nextLine();

                    Produto prodRemover = null;
                    for (Produto p : loja.getProdutos())
                    {
                        if (p.getId() == idRemover)
                        {
                            prodRemover = p;
                            break;
                        }
                    }

                    if (prodRemover != null)
                    {
                        loja.getProdutos().remove(prodRemover);
                        loja.salvarDados();
                        System.out.println("\n [SUCESSO] O produto '" + prodRemover.getNomeproduto() + "' foi removido do estoque.");
                    }
                    else
                    {
                        System.out.println("\n [ERRO] Nenhum produto com o ID " + idRemover + " encontrado.");
                    }
                }
                case 7 ->
                {
                    System.out.println("\n=======================================================================================");
                    System.out.println("                                  REMOVER UTILIZADORES                                 ");
                    System.out.println("=======================================================================================");

                    System.out.println("\n>>>>> [ADMINISTRADORES ACTIVOS]");
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.printf("| %-5s | %-25s | %-45s |\n", "ID", "NOME", "EMAIL");
                    System.out.println("-------------------------------------------------------------------------------------");

                    if (loja.getAdm().isEmpty())
                    {
                        System.out.printf("| %-81s |\n", "Nenhum administrador registado no sistema.");
                    }
                    else
                    {
                        for (Admin adm : loja.getAdm())
                        {
                            System.out.printf("| %-5d | %-25s | %-45s |\n",
                                    adm.getid(),
                                    adm.getNome(),
                                    adm.getEmail()
                            );
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------------------");

                    System.out.println("\n>>>>> [CLIENTES ACTIVOS]");
                    System.out.println("-------------------------------------------------------------------------------------");
                    System.out.printf("| %-5s | %-25s | %-45s |\n", "ID", "NOME", "EMAIL");
                    System.out.println("-------------------------------------------------------------------------------------");

                    if (loja.getClientes().isEmpty())
                    {
                        System.out.printf("| %-81s |\n", "Nenhum cliente registado no sistema.");
                    }
                    else
                    {
                        for (Clientes cliente : loja.getClientes())
                        {
                            System.out.printf("| %-5d | %-25s | %-45s |\n",
                                    cliente.getid(),
                                    cliente.getNome(),
                                    cliente.getEmail()
                            );
                        }
                    }
                    System.out.println("-------------------------------------------------------------------------------------");

                    System.out.println("\n┌─────────────────────────────────────────────────────────────────────────────────────┐");
                    System.out.println("│  Digite o EMAIL exato do utilizador que pretende remover do sistema.                │");
                    System.out.println("└─────────────────────────────────────────────────────────────────────────────────────┘");
                    System.out.print("  EMAIL: ");
                    String rem = leia.nextLine();

                    Clientes removerclientes = null;
                    Admin removeradmin = null;

                    for (Clientes clt : loja.getClientes())
                    {
                        if (clt.getEmail().equalsIgnoreCase(rem))
                        {
                            removerclientes = clt;
                            break;
                        }
                    }

                    for (Admin admremover : loja.getAdm())
                    {
                        if (admremover.getEmail().equalsIgnoreCase(rem))
                        {
                            removeradmin = admremover;
                            break;
                        }
                    }

                    System.out.println();
                    
                    if (removerclientes != null || removeradmin != null)
                    {
                        if (removerclientes != null)
                        {
                            loja.getClientes().remove(removerclientes);
                        }
                        if (removeradmin != null)
                        {
                            loja.getAdm().remove(removeradmin);
                        }
                        
                        loja.salvarDados();
                        
                        System.out.println(" [SUCESSO] Utilizador removido com sucesso de forma definitiva!");
                    }
                    else
                    {
                        System.out.println(" [ERRO] Oooopss, utilizador não encontrado! Verifique a ortografia e tente novamente.");
                    }
                }
                case 0 ->
                {
                    System.out.println("\n Logout com sucesso....");
                }
            }
            
            System.out.println("\n Pressione Enter para continuar...");
            leia.nextLine();
        }
        while (opcao != 0);
        }
    }
