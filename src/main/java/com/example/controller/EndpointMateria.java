package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bo.ISanPablo;
import com.example.dto.MateriaDTO;
import com.example.dto.PostDto;
import com.example.dto.Response;
import com.example.dto.UsuariosResponseDto;

@RestController
public class EndpointMateria {

	// TODO: https://jsonplaceholder.typicode.com/comments?postId=1

	@Qualifier("zimatopes")
	@Autowired
	ISanPablo iSanPablo;
	private Response response = new Response();

	@GetMapping("v1/test")
	public Response obtenerMateria(@RequestBody MateriaDTO materia) {
		try {
			response.setData(materia);
			if (materia.getNombre().isEmpty()) {
				response.setMessage("Pon el nombre imbecil");
			}

			return response;
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@GetMapping("v1/pruebaDo")
	public Response testDao(@RequestParam int minutos) {
		try {
			response = iSanPablo.covertToSeconds(minutos);
			
			return response;
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@PostMapping("v1/agregar")
	public Response agregarMateria(@RequestBody MateriaDTO materia) {
		response.setData(materia);
		try {
			if (materia.getNombre() == "") {
				response.setMessage("Agrega nombre imbecil");
				return response;
			}
			return response;
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			return response;
		}
	}

	@GetMapping("v1/obtenerUsuarios")
	public UsuariosResponseDto obtenerUsuarios(@RequestParam int page) {
		UsuariosResponseDto usuariosResponseDto = new UsuariosResponseDto();

		try {
			usuariosResponseDto = iSanPablo.getUsuarios(page);
		} catch (Exception e) {
			
		}

		return usuariosResponseDto;
	}

	@GetMapping("v1/post/obtenerPost")
	public List<PostDto> obtenerPost(@RequestParam int postId) {
		List<PostDto> postsDto = new ArrayList<PostDto>();

		try {
			postsDto = iSanPablo.obtenerPostsById(postId);
		} catch (Exception e) {
			
		}

		return postsDto;
	}
}
