package Klasy;

import Jama.Matrix;

import java.util.Vector;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Element {

    Wezel wezel1;
    Wezel wezel2;
    Double S;
    Double k;
    Double L;
    Matrix LH;
    Matrix LP;

    public Element(Wezel w1,Wezel w2,Double S,Double k, Double L){
        this.wezel1=w1;
        this.wezel2=w2;
        this.S=S;
        this.k=k;
        this.L=L;
    }


}
