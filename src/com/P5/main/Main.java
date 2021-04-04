package com.P5.main;

import com.P5.DAO.DelegacionImpl;
import com.P5.DAO.PersonalImpl;
import com.P5.DAO.ProyectoImpl;
import com.P5.entities.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        do {
            Scanner keyboard = new Scanner(System.in);
            imprimirMenu();

            System.out.print("\nOpción: ");
            option = Integer.parseInt(keyboard.nextLine());
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
                case 6:
                    listarProyectos();
                    break;
                case 7:
                    crearProyecto();
                    break;
                case 8:
                    leerProyecto();
                    break;
                case 9:
                    actualizarProyecto();
                    break;
                case 10:
                    eliminarProyecto();
                    break;
                case 11:
                    listarPersonal();
                    break;
                case 12:
                    altaPersonal();
                    break;
                case 13:
                    leerPersonal();
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
        System.out.println("[6] Listar proyectos de una delegacion.");
        System.out.println("[7] Anhadir proyecto.");
        System.out.println("[8] Leer proyecto.");
        System.out.println("[9] Actualizar proyecto.");
        System.out.println("[10] Eliminar proyecto.");
        System.out.println("[11] Listar personal.");
        System.out.println("[12] Alta personal.");
        System.out.println("[13] Leer personal.");
        System.out.println("[0] Salir.");
    }

    private static void listarDelegaciones() {
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

    private static void crearDelegacion() {
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

    private static void listarProyectos() {
        try {
            Scanner keyboard = new Scanner(System.in);
            ProyectoImpl proyectoDao = new ProyectoImpl();

            System.out.print("ID Delegacion: ");
            String idStr = keyboard.nextLine();

            System.out.println("---- LISTA DE PROYECTOS DE LA DELEGACION ----");
            List<Proyecto> proyectos = proyectoDao.findProyectosDelegacion(idStr);

            if (proyectos.size() > 0) {
                for (Proyecto proyecto : proyectos) {
                    System.out.println(proyecto.toString());
                }
                System.out.println("Items: " + proyectos.size());
            } else {
                System.out.println("La delegacion especificada no tiene proyectos.");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
    }

    private static void crearProyecto() {
        try {
            Scanner keyboard = new Scanner(System.in);
            ProyectoImpl proyectoDao = new ProyectoImpl();
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- CREAR PROYECTO ----");

            System.out.print("Nombre: ");
            String nombre = keyboard.nextLine();
            System.out.print("Pais: ");
            String pais = keyboard.nextLine();
            System.out.print("Localizacion: ");
            String localizacion = keyboard.nextLine();
            System.out.print("Linea de accion: ");
            String lineaAccion = keyboard.nextLine();
            System.out.print("Sublinea de accion: ");
            String subLineaAccion = keyboard.nextLine();
            System.out.print("Fecha de inicio [DD/MM/YYY]: ");
            String fechaInicio = keyboard.nextLine();
            System.out.print("Fecha de finalizacion [DD/MM/YYY]: ");
            String fechaFin = keyboard.nextLine();
            System.out.print("Socio local: ");
            String socioLocal = keyboard.nextLine();
            System.out.print("Financiador: ");
            String financiador = keyboard.nextLine();
            System.out.print("Financiacion Aportada: ");
            String financiacionAportada = keyboard.nextLine();

            ArrayList<Personal> personalAsociado = new ArrayList<>();
            String idPersonalStr = "";
            do {
                System.out.print("ID Personal Asociado: ");
                idPersonalStr = keyboard.nextLine();
                if (!idPersonalStr.equals("0")) {
                    personalAsociado.add(new Personal(Integer.parseInt(idPersonalStr), "", "", "", null));
                }
            } while (!idPersonalStr.equals("0"));

            System.out.print("ID de la delegacion asociada: ");
            String delegacionId = keyboard.nextLine();

            Delegacion delegacion = delegacionDao.readDelegacion(delegacionId);
            Date fechaInicioDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaInicio);
            Date fechaFinDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaFin);
            Proyecto proyecto = new Proyecto(nombre, pais, localizacion, lineaAccion, subLineaAccion, fechaInicioDate, fechaFinDate, socioLocal, financiador, financiacionAportada, personalAsociado, delegacion);
            proyectoDao.createProyecto(proyecto);

            System.out.println("Delegación creada con éxito.\n");
        } catch (SAXException | ParserConfigurationException | IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void leerProyecto() {
        try {
            Scanner keyboard = new Scanner(System.in);
            ProyectoImpl proyectoDao = new ProyectoImpl();
            System.out.println("---- LEER PROYECTO ----");

            System.out.print("Nombre: ");
            String nombre = keyboard.nextLine();
            Proyecto proyecto = proyectoDao.readProyecto(nombre);
            if (proyecto != null) {
                System.out.println(proyecto);
            } else {
                System.out.println("El nombre del proyecto no existe.");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void actualizarProyecto() {
        try {
            Scanner keyboard = new Scanner(System.in);
            ProyectoImpl proyectoDao = new ProyectoImpl();
            System.out.println("---- ACTUALIZAR PROYECTO ----");

            System.out.print("Nombre del Proyecto: ");
            String nombreProyecto = keyboard.nextLine();
            Proyecto proyecto = proyectoDao.readProyecto(nombreProyecto);
            if (proyecto == null) {
                System.out.println("El proyecto no existe.");
            } else {
                System.out.format("Pais [%s]: ", proyecto.getPais());
                String pais = keyboard.nextLine();
                System.out.format("Localizacion [%s]: ", proyecto.getLocalizacion());
                String localizacion = keyboard.nextLine();
                System.out.format("Linea de accion [%s]: ", proyecto.getLineaAccion());
                String lineaAccion = keyboard.nextLine();
                System.out.format("Sublinea de accion [%s]: ", proyecto.getSubLineaAccion());
                String subLineaAccion = keyboard.nextLine();
                System.out.format("Fecha de inicio [DD/MM/YYY] [%s]: ", proyecto.getFechaInicio());
                String fechaInicio = keyboard.nextLine();
                System.out.format("Fecha de finalizacion [DD/MM/YYY] [%s]: ", proyecto.getFechaFin());
                String fechaFin = keyboard.nextLine();
                System.out.format("Socio local [%s]: ", proyecto.getSocioLocal());
                String socioLocal = keyboard.nextLine();
                System.out.format("Financiador [%s]: ", proyecto.getFinanciador());
                String financiador = keyboard.nextLine();
                System.out.format("Financiacion Aportada [%s]: ", proyecto.getFinanciacionAportada());
                String financiacionAportada = keyboard.nextLine();


                if (pais.length() > 0) {
                    proyecto.setPais(pais);
                }
                if (localizacion.length() > 0) {
                    proyecto.setLocalizacion(localizacion);
                }
                if (lineaAccion.length() > 0) {
                    proyecto.setLineaAccion(lineaAccion);
                }
                if (subLineaAccion.length() > 0) {
                    proyecto.setSubLineaAccion(subLineaAccion);
                }
                if (fechaInicio.length() > 0) {
                    Date fechaInicioDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaInicio);
                    proyecto.setFechaInicio(fechaInicioDate);
                }
                if (fechaInicio.length() > 0) {
                    Date fechaFinDate = new SimpleDateFormat("DD/MM/YYYY").parse(fechaFin);
                    proyecto.setFechaInicio(fechaFinDate);
                }
                if (socioLocal.length() > 0) {
                    proyecto.setSocioLocal(socioLocal);
                }
                if (financiador.length() > 0) {
                    proyecto.setFinanciador(financiador);
                }
                if (financiacionAportada.length() > 0) {
                    proyecto.setFinanciacionAportada(financiacionAportada);
                }

                proyectoDao.updateProyecto(proyecto);
                System.out.println("Proyecto actualizado con éxito.\n");
            }
        } catch (SAXException | ParserConfigurationException | IOException | ParseException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void eliminarProyecto() {
        try {
            Scanner keyboard = new Scanner(System.in);
            ProyectoImpl proyectoDao = new ProyectoImpl();
            System.out.println("---- ELIMINAR PROYECTO ----");

            System.out.print("Nombre del proyecto: ");
            String nombreProyecto = keyboard.nextLine();
            Proyecto proyecto = proyectoDao.readProyecto(nombreProyecto);
            if (proyecto == null) {
                System.out.println("El proyecto no existe.");
            } else {
                proyectoDao.deleteProyecto(nombreProyecto);
                System.out.println("Delegación eliminada con éxito.\n");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listarPersonal() {
        try {
            Scanner keyboard = new Scanner(System.in);
            PersonalImpl personalDao = new PersonalImpl();

            System.out.print("ID Delegacion: ");
            String idStr = keyboard.nextLine();

            System.out.println("---- LISTA DE PERSONAL DE LA DELEGACION ----");
            List<Personal> personal = personalDao.findPersonalDelegacion(idStr);

            if (personal.size() > 0) {
                for (Personal persona : personal) {
                    System.out.println(persona.toString());
                }
                System.out.println("Items: " + personal.size());
            } else {
                System.out.println("La delegacion especificada no tiene proyectos.");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("\n");
    }

    private static void altaPersonal() {
        try {
            Scanner keyboard = new Scanner(System.in);
            PersonalImpl personalDao = new PersonalImpl();
            DelegacionImpl delegacionDao = new DelegacionImpl();
            System.out.println("---- ALTA PERSONAL ----");

            System.out.print("ID Personal: ");
            String idStr = keyboard.nextLine();
            System.out.print("Nombre: ");
            String nombre = keyboard.nextLine();
            System.out.print("NIF: ");
            String nif = keyboard.nextLine();
            System.out.print("Dirección: ");
            String direccion = keyboard.nextLine();
            System.out.print("ID de la delegacion asociada: ");
            String delegacionId = keyboard.nextLine();
            System.out.print("Tipo Empleado [1. Empleado, 2. Colaborador, 3. Voluntario Nacional, 4. Voluntario Internacional]: ");
            String tipoEmpleadoStr = keyboard.nextLine();
            int tipoPersonal = Integer.parseInt(tipoEmpleadoStr);

            int id = Integer.parseInt(idStr);
            Delegacion delegacion = delegacionDao.readDelegacion(delegacionId);
            Personal personal = new Personal(id, nombre, nif, direccion, delegacion);
            String tareaDesempena;
            if (tipoPersonal == 1) {
                System.out.print("Salario: ");
                String salario = keyboard.nextLine();
                personal = new Empleado(id, nombre, nif, direccion, delegacion, Float.parseFloat(salario));
            } else if (tipoPersonal == 2) {
                System.out.print("Area Colaboracion: ");
                String areaColaboracion = keyboard.nextLine();
                personal = new Colaborador(id, nombre, nif, direccion, delegacion, areaColaboracion);
            } else if (tipoPersonal == 3) {
                System.out.print("Tarea desempeña: ");
                tareaDesempena = keyboard.nextLine();
                System.out.print("Ciudad: ");
                String ciudad = keyboard.nextLine();
                personal = new Voluntario_Nacional(id, nombre, nif, direccion, delegacion, tareaDesempena, "Nacional", ciudad);
            } else if (tipoPersonal == 4) {
                System.out.print("Tarea desempeña: ");
                tareaDesempena = keyboard.nextLine();
                System.out.print("Pais: ");
                String pais = keyboard.nextLine();
                personal = new Voluntario_Internacional(id, nombre, nif, direccion, delegacion, tareaDesempena, "Internacional", pais);
            }

            personalDao.createPersonal(personal);

            System.out.println("Personal creado con éxito.\n");
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void leerPersonal() {
        try {
            Scanner keyboard = new Scanner(System.in);
            PersonalImpl personalDao = new PersonalImpl();
            System.out.println("---- LEER PERSONAL ----");

            System.out.print("ID Personal: ");
            String personalIdStr = keyboard.nextLine();
            int personalId = Integer.parseInt(personalIdStr);
            Personal personal = personalDao.readPersonal(personalId);
            if (personal != null) {
                System.out.println(personal);
            } else {
                System.out.println("El ID del personal no existe.");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
