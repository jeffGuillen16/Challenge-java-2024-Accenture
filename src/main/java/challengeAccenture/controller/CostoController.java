package challengeAccenture.controller;

import challengeAccenture.models.entities.Costo;
import challengeAccenture.service.CostoService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/costos")
public class CostoController {
    @Autowired
    private CostoService costoService;
    // Endpoint (5): Obtener todos los costos en el caché
    @GetMapping
    public Map<Integer, Map<Integer, Integer>> obtenerTodosLosCostos() {
        return costoService.obtenerCache();
    }

    // Endpoint (1): Cargar un nuevo costo
    @PostMapping("/agregar")
    public void agregarCosto(@RequestBody Costo costo) {
        costoService.agregarCosto(costo.getIdA(), costo.getIdB(), costo.getCosto());
    }

    // Endpoint (2): Remover un costo entre dos puntos de venta
    @DeleteMapping("/remover")
    public ResponseEntity<Void> removerCosto(@RequestParam int idA, @RequestParam int idB) {
        costoService.removerCosto(idA, idB);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // Endpoint (3): Consultar costos directos desde un punto
    @GetMapping("/directos/{idA}")
    public List<Costo> obtenerCostosDirectos(@PathVariable int idA) {
        return costoService.obtenerCostosDirectos(idA);
    }

    // Endpoint (4): Consultar el camino de costo mínimo
    @GetMapping("/minimo")
    public Map<String, Object> obtenerCaminoMinimo(@RequestParam int idA, @RequestParam int idB) {
        return costoService.calcularCaminoMinimo(idA, idB);
    }
}
