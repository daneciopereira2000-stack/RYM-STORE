/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lojaonline;

/**
 *
 * @author MM
 */
public class Usuario {
    

    
    private String nome, email, senha;
    private int id;
    private boolean  status;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    public void setstatus(boolean status){
    this.status = status;
    }
    
    public boolean getstatus(){
        return this.status;
    }
    
    public void setid(int id){
        this.id = id;
    }
    
    public int getid(){
        return this.id;
    }
}
