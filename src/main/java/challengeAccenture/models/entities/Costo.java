package challengeAccenture.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Costo {
    @JsonProperty("id_origen")
    private final int idA;

    @JsonProperty("id_destino")
    private final int idB;

    @JsonProperty("costo_valor")
    private final int costo;

    public Costo(@JsonProperty("id_origen") int idA,
                 @JsonProperty("id_destino") int idB,
                 @JsonProperty("costo_valor") int costo) {
        if (costo < 0) {
            throw new IllegalArgumentException("El costo no puede ser menor a 0");
        }
        if (idA == idB) {
            throw new IllegalArgumentException("Los puntos de venta no pueden ser iguales");
        }
        this.idA = Math.min(idA, idB); // Ordenar IDs para evitar duplicados (1,2 es igual a 2,1)
        this.idB = Math.max(idA, idB);
        this.costo = costo;
    }

    public int getIdA() {
        return idA;
    }

    public int getIdB() {
        return idB;
    }

    public int getCosto() {
        return costo;
    }
}
