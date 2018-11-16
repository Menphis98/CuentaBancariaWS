package cuentabancariaws;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Integer idcuenta;

    public Integer getIdcuenta() {
        return idcuenta;
    }
    public void setIdcuenta(Integer idcuenta) {
        this.idcuenta = idcuenta;
    }

    private String iban;

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }

    private String titular;

    public String getTitular() {
        return titular;
    }
    public void setTitular(String titular) {
        this.titular = titular;
    }



    private String tipo;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    private Double saldo;

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }



    @Override
    public String toString() {
        return "Cuenta{" +
                "id=" + id +
                "idcuenta=" + idcuenta +
                ", iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo='" + saldo + '\'' +
                '}';
    }
}

