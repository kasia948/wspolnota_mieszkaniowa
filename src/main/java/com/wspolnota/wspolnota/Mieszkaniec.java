package com.wspolnota.wspolnota;
import javax.persistence.*;

@Entity
public class Mieszkaniec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String imie;
    private String nazwisko;


    @ManyToOne
    private Mieszkanie mieszkanie;


    @Enumerated(EnumType.STRING)
    private MieszkaniecPlec plec;

    public Mieszkaniec(String imie, String nazwisko, Mieszkanie mieszkanie, MieszkaniecPlec plec) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.mieszkanie = mieszkanie;
        this.plec = plec;
    }

    public Mieszkaniec() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Mieszkanie getMieszkanie() {
        return mieszkanie;
    }

    public void setMieszkanie(Mieszkanie mieszkanie) {
        this.mieszkanie = mieszkanie;
    }

    public MieszkaniecPlec getPlec() {
        return plec;
    }

    public void setPlec(MieszkaniecPlec plec) {
        this.plec = plec;
    }
}