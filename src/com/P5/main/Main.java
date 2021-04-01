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
                case 4:
                    actualizarDelegacion();
                    break;
                case 5:
                    eliminarDelegacion();
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
        System.out.println("[4] Actualizar delegacion.");
        System.out.println("[5] Eliminar delegacion.");
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
            System.out.println("Items: " + delegaciones.size());
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
            if (delegacion != null) {
                System.out.println(delegacion);
            } else {
                System.out.println("El ID de la delegación no existe.");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void actualizarDelegacion() {
        try {
            Scanner keyboard = new Scanner(System.in);
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- ACTUALIZAR DELEGACIÓN ----");

            System.out.print("ID: ");
            String idStr = keyboard.nextLine();
            Delegacion delegacion = delegacionDao.readDelegacion(idStr);
            if (delegacion == null) {
                System.out.println("El ID de la delegación no existe.");
            } else {
                System.out.format("Ciudad [%s]: ", delegacion.getCiudad());
                String ciudad = keyboard.nextLine();
                System.out.format("Dirección [%s]: ", delegacion.getDireccion());
                String direccion = keyboard.nextLine();
                System.out.format("Teléfono [%s]: ", delegacion.getTelefono());
                String telefono = keyboard.nextLine();
                System.out.format("Email [%s]: ", delegacion.getEmail());
                String email = keyboard.nextLine();
                System.out.format("Central [%s]: ", delegacion.getCentral());
                String centralStr = keyboard.nextLine();

                boolean central = false;
                if (centralStr.equals("Si")) {
                    central = true;
                }

                if (ciudad.length() > 0) {
                    delegacion.setCiudad(ciudad);
                }
                if (direccion.length() > 0) {
                    delegacion.setDireccion(direccion);
                }
                if (telefono.length() > 0) {
                    delegacion.setTelefono(telefono);
                }
                if (email.length() > 0) {
                    delegacion.setEmail(email);
                }
                if (centralStr.length() > 0) {
                    delegacion.setCentral(central);
                }

                delegacionDao.updateDelegacion(delegacion);
                System.out.println("Delegación actualizada con éxito.\n");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void eliminarDelegacion() {
        try {
            Scanner keyboard = new Scanner(System.in);
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- ELIMINAR DELEGACIÓN ----");

            System.out.print("ID: ");
            String idStr = keyboard.nextLine();
            Delegacion delegacion = delegacionDao.readDelegacion(idStr);
            if (delegacion == null) {
                System.out.println("El ID de la delegación no existe.");
            } else {
                delegacionDao.deleteDelegacion(delegacion.getId().toString());
                System.out.println("Delegación eliminada con éxito.\n");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
