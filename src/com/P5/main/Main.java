package com.P5.main;

import com.P5.DAO.DelegacionImpl;
import com.P5.entities.Delegacion;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            Scanner keyboard = new Scanner(System.in);
            imprimirMenu();

            System.out.print("\nOpción: ");
            option = keyboard.nextInt();
            System.out.println();

            switch (option) {
                case 0:
                    System.out.println("\nSaliendo...\n");
                    break;
                case 1:
                    listarDelegaciones();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

    private static void imprimirMenu() {
        System.out.println("************* MENU *************");
        System.out.println("[1] Listar delegaciones.");
        System.out.println("[0] Salir.");
    }

    public static void listarDelegaciones() {
        DelegacionImpl delegacionDao = new DelegacionImpl();
        List<Delegacion> delegaciones = delegacionDao.findAllDelegacion();
        System.out.println("---- LISTA DE DELEGACIONES ----");
        for (Delegacion delegacion : delegaciones) {
            System.out.println(delegacion.toString());
        }
    }
}
