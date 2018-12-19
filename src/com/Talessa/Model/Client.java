package com.Talessa.Model;

import com.Talessa.Control.OperacionsBanc;
import com.Talessa.Exceptions.BankAccountException;
import com.Talessa.Exceptions.BankClientException;
import com.Talessa.Exceptions.ExceptionMessage;

public class Client {
    private String Nom;
    private String Cognoms;
    private String DNI;

    public Client() {
    }

    public Client(String nom, String cognoms, String DNI) throws BankClientException {
        Nom = nom;
        Cognoms = cognoms;
        if(OperacionsBanc.verifyDNI(DNI)) {
            this.DNI = DNI;
        }else{
            throw new BankClientException(ExceptionMessage.WRONG_DNI);
        }

    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getCognoms() {
        return Cognoms;
    }

    public void setCognoms(String cognoms) {
        Cognoms = cognoms;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) throws BankClientException {
        if(OperacionsBanc.verifyDNI(DNI)) {
            this.DNI = DNI;
        }else{
            throw new BankClientException(ExceptionMessage.WRONG_DNI);
        }
    }

    public void transferencia(CompteEstalvi font, CompteEstalvi desti, double suma,ComptesEstalvis comptesEstalvis) throws BankAccountException {

        if (OperacionsBanc.verifyCOMPTE(font,comptesEstalvis)){
            throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }else if (OperacionsBanc.verifyCOMPTE(desti,comptesEstalvis)){
            throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }else if (OperacionsBanc.VerifyTRANS(suma)){
            throw new BankAccountException(ExceptionMessage.TRANSFER_ERROR);
        }else if (OperacionsBanc.verifySALDO(font,suma)){
            throw new BankAccountException(ExceptionMessage.EXTRAC_ERROR);
        }else {
            font.treure(suma);
            desti.ingressar(suma);
            System.out.println("Transferencia completada amb exit.");
        }



    }

}
