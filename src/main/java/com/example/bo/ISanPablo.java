package com.example.bo;

import com.example.dto.Response;
import com.example.dto.UsuariosResponseDto;

public interface ISanPablo {
	
	public String pruebaUno() throws Exception;

	public Response covertToSeconds(int minuto) throws Exception;

	public UsuariosResponseDto getUsuarios(int page) throws Exception;

}
