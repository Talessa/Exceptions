package com.Talessa;

import com.Talessa.Exceptions.BankAccountException;
import com.Talessa.Exceptions.BankClientException;
import com.Talessa.Model.Client;
import com.Talessa.Model.CompteEstalvi;
import com.Talessa.Model.ComptesEstalvis;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args)  {

        ComptesEstalvis comptesEstalvis = new ComptesEstalvis();

        List<Client> clients = new ArrayList<>();

        Menu menu = new Menu();

        int respuesta1 = 0;
        int respuesta2= 0;
        String ncompte= null;
        boolean salir = false;
        double cantitat = 0;

        System.out.println("Banco Virtual EL PUIG.");
        do {
            respuesta1= menu.menuprincipal();

            switch (respuesta1){
                case 0:
                    salir= true;
                    break;
                case 1://crear cliente
                    List<String>cliente = menu.cliente();
                    try {
                        Client client = new Client(cliente.get(0),cliente.get(1),cliente.get(2));
                        clients.add(client);
                    } catch (BankClientException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2://crear cuenta
                    ncompte = menu.compte();
                    CompteEstalvi compteEstalvi = new CompteEstalvi(ncompte);
                    comptesEstalvis.add(compteEstalvi);
                    break;
                case 3://gestionar cuenta
                    boolean salir2= false;
                    do {
                        respuesta2 = menu.gestionarcuenta();
                        switch (respuesta2){
                            case 0://salir
                                salir= true;
                                break;
                            case 1://ingresar
                                try {
                                    ncompte = menu.compte();
                                    if (comptesEstalvis.comprovarC(ncompte,comptesEstalvis)){
                                        for (int i=0;i<comptesEstalvis.getsize();i++){
                                            if (comptesEstalvis.get(i).getNumCompte()==ncompte){
                                                System.out.print("Ingresar");
                                                cantitat= menu.diner();
                                                comptesEstalvis.get(i).ingressar(cantitat);
                                            }
                                        }
                                    }
                                } catch (BankAccountException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 2://treure
                                try {
                                    ncompte = menu.compte();
                                    if (comptesEstalvis.comprovarC(ncompte,comptesEstalvis)){
                                        for (int i=0;i<comptesEstalvis.getsize();i++){
                                            if (comptesEstalvis.get(i).getNumCompte()==ncompte){
                                                System.out.print("Treure");
                                                cantitat= menu.diner();
                                                comptesEstalvis.get(i).treure(cantitat);
                                            }
                                        }
                                    }
                                } catch (BankAccountException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3://ver saldo
                                try {
                                    ncompte = menu.compte();
                                    if (comptesEstalvis.comprovarC(ncompte,comptesEstalvis)){
                                        for (int i=0;i<comptesEstalvis.getsize();i++){
                                            if (comptesEstalvis.get(i).getNumCompte()==ncompte){
                                                double saldo =comptesEstalvis.get(i).getSaldo();
                                                System.out.println("Su saldo es de: "+saldo);
                                            }
                                        }
                                    }
                                } catch (BankAccountException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 4://Añadir cliente
                                try {
                                    ncompte = menu.compte();
                                    if (comptesEstalvis.comprovarC(ncompte,comptesEstalvis)){
                                        for (int i=0;i<comptesEstalvis.getsize();i++){
                                            if (comptesEstalvis.get(i).getNumCompte()==ncompte){
                                                String nom = menu.nom();
                                                for (int j = 0; j <clients.size() ; j++) {
                                                    if (clients.get(i).getNom().equalsIgnoreCase(nom)){
                                                        comptesEstalvis.get(i).addUser(clients.get(j));
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (BankAccountException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 5://eliminar cliente
                                try {
                                    ncompte = menu.compte();
                                    if (comptesEstalvis.comprovarC(ncompte,comptesEstalvis)){
                                        for (int i=0;i<comptesEstalvis.getsize();i++){
                                            if (comptesEstalvis.get(i).getNumCompte()==ncompte){
                                                String nom = menu.nom();
                                                for (int j = 0; j <clients.size() ; j++) {
                                                    if (clients.get(i).getNom().equalsIgnoreCase(nom)){
                                                        comptesEstalvis.get(i).removeUser(clients.get(i).getDNI());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (BankAccountException e) {
                                    e.printStackTrace();
                                }
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                                break;
                        }
                    }while (!salir);
                    break;
                case 4://hacer transferencia
                    CompteEstalvi desti= null,origen= null;
                    System.out.print("Compte desti");
                    String ndesti = menu.compte();
                    for (int i=0;i<comptesEstalvis.getsize();i++) {
                        if (comptesEstalvis.get(i).getNumCompte() == ndesti) {
                            desti=comptesEstalvis.get(i);
                        }
                    }
                    System.out.print("Compte origen");
                    String norigen = menu.compte();
                    for (int i=0;i<comptesEstalvis.getsize();i++) {
                        if (comptesEstalvis.get(i).getNumCompte() == norigen) {
                            origen=comptesEstalvis.get(i);
                        }
                    }
                    cantitat= menu.diner();


                    try {
                       new Client().transferencia(origen,desti,cantitat,comptesEstalvis);
                    } catch (BankAccountException e) {
                        e.printStackTrace();
                    }

                default:
                    System.out.println("seleccione otra opcion");

            }

        }while (!salir);

    }
}
