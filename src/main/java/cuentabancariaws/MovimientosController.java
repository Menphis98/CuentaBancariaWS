package cuentabancariaws;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class MovimientosController {



    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;


    @PostMapping("/cuenta/{idcuenta}/movimientos")
    public Movimientos createMovimientos(@PathVariable (value = "idcuenta") Long idcuenta,
                                 @Valid @RequestBody Movimientos movimientos) {
        ///Cuenta cuenta = cuentaRepository.findById(idcuenta);

        return cuentaRepository.findById(idcuenta).map(cuenta -> {
            movimientos.setCuenta(cuenta);
            cuenta.getMovimientosList().add(movimientos);
            movimientosRepository.save(movimientos);
            cuentaRepository.save(cuenta);
            return movimientos;
        }).orElseThrow(() -> new ResourceNotFoundException("idcuenta " + idcuenta + " not found"));

    }

}
