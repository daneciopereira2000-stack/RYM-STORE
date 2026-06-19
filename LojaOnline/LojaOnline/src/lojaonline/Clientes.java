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
            System.out.println("\n*************** [MENU CLIENTE] ******************");
            System.out.println("\nOla " + cliente.getNome() + ", o que deseja?\n");
            System.out.println("***********************************************\n");

            System.out.println(" [ 1 ]- Ver Produtos ");
            System.out.println(" [ 2 ]- Adicionar ao meu Carrinho ");
            System.out.println(" [ 3 ]- Remover do meu carrinho");
            System.out.println(" [ 4 ]- Ver o meu carrinho ");
            System.out.println(" [ 5 ]- Fazer Checkout ");
            System.out.println(" [ 0 ]- Logout  ");
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
                    loja.visualizarMeuCarrinho();
                    System.out.print(" DIGITE O ID DO PRODUTO QUE PRETENDE REMOVER: ");
                    int id = leia.nextInt();

                    loja.removerDoCarrinho(id);
                    
                    leia.nextLine();
                }
                case 4 ->
                {
                    System.out.println("\n*************** [VER MEU CARRINHO] ******************\n");
                    loja.visualizarMeuCarrinho();
                }
                case 5 ->
                {
                    System.out.println("\n************** [CHECKOUT] ******************\n");
                    float preco_final = loja.finalizarCompra();
                    if (preco_final > 0)
                    {

                        System.out.println("*********************************************************************");
                        System.out.println("    TOTAL A PAGAR: " + preco_final + " AKZ");
                        System.out.println("*********************************************************************\n");
                        System.out.println(" SUCESSO, AGRADECEMOS A SUA PREFERENCIA, VOLTE SEMPRE ! ");
                    }
                }
            }

            System.out.println("\n** Precione Enter para Continuar **");
            leia.nextLine();

        }
        while (opcao != 0);

        loja.esvaziarCarrinho();
    }
}
