/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

/**
 *
 * @author MM
 */
public class Produto
{
    private int id;
    private int estoque;
    private String nomeproduto;
    private String categoriaproduto;
    private float precoproduto;
    
    public Produto()
    {
        this.categoriaproduto = "ELECTRONICOS";
    }

    public int getId()
    {
        return this.id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getEstoque()
    {
        return this.estoque;
    }

    public void setEstoque(int estoque)
    {
        this.estoque = estoque;
    }

    public String getNomeproduto()
    {
        return this.nomeproduto;
    }

    public void setNomeproduto(String nomeproduto)
    {
        this.nomeproduto = nomeproduto;
    }

    public String getCategoriaproduto()
    {
        return this.categoriaproduto;
    }

    public void setCategoriaproduto(String categoriaproduto)
    {
        this.categoriaproduto = categoriaproduto;
    }

    public float getPrecoproduto()
    {
        return this.precoproduto;
    }

    public void setPrecoproduto(float precoproduto)
    {
        this.precoproduto = precoproduto;
    }
}
