package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="adres_kullanici", schema="getir_app")
@IdClass(AdresKullaniciId.class)
public class AdresKullanici implements Serializable {
    @Id
    private int kullanici_id;
    @Id
    private int adres_id;

    public AdresKullanici() {
    }

    public AdresKullanici(int kullanici_id, int adres_id) {
        this.kullanici_id = kullanici_id;
        this.adres_id = adres_id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }
}
