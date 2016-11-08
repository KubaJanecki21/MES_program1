package Klasy;

/**
 * Created by Kuba on 2016-11-08.
 */
public class WektorWymuszen{

    public double[] wektor;

    public WektorWymuszen(Element[] elementy){
        wektor=new double[elementy.length+1];
        //for(int i=0;i<elementy.length+1;i++) wektor[i]=0.0;
        for(int i=0;i<elementy.length+1;i++) wektor[i]=0.0;
        for(int i=0;i<elementy.length;i++){
            wektor[i]+=elementy[i].P.wektor[0];
            wektor[i+1]+=elementy[i].P.wektor[1];
        }

    }

    public WektorWymuszen(Element el){
        wektor=new double[2];
        for(int i=0;i<2;i++) wektor[i]=0.0;
        Wezel w[]={el.wezel1,el.wezel2};
        for(int i=0;i<2;i++) {
            if (w[i].getBC() == 1) wektor[i] = el.S * Siatka.q;
            if (w[i].getBC() == 2) {
                wektor[i]= -el.S*Siatka.alfa*Siatka.t_inf; //TODO wzor wymuszenia dla konwekcji
            }
        }
    }


}