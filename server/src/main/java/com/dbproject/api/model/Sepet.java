package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="sepet", schema="getir_app")
@IdClass(SepetId.class)
public class Sepet implements Serializable {
    @Id
    private int siparis_id;
    @Id
    private int urun_id;
    private int adet;

    public Sepet() {
    }

    public Sepet(int siparis_id, int urun_id, int adet) {
        this.siparis_id = siparis_id;
        this.urun_id = urun_id;
        this.adet = adet;
    }

    public int getSiparis_id() {
        return siparis_id;
    }

    public void setSiparis_id(int siparis_id) {
        this.siparis_id = siparis_id;
    }

    public int getUrun_id() {
        return urun_id;
    }

    public void setUrun_id(int urun_id) {
        this.urun_id = urun_id;
    }

    public int getAdet() {
        return adet;
    }

    public void setAdet(int adet) {
        this.adet = adet;
    }
}
