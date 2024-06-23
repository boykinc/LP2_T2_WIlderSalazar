package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;



@Controller
public class EmpleadoController {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private AreaRepository areaRepository;

	@GetMapping("/listar")
	public String home(Model model) {
		List<EmpleadoEntity> listaEmpleado = empleadoRepository.findAll();
		model.addAttribute("listaEmpleado",listaEmpleado);
		return "home";
	}
	
	@GetMapping("/registrarEmpleado")
	public String showRegistraEmpleado(Model model) {
		List<AreaEntity> listaAreas = areaRepository.findAll();
		model.addAttribute("listaAreas" ,listaAreas);
		model.addAttribute("empleado", new EmpleadoEntity());
		return "registrarEmpleado";
	}
	
	@PostMapping("/registrarEmpleado")
	public String RegistrarEmpleado(Model model , @ModelAttribute EmpleadoEntity empleado) {
		empleadoRepository.save(empleado);
		model.addAttribute("empleCorrecto", "Registro Correcto");
		return "redirect:/listar";
	}
	
	  @GetMapping("/actualizarEmpleado/{id}")
	    public String showActualizarEmpleado(Model model, @PathVariable("id") String id) {
	        EmpleadoEntity empleadoEncontrado = empleadoRepository.findById(id).get();
	        List<AreaEntity> listaAreas = areaRepository.findAll();
	        model.addAttribute("listaAreas", listaAreas);
	        model.addAttribute("emple", empleadoEncontrado);
	        return "actualizarEmpleado";
	    }

	    @PostMapping("/actualizarEmpleado/{id}")
	    public String actualizarEmpleado(Model model ,@ModelAttribute EmpleadoEntity empleado) {
	        empleadoRepository.save(empleado);
	        return "redirect:/listar";
	    }
	
	@GetMapping("/detalleEmpleado/{dni}")
	public String verEmpleado(Model model , @PathVariable("dni")String dni) {
		List<AreaEntity> listaAreas = areaRepository.findAll();
		EmpleadoEntity empleadoEncontrado = empleadoRepository.findByDniEmple(dni);
		 model.addAttribute("emple",empleadoEncontrado);
		return "detalleEmpleado";
	}
	
	//Eliminar
    @GetMapping("/eliminarEmpleado/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadoRepository.deleteById(dni);
        return "redirect:/listar";
    }
}
