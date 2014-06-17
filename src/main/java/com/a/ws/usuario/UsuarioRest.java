package com.a.ws.usuario;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.a.model.Message;
import com.a.model.usuario.Usuario;
import com.a.model.usuario.UsuarioExample;
import com.a.persistence.PaginationContext;
import com.a.service.usuario.UsuarioService;
import com.a.ws.BaseRest;

@Path("/usuario")
@Component
@Scope(value = "request")
public class UsuarioRest extends BaseRest {

	@Autowired
	private UsuarioService service;

	@GET
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getId(@DefaultValue("1") @PathParam("Id") Integer Id) {
		UsuarioExample example = new UsuarioExample();
		example.createCriteria().andIdEqualTo(Id);
		return service.getAll(example);
	}

	@GET
	@Path("/pagination")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getCursosPagination(
			@DefaultValue("0") @QueryParam("frist") Integer first,
			@DefaultValue("10") @QueryParam("pageSize") Integer pageSize,
			@DefaultValue("id") @QueryParam("sortField") String sortField,
			@DefaultValue("ASC") @QueryParam("sortOrder") String sortOrder) {

		UsuarioExample example = new UsuarioExample();
		if (sortField != null) {
			example.setOrderByClause(sortField + " " + sortOrder);
		}
		PaginationContext paginationContext = new PaginationContext();
		paginationContext.setSkipResults(first);
		paginationContext.setMaxResults(pageSize);
		return service.getPaginated(example, paginationContext);
	}

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getAll(
			@DefaultValue("id") @QueryParam("sortField") String sortField,
			@DefaultValue("ASC") @QueryParam("sortOrder") String sortOrder) {

		UsuarioExample example = new UsuarioExample();
		if (sortField != null) {
			example.setOrderByClause(sortField + " " + sortOrder);
		}
		return service.getAll(example);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(Usuario entity) {
		Response response = null;
		try {
			service.add(entity);
			String location = String.format("%s%s", uriInfo.getAbsolutePath()
					.toString(), entity.getId());
			Message message = new Message();
			message.setMessage("Creado");
			response = Response.created(new URI(location)).entity(message)
					.build();
		} catch (URISyntaxException e) {
			logger.error("Error al añadir una prueba " + e.getMessage());
			response = Response.status(500).entity(e.getMessage()).build();
		}
		return response;
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(Usuario entity) {
		Response response = null;
		try {
			service.update(entity);
			Message message = new Message();
			message.setMessage("Modificado");
			response = Response.accepted().entity(message).build();
		} catch (Exception e) {
			logger.error("Error al actulizar una prueba " + e.getMessage());
			response = Response.status(500).entity(e.getMessage()).build();
		}
		return response;
	}

	@PUT
	@Path("/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteId(Usuario entity) {
		Response response = null;
		try {
			service.delete(entity);
			Message message = new Message();
			message.setMessage("Borrado");
			response = Response.accepted().entity(message).build();
		} catch (Exception e) {
			logger.error("Error al borrar una prueba " + e.getMessage());
			response = Response.status(500).entity(e.getMessage()).build();
		}
		return response;
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(Usuario entity) {
		Response response = null;
		try {
			service.delete(entity);
			Message message = new Message();
			message.setMessage("Borrado");
			response = Response.accepted().entity(message).build();
		} catch (Exception e) {
			logger.error("Error al borrar una prueba " + e.getMessage());
			response = Response.status(500).entity(e.getMessage()).build();
		}
		return response;
	}

	@DELETE
	@Path("/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteId(@DefaultValue("1") @PathParam("Id") Integer Id) {
		Response response = null;
		try {
			Usuario entity = new Usuario();
			entity.setId(Id);
			service.delete(entity);
			Message message = new Message();
			message.setMessage("Borrado");
			response = Response.accepted().entity(message).build();
		} catch (Exception e) {
			logger.error("Error al borrar una prueba " + e.getMessage());
			response = Response.status(500).entity(e.getMessage()).build();
		}
		return response;
	}

}