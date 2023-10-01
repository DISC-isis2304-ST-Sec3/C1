package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorio.PrestamosRepository;

import org.springframework.ui.Model;

@Controller
public class PrestamosController {

    @Autowired
    private PrestamosRepository prestamosRepository;

    @GetMapping("/prestamos")
    public String prestamos(Model model) {
        model.addAttribute( "prestamos", prestamosRepository.findAll());
        return "prestamos";
    }

    @GetMapping("/prestamos/new")
    public String prestamosNew(Model model) {
        model.addAttribute( "prestamo", new Prestamo());
        return "prestamosNew";
    }

    @PostMapping("/prestamos/new/save")
    public String prestamosNewSave(@ModelAttribute Prestamo prestamo) {
        prestamosRepository.insertPrestamo(prestamo.getNombre(), prestamo.getUtensilio(), prestamo.getDevuelto(), prestamo.getCondicion());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/edit")
    public String prestamosEdit(@PathVariable("id") int id,Model model) {
        Prestamo prestamo = prestamosRepository.findPrestamoById(id);
        if (prestamo != null){
            model.addAttribute( "prestamo", prestamo);
            return "prestamosEdit";
        } else {
            return "redirect:/prestamos";
        }
    }

    @PostMapping("/prestamos/{id}/edit/save")
    public String prestamosEditSave(@PathVariable("id") int id, @ModelAttribute Prestamo prestamo) {
        prestamosRepository.updatePrestamo(id, prestamo.getNombre(), prestamo.getUtensilio(), 
                                            prestamo.getDevuelto(), prestamo.getCondicion());
        return "redirect:/prestamos";
    }

    @GetMapping("/prestamos/{id}/delete")
    public String prestamosDelete(@PathVariable("id") int id) {
        prestamosRepository.deletePrestamo(id);
        return "redirect:/prestamos";
    }
    
}
