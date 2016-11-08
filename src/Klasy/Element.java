package Klasy;

import Jama.Matrix;

import java.util.Vector;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Element {

    public Wezel wezel1;
    public Wezel wezel2;
    Double S;
    Double k;
    Double L;
    public Matrix LH;
    WektorWymuszen P;

    public Element(Wezel w1,Wezel w2,Double S,Double k, Double L){
        this.wezel1=w1;
        this.wezel2=w2;
        this.S=S;
        this.k=k;
        this.L=L;

    }

    public void generujLH(){
        MacierzLokalna LH=new MacierzLokalna(this);

    }

    public void setWektorWymuszen(){
        P=new WektorWymuszen(this);
    }


}
