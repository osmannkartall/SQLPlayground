package com.dbproject.api.model;

import java.io.Serializable;
import java.util.Objects;

public class AdresKullaniciId implements Serializable {
    private int kullanici_id;
    private int adres_id;

    public AdresKullaniciId() {
    }

    public AdresKullaniciId(int kullanici_id, int adres_id) {
        this.kullanici_id = kullanici_id;
        this.adres_id = adres_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresKullaniciId that = (AdresKullaniciId) o;
        return kullanici_id == that.kullanici_id &&
                adres_id == that.adres_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kullanici_id, adres_id);
    }
}
