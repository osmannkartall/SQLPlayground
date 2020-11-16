package com.dbproject.api.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "siparis", schema = "getir_app")
public class Siparis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int kullanici_id;
    private int kart_id;
    private float sepet_tutari;
    private Date siparis_tarihi;

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public int getKart_id() {
        return kart_id;
    }

    public void setKart_id(int kart_id) {
        this.kart_id = kart_id;
    }

    public float getSepet_tutari() {
        return sepet_tutari;
    }

    public void setSepet_tutari(float sepet_tutari) {
        this.sepet_tutari = sepet_tutari;
    }

    public Date getSiparis_tarihi() {
        return siparis_tarihi;
    }

    public void setSiparis_tarihi(Date siparis_tarihi) {
        this.siparis_tarihi = siparis_tarihi;
    }
}
