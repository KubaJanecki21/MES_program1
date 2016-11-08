package Klasy;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kuba on 2016-10-28.
 */
public class FileParser {

    List<Wezel> wezly=new ArrayList<>();
    Siatka siatka;
    Element[] elementy;

    public List<Wezel> getWezly() {
        return wezly;
    }
    public Siatka getSiatka() {
        return siatka;
    }
    public Element[] getElementy() {
        return elementy;
    }



    public FileParser() throws FileNotFoundException {

        Scanner odczyt = new Scanner(new File("input.txt"));

        Integer el=Integer.parseInt(czytajLinie(odczyt));
        String[] elementy_s=new String[el];
        elementy=new Element[el];

        for(int i=0;i<el;i++){
            elementy_s[i]=czytajLinie(odczyt);
        }
        Integer wsp=Integer.parseInt(czytajLinie(odczyt));
        String[] wspolrzedne_s=new String[wsp];

        for(int i=0;i<wsp;i++){
            wspolrzedne_s[i]=czytajLinie(odczyt);
        }

        Double alfa=Double.parseDouble(czytajLinie(odczyt));
        Double q=Double.parseDouble(czytajLinie(odczyt));
        Double temp_inf=Double.parseDouble(czytajLinie(odczyt));

        for(int i=0;i<el;i++){
            elementy[i]=createElement(elementy_s[i],wspolrzedne_s);
        }

        siatka=new Siatka(wezly.size(),elementy.length,q,alfa,temp_inf);

    }

    String czytajLinie(Scanner in){
        return in.nextLine();
    }

    Element createElement(String dane,String[] wspolrzedne){
        Integer wezelId1;
        Integer wezelId2;
        Double S;
        Double k;
        Double L;

        String pattern = "(\\d*)-(\\d*)-(\\d*)-(\\d*)-(\\d*)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(dane);


        if (m.find( )){
            wezelId1=Integer.parseInt(m.group(1));
            wezelId2=Integer.parseInt(m.group(2));
            S=Double.parseDouble(m.group(3));
            k=Double.parseDouble(m.group(4));

            if((wezelId1>wspolrzedne.length)||(wezelId2>wspolrzedne.length)) {
                JOptionPane.showMessageDialog(null, "blad", "nie ma takiego wezla", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            Double x1=Double.parseDouble(wspolrzedne[wezelId1-1]);
            Double x2=Double.parseDouble(wspolrzedne[wezelId2-1]);
            Wezel w1=szukajNaLiscie(wezelId1);
            Wezel w2=szukajNaLiscie(wezelId2);
            if(w1==null) {
                w1=new Wezel(x1, wezelId1,1);
                wezly.add(w1);
            }
            if(w2==null) {
                w2=new Wezel(x2,wezelId2,2);
                wezly.add(w2);
            }

            L= Math.abs(x2-x1);
            return new Element(w1,w2,S,k,L);


        } else return null;

    }


    Wezel szukajNaLiscie(Integer id){
        if(wezly.size()!=0){
            for(Wezel w:wezly) {
                if (w.id==id) return w;
            }
            return null;
        } else return null;
    }

}
