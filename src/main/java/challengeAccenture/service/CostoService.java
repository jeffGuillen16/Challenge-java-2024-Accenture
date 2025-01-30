package challengeAccenture.service;

import challengeAccenture.models.entities.Costo;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CostoService {

    // Caché en memoria para almacenar los costos entre puntos de venta
    private final Map<Integer, Map<Integer, Integer>> cache = new HashMap<>();

    public CostoService() {
        // Inicialización usando `put`
        cache.put(1, new HashMap<>());
        cache.get(1).put(2, 2);
        cache.get(1).put(3, 3);
        cache.get(1).put(4, 11);

        cache.put(2, new HashMap<>());
        cache.get(2).put(3, 5);
        cache.get(2).put(4, 10);
        cache.get(2).put(5, 14);

        cache.put(3, new HashMap<>());
        cache.get(3).put(8, 10);

        cache.put(4, new HashMap<>());
        cache.get(4).put(5, 5);
        cache.get(4).put(6, 6);

        cache.put(5, new HashMap<>());
        cache.get(5).put(8, 30);

        cache.put(6, new HashMap<>());
        cache.get(6).put(7, 32);

        cache.put(7, new HashMap<>());
        cache.get(7).put(10, 5);

        cache.put(8, new HashMap<>());
        cache.get(8).put(9, 11);

        cache.put(9, new HashMap<>()); // Nodo aislado (si es necesario)

        cache.put(10, new HashMap<>());
        cache.get(10).put(5, 5);
    }

    public Map<Integer, Map<Integer, Integer>> obtenerCache() {
        return cache;
    }
    //  Cargar un nuevo costo entre dos puntos de venta.

    public void agregarCosto(int idA, int idB, int costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("El costo no puede ser menor a 0");
        }
        if (idA == idB) {
            throw new IllegalArgumentException("El costo de un punto a sí mismo debe ser 0");
        }

        // Inicializar mapas internos si no existen
        cache.putIfAbsent(idA, new HashMap<>());
        cache.putIfAbsent(idB, new HashMap<>());

        // Agregar el costo en ambos sentidos
        cache.get(idA).put(idB, costo);
        cache.get(idB).put(idA, costo);
    }


    //  Remover un costo entre dos puntos de venta.

    public void removerCosto(int idA, int idB) {
        if (cache.containsKey(idA)) {
            cache.get(idA).remove(idB);
        }
        if (cache.containsKey(idB)) {
            cache.get(idB).remove(idA);
        }
    }

 /*
     // Consultar los puntos de venta directamente conectados a un punto A, y sus costos.

    public List<Costo> obtenerCostosDirectos(int idA) {
        if (!cache.containsKey(idA)) {
            return Collections.emptyList();
        }

        List<Costo> costosDirectos = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : cache.get(idA).entrySet()) {
            int idB = entry.getKey();
            int costo = entry.getValue();
            costosDirectos.add(new Costo(idA, idB, costo));
        }
        return costosDirectos;
    }


     // Consultar el camino con costo mínimo entre dos puntos A y B.

    public Map<String, Object> calcularCaminoMinimo(int idA, int idB) {
        // Usamos el algoritmo de Dijkstra para encontrar el camino mínimo
        Map<Integer, Integer> distancias = new HashMap<>();
        Map<Integer, Integer> predecesores = new HashMap<>();
        Set<Integer> visitados = new HashSet<>();
        PriorityQueue<int[]> cola = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Inicialización
        distancias.put(idA, 0);
        cola.offer(new int[]{idA, 0});

        while (!cola.isEmpty()) {
            int[] actual = cola.poll();
            int nodoActual = actual[0];
            int distanciaActual = actual[1];

            if (visitados.contains(nodoActual)) {
                continue;
            }
            visitados.add(nodoActual);

            // Explorar los vecinos
            if (cache.containsKey(nodoActual)) {
                for (Map.Entry<Integer, Integer> vecino : cache.get(nodoActual).entrySet()) {
                    int nodoVecino = vecino.getKey();
                    int peso = vecino.getValue();
                    int nuevaDistancia = distanciaActual + peso;

                    if (nuevaDistancia < distancias.getOrDefault(nodoVecino, Integer.MAX_VALUE)) {
                        distancias.put(nodoVecino, nuevaDistancia);
                        predecesores.put(nodoVecino, nodoActual);
                        cola.offer(new int[]{nodoVecino, nuevaDistancia});
                    }
                }
            }
        }

        // Construir el resultado
        Map<String, Object> resultado = new HashMap<>();
        if (!distancias.containsKey(idB)) {
            resultado.put("costo_minimo", -1); // No alcanzable
            resultado.put("camino", Collections.emptyList());
        } else {
            resultado.put("costo_minimo", distancias.get(idB));
            resultado.put("camino", reconstruirCamino(idA, idB, predecesores));
        }
        return resultado;
    }*

    /*
     //Reconstruir el camino desde A a B usando los predecesores.

    private List<Integer> reconstruirCamino(int idA, int idB, Map<Integer, Integer> predecesores) {
        LinkedList<Integer> camino = new LinkedList<>();
        Integer actual = idB;

        while (actual != null) {
            camino.addFirst(actual);
            actual = predecesores.get(actual);
        }

        if (camino.getFirst() != idA) {
            return Collections.emptyList(); // No hay un camino válido
        }

        return camino;
    }*/
}
