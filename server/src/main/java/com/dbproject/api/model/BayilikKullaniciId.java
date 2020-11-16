package com.dbproject.api.model;

import java.io.Serializable;
import java.util.Objects;

public class BayilikKullaniciId implements Serializable {
    private int bayilik_id;
    private int kullanici_id;

    public BayilikKullaniciId() {
    }

    public BayilikKullaniciId(int bayilik_id, int kullanici_id) {
        this.bayilik_id = bayilik_id;
        this.kullanici_id = kullanici_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BayilikKullaniciId that = (BayilikKullaniciId) o;
        return bayilik_id == that.bayilik_id &&
                kullanici_id == that.kullanici_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bayilik_id, kullanici_id);
    }
}
