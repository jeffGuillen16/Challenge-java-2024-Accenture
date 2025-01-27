package challengeAccenture.service;

import challengeAccenture.models.entities.PuntoDeVenta;
import org.springframework.stereotype.Service;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PuntoDeVentaService {
    private final ConcurrentHashMap<Integer, PuntoDeVenta> cache = new ConcurrentHashMap<>();

    public PuntoDeVentaService() {
        cache.put(1, new PuntoDeVenta(1, "CABA"));
        cache.put(2, new PuntoDeVenta(2, "GBA_1"));
        cache.put(3, new PuntoDeVenta(3, "GBA_2"));
        cache.put(4, new PuntoDeVenta(4, "Santa Fe"));
        cache.put(5, new PuntoDeVenta(5, "Córdoba"));
        cache.put(6, new PuntoDeVenta(6, "Misiones"));
        cache.put(7, new PuntoDeVenta(7, "Salta"));
        cache.put(8, new PuntoDeVenta(8, "Chubut"));
        cache.put(9, new PuntoDeVenta(9, "Santa Cruz"));
        cache.put(10, new PuntoDeVenta(10, "Catamarca"));
    }

    public Collection<PuntoDeVenta> obtenerTodos() {
        return cache.values();
    }

    public PuntoDeVenta obtenerUnPuntoDeVenta(int id) {
        PuntoDeVenta puntoDeVenta = cache.get(id);
        return puntoDeVenta;
    }
    public PuntoDeVenta agregar(PuntoDeVenta puntoDeVenta) {
        cache.put(puntoDeVenta.getId(), puntoDeVenta);
        return puntoDeVenta;
    }

    public PuntoDeVenta actualizar(int id, PuntoDeVenta puntoDeVenta) {
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
