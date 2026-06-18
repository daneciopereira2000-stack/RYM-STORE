/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

/**
 *
 * @author manasses
 */
public class ItemCarrinho
{
    private Produto produto;
    private int quantidade = 0;
    
    public ItemCarrinho(Produto produto)
    {
        this.produto = produto;
        this.quantidade++;
    }
    
    public Produto getItem()
    {
        return this.produto;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public void incrementarQuantidade()
    {
        this.quantidade++;
    }
    
    public void decrementarQuantidade()
    {
        this.quantidade--;
    }
    
    @Override
    public String toString()
    {
        return this.produto.getNomeproduto()+ " " + this.quantidade;
    }
}
