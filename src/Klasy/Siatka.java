package Klasy;

/**
 * Created by Kuba on 2016-10-28.
 */
public class Siatka {
    Integer liczba_wezlow;
    Integer liczba_elementow;
    Double q;
    static Double alfa;
    Double t_inf;

    public Siatka(Integer wezly, Integer elementy, Double q, Double alfa, Double t_inf){
        liczba_wezlow=wezly;
        liczba_elementow=elementy;
        this.q=q;
        this.alfa=alfa;
        this.t_inf=t_inf;
    }

}
