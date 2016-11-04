import Klasy.Element;

import java.util.List;

/**
 * Created by Kuba on 2016-10-28.
 */
public class MacierzOgolna {
    double[][] macierzHG;
    Element[]  elementy;

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
}
