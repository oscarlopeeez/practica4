package com.caleruega.practica4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ControladorFiestas {
    private final Map<String, ModeloFiesta> fiestas = new HashMap<>();

    public ControladorFiestas() {
        fiestas.put("2024-07-26", new ModeloFiesta("2024-07-26", "Bingo"));
        fiestas.put("2024-07-27", new ModeloFiesta("2024-07-27", "Teatro 'El genio alegre'"));
        fiestas.put("2024-07-29", new ModeloFiesta("2024-07-29", "Acampada y Gymkana"));
        fiestas.put("2024-07-31", new ModeloFiesta("2024-07-31", "Karaoke"));
        fiestas.put("2024-08-01", new ModeloFiesta("2024-08-01", "Día de la Tercera Edad"));
        fiestas.put("2024-08-02", new ModeloFiesta("2024-08-02", "Día del Niño"));
    }

    @GetMapping("/fiestas/{fecha}")
    public ModeloFiesta obtenerFiestaPorFecha(@PathVariable String fecha) {
        return fiestas.getOrDefault(fecha, new ModeloFiesta(fecha, "No hay eventos programados para esta fecha"));
    }

    @PostMapping("/fiestas")
    @ResponseStatus(HttpStatus.CREATED)
    public String agregarFiesta(@RequestParam(required = true) String fecha, @RequestParam(required = true) String evento) {
        if (fecha == null || fecha.isEmpty() || evento == null || evento.isEmpty()) {
            throw new IllegalArgumentException("Fecha y evento son requeridos");
        }
        fiestas.put(fecha, new ModeloFiesta(fecha, evento));
        return "Evento agregado exitosamente";
    }

    @PutMapping("/api/fiestas/{fecha}")
    public String actualizarFiesta(@PathVariable String fecha,
                                   @RequestBody ModeloFiesta fiesta) {
        if (fiestas.containsKey(fecha)) {
            fiestas.put(fecha, fiesta);
            return "Evento actualizado exitosamente para la fecha " + fecha;
        } else {
            return "No se encontró un evento para la fecha " + fecha;
        }
    }

    @DeleteMapping("/fiestas/{fecha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarFiesta(@PathVariable String fecha) {
        fiestas.remove(fecha);
    }
}