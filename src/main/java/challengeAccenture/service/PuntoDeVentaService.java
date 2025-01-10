package challengeAccenture.service;

import challengeAccenture.models.entities.PuntosDeVenta;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PuntoDeVentaService {
    private final ConcurrentHashMap<Integer, PuntosDeVenta> cache = new ConcurrentHashMap<>();

    public PuntoDeVentaService() {
        cache.put(1, new PuntosDeVenta(1, "CABA"));
        cache.put(2, new PuntosDeVenta(2, "GBA_1"));
        cache.put(3, new PuntosDeVenta(3, "GBA_2"));
        cache.put(4, new PuntosDeVenta(4, "Santa Fe"));
        cache.put(5, new PuntosDeVenta(5, "Córdoba"));
        cache.put(6, new PuntosDeVenta(6, "Misiones"));
        cache.put(7, new PuntosDeVenta(7, "Salta"));
        cache.put(8, new PuntosDeVenta(8, "Chubut"));
        cache.put(9, new PuntosDeVenta(9, "Santa Cruz"));
        cache.put(10, new PuntosDeVenta(10, "Catamarca"));
    }

    public Collection<PuntosDeVenta> obtenerTodos() {
        return cache.values();
    }

    public PuntosDeVenta obtenerUnPuntoDeVenta(int id) {
        PuntosDeVenta puntoDeVenta = cache.get(id);
        return puntoDeVenta;
    }
    public PuntosDeVenta agregar(PuntosDeVenta puntoDeVenta) {
        cache.put(puntoDeVenta.getId(), puntoDeVenta);
        return puntoDeVenta;
    }

    public PuntosDeVenta actualizar(int id, PuntosDeVenta puntoDeVenta) {
        if (cache.containsKey(id)) {
            cache.put(id, puntoDeVenta);
            return puntoDeVenta;
        }
        return null;
    }

    public boolean eliminar(int id) {
        return cache.remove(id) != null;
    }
}
