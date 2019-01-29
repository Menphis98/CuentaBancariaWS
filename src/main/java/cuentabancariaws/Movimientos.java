package cuentabancariaws;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "movimientos")
public class Movimientos {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private long idmovimiento;

    private Long idcuenta;

    public Long getIdcuenta() {
        return idcuenta;
    }
    public void setIdcuenta(Long idcuenta) {
        this.idcuenta = idcuenta;
    }

    private String concepto;

    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    private Date fecha;

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }



    private Double importe;

    public Double getImporte() {
        return importe;
    }
    public void setImporte(Double importe) {
        this.importe = importe;
    }



    private Double saldoactual;

    public Double getSaldoactual() {
        return saldoactual;
    }

    public void setSaldoactual(Double saldoactual) {
        this.saldoactual = saldoactual;
    }

    @ManyToOne
    //@JoinColumn(name="idcuenta")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cuenta cuenta;

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "idmovimiento=" + idmovimiento +
                "idcuenta=" + idcuenta +
                ", concepto='" + concepto + '\'' +
                ", fecha='" + fecha + '\'' +
                ", importe='" + importe + '\'' +
                ", saldoactual='" + saldoactual + '\'' +
                '}';
    }
}