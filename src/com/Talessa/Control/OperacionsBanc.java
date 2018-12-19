package com.Talessa.Control;

import com.Talessa.Exceptions.BankAccountException;
import com.Talessa.Model.CompteEstalvi;
import com.Talessa.Model.ComptesEstalvis;

import java.util.List;

public class OperacionsBanc {


    public static boolean verifyDNI(String dni) {
        boolean valido=false;
        int i=0;
        int ascii=0;
        char letra=' ';
        int miDNI=0;
        int resto =0;
        char[] letraAsig={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        if(dni.length()==9&& Character.isLetter(dni.charAt(8))){
            do{
                ascii=dni.codePointAt(i);
                valido=(ascii>47&& ascii <58);
                i++;
            }while (i< dni.length()-1 && valido);
        }
        if (valido){
            letra= Character.toUpperCase(dni.charAt(8));
            miDNI= Integer.parseInt(dni.substring(0,8));
            resto = miDNI % 23;
            valido=(letra== letraAsig[resto]);
        }
        return  valido;
    }
    public static boolean verifyCOMPTE(CompteEstalvi compteEstalvi,ComptesEstalvis comptesEstalvis){

        boolean valido= false;
        List<CompteEstalvi> compteEstalvis1 = comptesEstalvis.getComptes();

        if (!compteEstalvis1.contains(compteEstalvi)){
            valido=true;
        }
        return valido;
    }

    public static boolean verifySALDO(CompteEstalvi compteEstalvi, double suma ){
        boolean valido = false;
        double saldo = compteEstalvi.getSaldo();

        if (saldo < suma){
            valido = true;
        }
        return valido;
    }

    public static boolean VerifyTRANS(double suma){
        boolean valido=false;
        if (suma < 0){
            valido = true;
        }
        return valido;
    }
}
