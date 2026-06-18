/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.List;
import java.util.Scanner;
import lojaonline.Usuario;
/**
 *
 * @author manasses
 */
public class Auth 
{
    public static Usuario login(List<Usuario> usuarios)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Entre com o seu E-mail: ");
        String email = sc.nextLine();

        System.out.print("Entre com a senha: ");
        String senha = sc.nextLine();

        Usuario usuario = usuarioExiste(email, usuarios);

        if (usuario != null && usuario.getSenha().equals(senha)) 
        {
            System.out.println("\nLogin efetuado com sucesso!");
            
            System.out.println("\nPresione Enter para comtinuar...");
            sc.nextLine();
            return usuario;
        }

        System.out.println("E-mail ou senha incorretos.");
        
        return null;
    }

    public static Usuario usuarioExiste(String email, List<Usuario> usuarios) 
    {
        for (Usuario u : usuarios) 
        {
            if (u.getEmail().equalsIgnoreCase(email))
            {
                return u;
            }
        }
        return null;
    }
}
