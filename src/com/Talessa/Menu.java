package com.Talessa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    public int menuprincipal(){
        int respuesta = 0;

        System.out.println("Que desea hacer:");
        System.out.println("1-Crear cliente.");
        System.out.println("2-Crear cuenta");
        System.out.println("3-Gestionar cuenta");
        System.out.println("4-Hacer transferencia");
        System.out.println("0-Salir");

        respuesta = scanner.nextInt();
        scanner.nextLine();

        return respuesta;
    }
    public int gestionarcuenta(){
        int respuesta = 0;

        System.out.println("Que desea hacer:");
        System.out.println("1-Ingresar saldo.");
        System.out.println("2-Extraer saldo");
        System.out.println("3-Ver saldo");
        System.out.println("4-Añadir cliente");
        System.out.println("5-Quitar cliente");
        System.out.println("0-Salir");

        respuesta = scanner.nextInt();
        scanner.nextLine();

        return respuesta;
    }

    public List<String> cliente(){
        List<String>cliente=new ArrayList<>();

        System.out.println("Nombre del cliente:");
        cliente.add(scanner.nextLine());

        System.out.println("Apellido del cliente:");
        cliente.add(scanner.nextLine());

        System.out.println("DNI del cliente:");
        cliente.add(scanner.nextLine());

        return cliente;
    }

    public String compte(){

        System.out.println("numero de compte:");
        String ncompte = scanner.nextLine();

        return ncompte;
    }
    public double diner(){
        System.out.println("Introdueixi cantitat");
        double diner= scanner.nextDouble();
        scanner.nextLine();
        return  diner;
    }
    public String nom(){
        System.out.println("Nom del client");
        String nom = scanner.nextLine();
        return nom;
    }
}
