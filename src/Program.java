import Klasy.*;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Program {

    static Siatka siatka;
    static Element[] elementy;
    static List<Wezel> wezly;

    public static void main(String[] args){
        try {
            FileParser fp= new FileParser();
            getDane(fp);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        wezly.get(0).setBC(1);
        wezly.get(2).setBC(2);

        MacierzLokalna m;
        for(Element el:elementy) {
            m=new MacierzLokalna(el);
        }

        MacierzOgolna HG=new MacierzOgolna(elementy);

        //TODO sumowanie macierzy H wdg algorytmu z zeszytu, nakladajace sie kwadraty
        //TODO policzyć macierz P
        //TODO wyliczyć temperatury z układu równań i elo


    }

    private static void getDane(FileParser fp){
        siatka=fp.getSiatka();
        elementy=fp.getElementy();
        wezly=fp.getWezly();
    }


}
