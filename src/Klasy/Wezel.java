package Klasy;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Wezel {
    public Integer id;
    public Integer id_lokal;
    public Double t;
    Integer BC;
    public Double x;

    public Integer getBC() {
        return BC;
    }

    public void setBC(Integer BC) {
        this.BC = BC;
    }

    public Wezel(Double x,Integer id,Integer id_lokal){
        this.t=null;
        this.BC=0;
        this.x=x;
        this.id=id;
        this.id_lokal=id_lokal;
    }
}
