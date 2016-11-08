import Klasy.*;

import java.awt.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Program {

    static Siatka siatka;
    static Element[] elementy;
    static List<Wezel> wezly;

    public static void main(String[] args) throws IOException {
        try {
            FileParser fp= new FileParser();
            getDane(fp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        wezly.get(0).setBC(1);
        wezly.get(2).setBC(2);

        for(Element el:elementy) {
            el.generujLH();
            el.setWektorWymuszen();
        }

        MacierzOgolna HG=new MacierzOgolna(elementy);
        HG.wypelnijMacierz();
        HG.wypelnijWektorP();

        for(int i=0;i<HG.PG.wektor.length;i++) HG.PG.wektor[i]*=-1;

        Gausse g=new Gausse();
        double[] wynik=g.lsolve(HG.macierzHG,HG.PG.wektor);

        BufferedWriter writer = new BufferedWriter(new FileWriter("zrzut_danych.txt"));
        for(int i=0;i<wynik.length;i++) {
            System.out.println(Double.toString(wynik[i]));
            String newline = System.getProperty("line.separator");
            writer.write("T"+(i+1)+": "+Double.toString(wynik[i])+newline);
        }
        writer.flush();
        writer.close();
        Desktop.getDesktop().open(new File("zrzut_danych.txt"));
    }

    private static void getDane(FileParser fp){
        siatka=fp.getSiatka();
        elementy=fp.getElementy();
        wezly=fp.getWezly();
    }


}
