package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Usuario;
import uniandes.edu.co.proyecto.repositorio.UsuarioRepository;

import org.springframework.ui.Model;

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/usuarios")
    public String usuario(Model model) {
        model.addAttribute( "usuarios", usuarioRepository.findAll());
        return "usuarios";
    }

    @GetMapping("/usuarios/new")
    public String usuarioNew(Model model) {
        model.addAttribute( "usuario", new Usuario());
        return "usuariosNew";
    }

    // @PostMapping("/usuarios/new/save")
    // public String usuarioNewSave(@ModelAttribute Usuario usuario) {

        /*
         * aclarar con el grupo tipo de rol o si es solo rol
         */
    //     usuarioRepository.insertUsuario(usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), 
    //                                     usuario.getEmail(), usuario.getTipoDocumento(), usuario.getRol());
    //     return "redirect:/usuarios";
    // }

    @GetMapping("/usuarios/{id}/edit")
    public String usuarioEdit(@PathVariable("documento") String documento,Model model) {
        Usuario usuario = usuarioRepository.findUsuarioById(documento);
        if (usuario != null){
            model.addAttribute( "usuario", usuario);
            return "usuariosEdit";
        } else {
            return "redirect:/usuarios";
        }
    }

    // @PostMapping("/usuarios/{id}/edit/save")
    // public String usuarioEditSave(@PathVariable("documento") String documento, @ModelAttribute Usuario usuario) {
    //     usuarioRepository.updateUsuario(documento, usuario.getNombre(), usuario.getApellido(), usuario.getEdad(), 
    //                                     usuario.getEmail(), usuario.getTipoDocumento(), usuario.getRol());
    //     return "redirect:/usuarios";
    // }

    @GetMapping("/usuarios/{id}/delete")
    public String usuarioDelete(@PathVariable("documento") String documento) {
        usuarioRepository.deleteUsuario(documento);
        return "redirect:/usuarios";
    }
    

}
