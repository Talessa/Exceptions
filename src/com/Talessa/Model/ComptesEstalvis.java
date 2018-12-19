package com.Talessa.Model;

import com.Talessa.Control.OperacionsBanc;
import com.Talessa.Exceptions.BankAccountException;
import com.Talessa.Exceptions.ExceptionMessage;

import java.util.List;

public class ComptesEstalvis {
    static List<CompteEstalvi> comptes;

    public ComptesEstalvis() {
    }

    public ComptesEstalvis(List<CompteEstalvi> comptes) {
        this.comptes = comptes;
    }

    public static List<CompteEstalvi> getComptes() {
        return comptes;
    }

    public void setComptes(List<CompteEstalvi> comptes) {
        this.comptes = comptes;
    }

    public void add(CompteEstalvi compteEstalvi){
        comptes.add(compteEstalvi);
    }

    public  CompteEstalvi  get(int n){
        return comptes.get(n);
    }
    public int getsize(){
        return comptes.size();
    }


    public boolean comprovarC(String ncompte, ComptesEstalvis comptesEstalvis) throws BankAccountException {
        boolean existe= false;
        for (int i =0; 1<comptesEstalvis.getsize(); i++){
            if(comptesEstalvis.get(i).getNumCompte()== ncompte){
                existe=true;
            }
        }
        if (!existe){
            throw new BankAccountException(ExceptionMessage.ACCOUNT_NOT_FOUND);
        }
       return existe;
    }
}
