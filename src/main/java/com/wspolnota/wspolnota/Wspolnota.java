package com.wspolnota.wspolnota;
import javax.persistence.*;
import java.util.List;

@Entity
public class Wspolnota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String ulica;
    private int numer;

    @OneToMany(mappedBy = "wspolnota")
    private List<Mieszkanie> mieszkania;

    public Wspolnota(String nazwa, String ulica, int numer, List<Mieszkanie> mieszkania) {
        this.nazwa = nazwa;
        this.ulica = ulica;
        this.numer = numer;
        this.mieszkania = mieszkania;
    }

    public Wspolnota() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumer() {
        return numer;
    }

    public void setNumer(int numer) {
        this.numer = numer;
    }

    public List<Mieszkanie> getMieszkania() {
        return mieszkania;
    }

    public void setMieszkania(List<Mieszkanie> mieszkania) {
        this.mieszkania = mieszkania;
    }
}
