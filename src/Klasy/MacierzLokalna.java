package Klasy;

import Jama.Matrix;

/**
 * Created by Kuba on 2016-10-28.
 */
public class MacierzLokalna {
    final int rozmiar=2;
    Element el;
    double[][] macierzH;
    double[][] macierzKonw;

    public MacierzLokalna(Element el){
        this.el=el;
        macierzH=inicjujMacierz(rozmiar);
        macierzKonw=inicjujMacierz(rozmiar);

        liczMacierz();
        Matrix matrixH=new Matrix(macierzH);
        Matrix matrixKonw=new Matrix(macierzKonw);
        matrixH=matrixH.plus(matrixKonw);
        el.LH=matrixH;

    }



    void liczMacierz(){
        int bc=el.wezel1.getBC();
        int bc2=el.wezel2.getBC();
        if((bc==2)||(bc2==2)) {
            if(bc==2){
                macierzKonw[0][0]=Siatka.alfa*el.S;
            } else macierzKonw[1][1]=Siatka.alfa*el.S;//TODO zmiana tej macierzy konwekcji zaleznie od kierunku strumienia
        }

        for(int i=0;i<rozmiar;i++){
            for(int j=0;j<rozmiar;j++){
                if(i==j) macierzH[i][j]=((el.k*el.S)/el.L);
                else macierzH[i][j]=-((el.k*el.S)/el.L);
            }
        }
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
