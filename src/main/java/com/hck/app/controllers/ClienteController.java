package com.hck.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hck.app.models.entity.Cliente;
import com.hck.app.models.service.IClienteService;
import com.hck.app.util.paginator.PageRender;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@RequestMapping(value="/index" , method=RequestMethod.GET)
	public String index(@RequestParam(name="page", defaultValue="0") int page,  Model model) {
		
		Pageable pageRequest = new PageRequest(page, 4);

		Page<Cliente> clientes = clienteService.findAll(pageRequest);
		
		PageRender<Cliente> pageRender = new PageRender<Cliente>("/index", clientes);
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clientes);
		model.addAttribute("page", pageRender);
		return "index";
	}
	
	
	@GetMapping(value = "/detalle-cliente/{id}")
	public String ver(@PathVariable(value = "id") Long id, Map<String, Object> model, RedirectAttributes flash) {

		Cliente cliente = clienteService.findOne(id);
		if (cliente == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/listar";
		}

		model.put("cliente", cliente);
		model.put("titulo", "Detalle cliente: " + cliente.getNombre());
		return "ver";
	}
	
	
	
	@RequestMapping(value="/form")
	public String crear(Map<String, Object> model ) {
		
		Cliente cliente = new Cliente();
		model.put("cliente", cliente);
		model.put("titulo", "Formulario para insertar");
		return "form";
	}
	
	
	@RequestMapping(value="/form", method=RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, RedirectAttributes flash ) {
		
		if(result.hasErrors()) {
			return "form";
		}
		
		clienteService.save(cliente);
		flash.addFlashAttribute("success", "Registro creado exitosamnete");
		return "redirect:index";
	}
	
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model, RedirectAttributes flash ) {
		
		Cliente cliente = null;
		
		if(id > 0) {
			flash.addFlashAttribute("info", "Registro editado correctamente");
			cliente = clienteService.finOne(id);
		}else {
			flash.addFlashAttribute("error", "Error al editar el registro");
			return "redirect:index";
		}
		
		model.put("cliente", cliente);
		model.put("titulo", "Editar cliente");
		return "form";
	}
	
	@RequestMapping(value="/index/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			clienteService.eliminar(id);
		}

		return "redirect:/index";
	}
	
}