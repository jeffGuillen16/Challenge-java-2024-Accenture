package challengeAccenture.controller;

import challengeAccenture.models.entities.PuntosDeVenta;
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
public class PuntosDeVentaController {
    @Autowired
    private final PuntoDeVentaService service;
    private static final Logger logger = LoggerFactory.getLogger(PuntosDeVentaController.class);

    public PuntosDeVentaController(PuntoDeVentaService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Collection<PuntosDeVenta>> obtenerTodos() {
        return  ResponseEntity
                .status(HttpStatus.OK)
                        .body(this.service.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuntosDeVenta> show (@PathVariable Integer id) {
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(this.service.obtenerUnPuntoDeVenta(id));
    }

    @PostMapping("/puntos-de-venta")
    public ResponseEntity<String> agregar(@RequestBody PuntosDeVenta puntoDeVenta) {
        logger.info("Agregando un nuevo punto de venta");
        return ResponseEntity
                .ok("agregado");
    }
/*
*  @PostMapping
  public ResponseEntity<Long> cargarCliente(@RequestBody Cliente cliente) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(this.clientesService.crearCliente(cliente));
  }
* */
    @PutMapping("/{id}")
    public ResponseEntity<PuntosDeVenta> actualizar(@PathVariable int id, @RequestBody PuntosDeVenta puntoDeVenta) {
        logger.info("Actualizando punto de venta con ID: " + id);
        PuntosDeVenta actualizado = service.actualizar(id, puntoDeVenta);
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
