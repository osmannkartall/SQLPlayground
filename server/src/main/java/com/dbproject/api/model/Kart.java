package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "kart", schema = "getir_app")
public class Kart {
    @Id
    private int ID;
    private int kullanici_id;
    private String kart_isim;
    private String kart_no;
    private Date son_kullanma;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getKullanici_id() {
        return kullanici_id;
    }

    public void setKullanici_id(int kullanici_id) {
        this.kullanici_id = kullanici_id;
    }

    public String getKart_isim() {
        return kart_isim;
    }

    public void setKart_isim(String kart_isim) {
        this.kart_isim = kart_isim;
    }

    public String getKart_no() {
        return kart_no;
    }

    public void setKart_no(String kart_no) {
        this.kart_no = kart_no;
    }

    public Date getSon_kullanma() {
        return son_kullanma;
    }

    public void setSon_kullanma(Date son_kullanma) {
        this.son_kullanma = son_kullanma;
    }
}
