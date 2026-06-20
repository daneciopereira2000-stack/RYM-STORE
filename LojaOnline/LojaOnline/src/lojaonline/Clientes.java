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
public class Clientes extends Usuario
{
    public void menucliente(Clientes cliente, Loja loja)
    {
        Scanner leia = new Scanner(System.in);
        int opcao;

        do
        {
            System.out.println("\n==================================================================");
            System.out.println("                            [MENU CLIENTE]                          ");
            System.out.println("==================================================================\n");
            System.out.println("Ola " + cliente.getNome() + ", o que deseja?\n");
            System.out.println("------------------------------------------------------------------");

            System.out.println(" [ 1 ] - Ver Produtos ");
            System.out.println(" [ 2 ] - Adicionar ao meu Carrinho ");
            System.out.println(" [ 3 ] - Remover do meu carrinho");
            System.out.println(" [ 4 ] - Ver o meu carrinho ");
            System.out.println(" [ 5 ] - Fazer Checkout ");
            System.out.println(" [ 0 ] - Logout  ");
            System.out.print("------------------------------------------------------------------\n");
            System.out.print("                                      Sua resposta: ");

            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao)
            {
                case 1 ->
                {
                    System.out.println("\n*************** [VER PRODUTOS] ******************");
                    loja.visualizaProduto();
                }
                case 2 ->
                {
                    System.out.println("\n*************** [ADICIONAR AO MEU CARRINHO] ******************");

                    loja.visualizaProduto();

                    System.out.println();
                    System.out.print("Digite o ID do produto: ");
                    int id = leia.nextInt();

                    System.out.print("Digite a quantidade: ");
                    int qtd = leia.nextInt();

                    loja.adicionarAoCarrinho(qtd, id);

                    leia.nextLine();
                }
                case 3 ->
                {
                    System.out.println("\n*************** [REMOVER DO MEU CARRINHO] ******************\n");
                    loja.visualizarMeuCarrinho(false);
                }
                case 4 ->
                {
                    System.out.println("\n*************** [VER MEU CARRINHO] ******************\n");
                    loja.visualizarMeuCarrinho(true);
                }
                case 5 ->
                {
                    System.out.println("\n************** [CHECKOUT] ******************\n");
                    
                    float preceFinal = loja.finalizarCompra();
                    
                    if (preceFinal > 0)
                    {
                        System.out.println("*********************************************************************");
                        System.out.println("    TOTAL A PAGAR: " + preceFinal + " AKZ");
                        System.out.println("*********************************************************************\n");
                        System.out.println(" SUCESSO, AGRADECEMOS A SUA PREFERENCIA, VOLTE SEMPRE ! ");
                    }
                }
                case 0 ->
                {
                    System.out.println("\n Logout com sucesso....");
                }
            }

            System.out.println("\n** Precione Enter para Continuar **");
            leia.nextLine();
        }
        while (opcao != 0);

        loja.esvaziarCarrinho();
    }
}
