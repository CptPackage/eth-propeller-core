package org.adridadou.ethereum.propeller.keystore;

/**
 * Created by davidroon on 20.04.16.
 * This code is released under Apache 2 license
 */
public class KdfParams {
    private Integer c;
    private Integer dklen;
    private String prf;
    private String salt;
    private Integer n;
    private Integer p;
    private Integer r;


    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public Integer getP() {
        return p;
    }

    public void setP(Integer p) {
        this.p = p;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getDklen() {
        return dklen;
    }

    public void setDklen(Integer dklen) {
        this.dklen = dklen;
    }

    public String getPrf() {
        return prf;
    }

    public void setPrf(String prf) {
        this.prf = prf;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
