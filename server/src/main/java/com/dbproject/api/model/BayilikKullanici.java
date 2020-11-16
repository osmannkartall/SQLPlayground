package com.dbproject.api.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="bayilik_kullanici", schema="getir_app")
@IdClass(BayilikKullaniciId.class)
public class BayilikKullanici implements Serializable {
    @Id
    private int bayilik_id;
    @Id
    private int kullanici_id;

    public BayilikKullanici() {
    }

    public BayilikKullanici(int bayilik_id, int kullanici_id) {
        this.bayilik_id = bayilik_id;
        this.kullanici_id = kullanici_id;
    }

    public int getBayilik_id() {
        return bayilik_id;
    }

    public void setBayilik_id(int bayilik_id) {
        this.bayilik_id = bayilik_id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }
}
