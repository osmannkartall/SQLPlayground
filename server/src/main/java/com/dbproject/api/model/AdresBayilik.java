package com.dbproject.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="adres_bayilik", schema="getir_app")
@IdClass(AdresBayilikId.class)
public class AdresBayilik implements Serializable {
    @Id
    private int bayilik_id;
    @Id
    private int adres_id;

    public AdresBayilik() {
    }

    public AdresBayilik(int bayilik_id, int adres_id) {
        this.bayilik_id = bayilik_id;
        this.adres_id = adres_id;
    }

    public int getBayilik_id() {
        return bayilik_id;
    }

    public void setBayilik_id(int bayilik_id) {
        this.bayilik_id = bayilik_id;
    }

    public int getAdres_id() {
        return adres_id;
    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }
}
