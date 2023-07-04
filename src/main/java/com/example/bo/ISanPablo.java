package com.example.bo;

import java.util.List;

import com.example.dto.PostDto;
import com.example.dto.Response;
import com.example.dto.UsuariosResponseDto;

public interface ISanPablo {
	
	public String pruebaUno() throws Exception;

	public Response covertToSeconds(int minuto) throws Exception;

	public UsuariosResponseDto getUsuarios(int page) throws Exception;

	public List<PostDto> obtenerPostsById(int id) throws Exception;
}
