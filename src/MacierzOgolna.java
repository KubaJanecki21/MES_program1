import Klasy.Element;
import Klasy.WektorWymuszen;
import Klasy.Wezel;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Kuba on 2016-10-28.
 */
public class MacierzOgolna {
    double[][] macierzHG;
    Element[]  elementy;
    WektorWymuszen PG;

    public MacierzOgolna(Element[] el){
        this.elementy=el;
        macierzHG=inicjujMacierz(el.length+1);
    }

    double[][] inicjujMacierz(int romiar){
        double[][] macierz=new double[romiar][romiar];
        for(int i=0;i<romiar;i++){
            for(int j=0;j<romiar;j++)
            {
                macierz[i][j]=0.0;
            }
        }
        return macierz;
    }

    void wypelnijWektorP(){
        PG=new WektorWymuszen(elementy);
    }

    void wypelnijMacierz(){
        for (int i=0;i< elementy.length;i++){
            int id1=elementy[i].wezel1.id;
            int id2=elementy[i].wezel2.id;
            HashMap<Integer,Integer> mapowanie=new HashMap<>();
            mapowanie.put(1,id1);
            mapowanie.put(2,id2);

            for(int j=0;j<2;j++){
                for(int k=0;k<2;k++){
                    Double val=elementy[i].LH.get(j,k);
                    int jG=0;
                    int kG=0;
                    if(mapowanie.get(j+1)!=null){
                        jG=mapowanie.get(j+1);
                    }
                    if(mapowanie.get(k+1)!=null){
                        kG=mapowanie.get(k+1);
                    }
                    macierzHG[jG-1][kG-1]+=val;
                }
            }

        }
    }




}
