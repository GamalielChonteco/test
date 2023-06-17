package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MateriaDTO;
import com.example.dto.Response;

@RestController
public class EndpointMateria {

	private Response response = new Response();

	@GetMapping("v1/test")
	public Response obtenerMateria(@RequestBody MateriaDTO materia) {
		System.out.println("Aquí");
		try {
			response.setMateria(materia);
			if (materia.getNombre().isEmpty()) {
				response.setMessage("Pon el nombre imbecil");
			}

			return response;
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@RequestMapping(value = "v1/palabra", method = { RequestMethod.GET })
	public String test() {
		return "OKi doki";
	}
}
