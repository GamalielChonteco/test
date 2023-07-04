package com.example.bo.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.bo.ISanPablo;
import com.example.dto.PostDto;
import com.example.dto.Response;
import com.example.dto.UsuariosResponseDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

@Service
@Component("zimatopes")
public class ZimatopesImpl implements ISanPablo {

	public Logger log = Logger.getLogger(ZimatopesImpl.class);

    @Override
	public String pruebaUno() throws Exception {
		String resp = "Desde zimatopes";
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

		UsuariosResponseDto usuariosDto = new UsuariosResponseDto();

		try {
			HttpResponse<String> response = Unirest.get("https://reqres.in/api/users")
													.header("Content-Type", "application/json")
													.queryString("page", page)
													.asString();

			ObjectMapper objectMapper = new ObjectMapper();
			UsuariosResponseDto users = objectMapper.readValue(response.getBody(), UsuariosResponseDto.class);

			usuariosDto = users;

			// usuariosDto.setPage(jsonNode.get("page").asInt());
			// usuariosDto.setPerPage(jsonNode.get("per_page").asInt());
			// usuariosDto.setTotal(jsonNode.get("total").asInt());
			// usuariosDto.setTotalPages(jsonNode.get("total_pages").asInt());

			// JsonNode data = jsonNode.get("data");

			// ArrayList<UsuarioDto> usuariosData = new ArrayList<UsuarioDto>();

			// for (JsonNode usuario : data) {
			// 	UsuarioDto usuarioDto = new UsuarioDto();

			// 	usuarioDto.setId(usuario.get("id").asInt());
			// 	usuarioDto.setAvatar(usuario.get("avatar").asText());
			// 	usuarioDto.setEmail(usuario.get("email").asText());
			// 	usuarioDto.setFirstName(usuario.get("first_name").asText());
			// 	usuarioDto.setLastName(usuario.get("last_name").asText());

			// 	usuariosData.add(usuarioDto);
			// }

			// usuariosDto.setData(usuariosData);

			// JsonNode supportNode = jsonNode.get("support");

			// SupportDto supportDto = new SupportDto();

			// supportDto.setText(supportNode.get("text").asText());
			// supportDto.setUrl(supportNode.get("url").asText());

			// usuariosDto.setSupport(supportDto);

			log.info("RESPUESTA DEL SERVICIO: " + response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.warn("UsuariosResponseDto", e);
		}

		return usuariosDto;
	}

	@Override
	public List<PostDto> obtenerPostsById(int id) throws Exception {
		List<PostDto> postsDto = new ArrayList<PostDto>();

		try {
			HttpResponse<String> response = Unirest.get("https://jsonplaceholder.typicode.com/comments")
											.header("Content-Type", "application/json")
											.queryString("postId", id)
											.asString();

			ObjectMapper mapper = new ObjectMapper();
			List<PostDto> listResp = mapper.readValue(response.getBody(), new TypeReference<List<PostDto>>(){});

			postsDto = listResp;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			log.warn("obtenerPostsById", e);
		}

		return postsDto;
	}
}
