package cuentabancariaws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MovimientosController {

    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    /*@PostMapping("/cuenta/{idcuenta}/movimientos")
    public Movimientos createMovimientos(@Valid @RequestBody Movimientos movimientos) {
        return movimientosRepository.save(movimientos);
    }*/

    @PostMapping("/cuenta/{idcuenta}/movimientos")
    public Movimientos createMovimientos(@PathVariable (value = "idcuenta") Long idcuenta,
                                 @Valid @RequestBody Movimientos movimientos) {
        ///Cuenta cuenta = cuentaRepository.findById(idcuenta);

        return cuentaRepository.findById(idcuenta).map(cuenta -> {
            movimientos.setCuenta(cuenta);
            return movimientosRepository.save(movimientos);
        }).orElseThrow(() -> new ResourceNotFoundException("idcuenta " + idcuenta + " not found"));

    }
}
