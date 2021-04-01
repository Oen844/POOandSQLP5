package com.P5.main;

import com.P5.DAO.DelegacionImpl;
import com.P5.entities.Delegacion;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
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
                case 2:
                    crearDelegacion();
                    break;
                case 3:
                    leerDelegacion();
                    break;
                default:
                    break;
            }
        } while (option != 0);
    }

    private static void imprimirMenu() {
        System.out.println("\n************* MENU *************");
        System.out.println("[1] Listar delegaciones.");
        System.out.println("[2] Anhadir delegacion.");
        System.out.println("[3] Leer delegacion.");
        System.out.println("[0] Salir.");
    }

    public static void listarDelegaciones() {
        try {
            DelegacionImpl delegacionDao = new DelegacionImpl();
            List<Delegacion> delegaciones = delegacionDao.findAllDelegacion();
            System.out.println("---- LISTA DE DELEGACIONES ----");
            for (Delegacion delegacion : delegaciones) {
                System.out.println(delegacion.toString());
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
    }

    public static void crearDelegacion() {
        try {
            Scanner keyboard = new Scanner(System.in);
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- CREAR DELEGACIÓN ----");

            System.out.print("ID: ");
            String idStr = keyboard.nextLine();
            System.out.print("Ciudad: ");
            String ciudad = keyboard.nextLine();
            System.out.print("Dirección: ");
            String direccion = keyboard.nextLine();
            System.out.print("Teléfono: ");
            String telefono = keyboard.nextLine();
            System.out.print("Email: ");
            String email = keyboard.nextLine();
            System.out.print("Central[Si/No]: ");
            String centralStr = keyboard.nextLine();

            Integer id = Integer.parseInt(idStr);
            boolean central = false;
            if (centralStr.equals("Si")) {
                central = true;
            }

            Delegacion delegacion = new Delegacion(id, ciudad, direccion, telefono, email, central);
            delegacionDao.createDelegacion(delegacion);

            System.out.println("Delegación creada con éxito.\n");
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void leerDelegacion() {
        try {
            Scanner keyboard = new Scanner(System.in);
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- LEER DELEGACIÓN ----");

            System.out.print("ID: ");
            String idStr = keyboard.nextLine();
            Delegacion delegacion = delegacionDao.readDelegacion(idStr);
            System.out.println(delegacion);
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
