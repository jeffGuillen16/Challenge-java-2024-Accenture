package challengeAccenture.controller;

import challengeAccenture.models.entities.PuntoDeVenta;
import challengeAccenture.service.PuntoDeVentaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/puntos-de-venta")
public class PuntoDeVentaController {
    @Autowired
    private PuntoDeVentaService service;
    private static final Logger logger = LoggerFactory.getLogger(PuntoDeVentaController.class);
    /*
    public PuntosDeVentaController(PuntoDeVentaService service) {
        this.service = service;
    }*/

    @GetMapping
    public ResponseEntity<Collection<PuntoDeVenta>> obtenerTodos() {
        return  ResponseEntity
                .status(HttpStatus.OK)
                        .body(this.service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntoDeVenta> show (@PathVariable Integer id) {
        logger.info("Realizo un getmapping");
        return  ResponseEntity
                .status(HttpStatus.OK)
                     .body(this.service.obtenerUnPuntoDeVenta(id));
    }
    @PostMapping
    public ResponseEntity<PuntoDeVenta> agregar(@RequestBody PuntoDeVenta puntoDeVenta) {
        logger.info("Agregando un nuevo punto de venta");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                     .body(this.service.agregar(puntoDeVenta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuntoDeVenta> actualizar(@PathVariable int id, @RequestBody PuntoDeVenta puntoDeVenta) {
        logger.info("Actualizando punto de venta con ID: " + id);
        PuntoDeVenta actualizado = service.actualizar(id, puntoDeVenta);
        if (actualizado != null) {
            return ResponseEntity.ok(actualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable int id) {
        logger.info("Eliminando punto de venta con ID: " + id);
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Controlador funcionando");
    }

}
