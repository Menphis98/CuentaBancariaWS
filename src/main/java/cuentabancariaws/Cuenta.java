package cuentabancariaws;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idcuenta;


    @NotNull
    //private Integer idcuenta;


    @OneToMany
    private List<Movimientos> movimientosList = new ArrayList<>();

    public List<Movimientos> getMovimientosList() {
        return movimientosList;
    }

    public void setMovimientosList(List<Movimientos> movimientosList) {
        this.movimientosList = movimientosList;
    }

    public Long getIdcuenta() {
        return idcuenta;
    }
    public void setIdcuenta(Long idcuenta) {
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
                "idcuenta=" + idcuenta +
                ", iban='" + iban + '\'' +
                ", titular='" + titular + '\'' +
                ", tipo='" + tipo + '\'' +
                ", saldo='" + saldo + '\'' +
                '}';
    }
}