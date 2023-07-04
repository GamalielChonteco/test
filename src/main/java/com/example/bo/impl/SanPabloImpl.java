package com.example.bo.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.bo.ISanPablo;
import com.example.dto.Response;
import com.example.dto.UsuariosResponseDto;

@Service
@Primary
public class SanPabloImpl implements ISanPablo {

	@Override
	public String pruebaUno() throws Exception {
		String resp = "Desde sanpakk";
		return resp;
	}

	@Override
	public Response covertToSeconds(int minuto) throws Exception {

		Response response = new Response();

		int segundos = minuto * 60;

		int max = 100;
		int min = 0;

		if (minuto < min || max > 100) {
			response.setMessage("No se pudo obtener los segundos");

			return response;
		}

		response.setMessage("Total de segundos " + segundos);
		response.setData(segundos);
		return response;
	}

	@Override
	public UsuariosResponseDto getUsuarios(int page) throws Exception {
		return null;
	}
}
