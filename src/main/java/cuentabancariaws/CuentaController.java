package cuentabancariaws;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import java.util.List;

@RestController
public class CuentaController {
    @Autowired
    private CuentaRepository cuentaRepository;

    @Autowired
    private MovimientosRepository movimientosRepository;

    @PostMapping("/cuenta")
    public Cuenta createCuenta(@Valid @RequestBody Cuenta cuenta) {
        return cuentaRepository.save(cuenta);
    }

    @PutMapping("/cuenta/{idcuenta}")
    public Cuenta updateCuenta(@PathVariable Long idcuenta, @Valid @RequestBody Cuenta cuentaRequest) {
        return cuentaRepository.findById(idcuenta).map(cuenta -> {
            //cuenta.setIdcuenta(cuentaRequest.getIdcuenta());
            cuenta.setIban(cuentaRequest.getIban());
            cuenta.setTitular(cuentaRequest.getTitular());
            cuenta.setTipo(cuentaRequest.getTipo());
            cuenta.setSaldo(cuentaRequest.getSaldo());
            return cuentaRepository.save(cuenta);
        }).orElseThrow(() -> new ResourceNotFoundException("idcuenta " + idcuenta + " not found"));
    }

    @DeleteMapping("/cuenta/{idcuenta}")
    public ResponseEntity<?> deleteCuenta(@PathVariable Long idcuenta) {
        return cuentaRepository.findById(idcuenta).map(cuenta -> {
            cuentaRepository.delete(cuenta);
            return ResponseEntity.ok().build();
        }
        ).orElseThrow(() -> new ResourceNotFoundException("idcuenta " + idcuenta + " not found"));
    }


    @GetMapping("/cuenta")
    public Page<Cuenta> getAllCuenta(Pageable pageable) {return cuentaRepository.findAll(pageable);
    }


    @GetMapping("/cuenta/{idcuenta}/movimientos")
    public Page<Movimientos> getCuentaByidcuenta(@PathVariable(value = "idcuenta") Long idcuenta, Pageable pageable) {
        return movimientosRepository.findAll(pageable);
    }
}



