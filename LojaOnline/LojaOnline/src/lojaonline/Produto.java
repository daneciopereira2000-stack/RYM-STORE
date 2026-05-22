/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

/**
 *
 * @author MM
 */
public class Produto {
    private int id, estoque;
    private String nomeproduto, categoriaproduto="ELECTRONICOS";
    private float precoproduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getCategoriaproduto() {
        return categoriaproduto;
    }

    public void setCategoriaproduto(String categoriaproduto) {
        this.categoriaproduto = categoriaproduto;
    }

    public float getPrecoproduto() {
        return precoproduto;
    }

    public void setPrecoproduto(float precoproduto) {
        this.precoproduto = precoproduto;
        
    }
    
}
