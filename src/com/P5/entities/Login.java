package com.P5.entities;

import java.util.Scanner;

public class Login {

    String[] usernames = new String[2];
    String[] passwords = new String[2];

    usernames[0] = "Grego";
    passwords[0] = "12345";

    usernames[1] = "admin";
    passwords[1] = "12345";

    Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el username");

    String u = scanner.next();

        System.out.println("Ingrese el password");
    String p = scanner.next();

    boolean esAutenticado = false;

        for (int i = 0; i < usernames.length; i++){
        if (usernames[i].equals(u) && passwords[i].equals(p)){
            esAutenticado = true;
        }else {
            System.out.println("Username o contraseña incorrecto!");
        }


}
