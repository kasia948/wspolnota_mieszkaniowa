package com.wspolnota.wspolnota;
import javax.persistence.*;
import java.util.List;

@Entity
public class Mieszkanie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int number;
    private double powierzchnia;

    @OneToMany(mappedBy = "mieszkanie")
    private List<Mieszkaniec> mieszkancy;


    @ManyToOne
    private Wspolnota wspolnota;

    public Mieszkanie(int number, double powierzchnia, List<Mieszkaniec> mieszkancy, Wspolnota wspolnota) {
        this.number = number;
        this.powierzchnia = powierzchnia;
        this.mieszkancy = mieszkancy;
        this.wspolnota = wspolnota;
    }

    public Mieszkanie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getPowierzchnia() {
        return powierzchnia;
    }

    public void setPowierzchnia(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    public List<Mieszkaniec> getMieszkancy() {
        return mieszkancy;
    }

    public void setMieszkancy(List<Mieszkaniec> mieszkancy) {
        this.mieszkancy = mieszkancy;
    }

    public Wspolnota getWspolnota() {
        return wspolnota;
    }

    public void setWspolnota(Wspolnota wspolnota) {
        this.wspolnota = wspolnota;
    }
}
