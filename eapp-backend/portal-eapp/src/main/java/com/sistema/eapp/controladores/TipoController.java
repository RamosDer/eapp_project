package com.sistema.eapp.controladores;

import com.sistema.eapp.modelo.Tipo;
import com.sistema.eapp.servicios.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/tipos")
@CrossOrigin("*")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @PostMapping("/")
    public Tipo guardarTipo(@RequestBody Tipo tipo) {
        return tipoService.guardarTipo(tipo);
    }

    @GetMapping("/{codTipo}")
    public Tipo obtenerTipo(@PathVariable("codTipo") String codTipo) {
        return tipoService.obtenerPorCodTipo(codTipo)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tipo no encontrado"));
    }

    @GetMapping("/")
    public List<Tipo> listarTodos() {
        return tipoService.listarTodos();
    }

    @DeleteMapping("/{codTipo}")
    public void eliminarTipo(@PathVariable("codTipo") String codTipo) {
        tipoService.eliminarTipo(codTipo);
    }
}
