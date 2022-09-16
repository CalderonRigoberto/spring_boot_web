package com.rcalderon.spring_boot_web.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rcalderon.spring_boot_web.models.Usuario;

@Controller
@RequestMapping(value = "/v.1.0")
public class IndexController {

    // Empaquetar .\mvnw.cmd package
    // Notación para utilizar configuración de application.properties

    // redirect hace que te direccione a una ruta que desees y reinicia
    // redirect:https redirige a las paginas

    // forward no reinicia, rutas propias del proyecto
    // ejecutar un request dispatcher del
    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    /**
     * Para hacer que un metodo dentro de un controlador apunte a varias rutas
     * dentro de los parametros de las annotaciones get,post,put,delete-mapping,
     * etc.
     * Puedes hacerlo con curlys "{"/index", "/", "/home"}"
     */
    @GetMapping({ "/index", "/home" })
    public ModelAndView index(ModelAndView model) {
        /**
         * Model -> Interface
         * ModelMap -> Clase
         * Map-> Clase
         * Se pueden pasar los atributos de la misma manera
         * ModelAndView asignas el objeto y atributo y añades la vista
         */
        // model.addAttribute("titulo", "Hola spring framework");

        model.addObject("titulo", "Hola programador" + textoIndex);
        model.setViewName("index");
        return model;
    }

    @PostMapping(value = "/index/registry")
    public String indexRegistry(String value) {
        if (!value.equals(""))
            return "Registro exitoso";
        else
            return "";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model) {
        Usuario usuario = new Usuario();
        usuario.setNombre("Rigoberto");
        usuario.setApellido("Calderon");
        usuario.setEmail("rigoberto@gmail.com");
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping("/listar")
    public ModelAndView listar(ModelAndView model) {

        model.addObject("titulo", "Listado de usuarios");

        model.setViewName("listar");
        return model;
    }

    /// Anotación para crear un método que se pase como un atributo del modelo
    @ModelAttribute("usuarios")
    public List<Usuario> getUsers() {
        List<Usuario> usauriosList = new ArrayList<>();
        usauriosList.add(new Usuario("Rigoberto", "Calderon", "email@example"));
        usauriosList.add(new Usuario("Rigoberto", "Calderon", "email@example"));
        usauriosList.add(new Usuario("Rigoberto", "Calderon", "email@example"));
        return usauriosList;
    }

}
