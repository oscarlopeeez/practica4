package com.caleruega.practica4;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api")
public class ControladorFiestas {
    private final ArrayList<ModeloFiesta> fiestas = new ArrayList<>();

    public ControladorFiestas() {
        fiestas.add(new ModeloFiesta("2024-07-26", "Bingo"));
        fiestas.add(new ModeloFiesta("2024-07-27", "Teatro 'El genio alegre'"));
        fiestas.add(new ModeloFiesta("2024-07-29", "Acampada y Gymkana"));
        fiestas.add(new ModeloFiesta("2024-07-31", "Karaoke"));
        fiestas.add(new ModeloFiesta("2024-08-01", "Día de la Tercera Edad"));
        fiestas.add(new ModeloFiesta("2024-08-02", "Día del Niño"));
    }

    @GetMapping("/fiestas/{fecha}")
    public ModeloFiesta obtenerFiestaPorFecha(@PathVariable String fecha) {
        for (ModeloFiesta fiesta : fiestas) {
            if (fiesta.getFecha().equals(fecha)) {
                return fiesta;
            }
        }
        return new ModeloFiesta(fecha, "No hay eventos programados para esta fecha");
    }

    @PostMapping("/fiestas")
    @ResponseStatus(HttpStatus.CREATED)
    public String agregarFiesta(@RequestBody ModeloFiesta mod) {
        if (mod.getFecha() == null || mod.getFecha().isEmpty() || mod.getEvento() == null || mod.getEvento().isEmpty()) {
            throw new IllegalArgumentException("Fecha y evento son requeridos");
        }
        fiestas.add(mod);
        return "Evento agregado exitosamente";
    }

    @PutMapping("/fiestas/{fecha}")
    public String actualizarFiesta(@PathVariable String fecha, @RequestBody ModeloFiesta fiesta) {
        for (int i = 0; i < fiestas.size(); i++) {
            if (fiestas.get(i).getFecha().equals(fecha)) {
                fiestas.set(i, fiesta);
                return "Evento actualizado exitosamente para la fecha " + fecha;
            }
        }
        return "No se encontró un evento para la fecha " + fecha;
    }

    @DeleteMapping("/fiestas/{fecha}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarFiesta(@PathVariable String fecha) {
        fiestas.removeIf(fiesta -> fiesta.getFecha().equals(fecha));
    }
}