package ua1.model;

import java.io.Serializable;

public class Car implements Serializable{
    private String code;
    private int kms;
    private float cc;
    private Cliente propietario;
    public String observaciones;

    public Car() {
    }

    
    public Car(String code, int kms, float cc) {
        this.code = code;
        this.kms = kms;
        this.cc = cc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public int getKms() {
        return kms;
    }

    public void setKms(int kms) {
        this.kms = kms;
    }

    public float getCc() {
        return cc;
    }

    public void setCc(float cc) {
        this.cc = cc;
    }

    @Override
    public String toString() {
        return "Car{" + "code=" + code + ", kms=" + kms + ", cc=" + cc + ", propietario="+this.propietario+"}";
    }
    
    
    
}
