package com.dbproject.api.model;

import java.io.Serializable;
import java.util.Objects;

public class AdresBayilikId implements Serializable {
    private int bayilik_id;
    private int adres_id;

    public AdresBayilikId() {
    }

    public AdresBayilikId(int bayilik_id, int adres_id) {
        this.bayilik_id = bayilik_id;
        this.adres_id = adres_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresBayilikId that = (AdresBayilikId) o;
        return bayilik_id == that.bayilik_id &&
                adres_id == that.adres_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bayilik_id, adres_id);
    }
}
