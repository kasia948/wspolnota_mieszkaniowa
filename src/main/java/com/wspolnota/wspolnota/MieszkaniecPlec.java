package com.wspolnota.wspolnota;

public enum MieszkaniecPlec {

    KOBIETA("Kobieta"),
    MEZCZYZNA("Mezczyzna");

    String displayName;

    MieszkaniecPlec (String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
