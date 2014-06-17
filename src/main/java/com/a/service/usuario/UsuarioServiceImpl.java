package com.a.service.usuario;

			
			
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.usuario.Usuario;
import com.a.persistence.usuario.UsuarioMapper;
import com.a.persistence.PaginationContext;
import com.a.model.usuario.UsuarioExample;

 
@Service("usuarioService")
@Transactional(readOnly = true, isolation=Isolation.READ_COMMITTED)
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void add(Usuario aUsuario) {
		usuarioMapper.insert(aUsuario);
	}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void update(Usuario aUsuario) {
					usuarioMapper.updateByPrimaryKey(aUsuario);
			}
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void update(Usuario aUsuario, UsuarioExample aUsuarioExample) {
					usuarioMapper.updateByExample(aUsuario, aUsuarioExample);
			}

		@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void delete(Usuario aUsuario) {
					UsuarioExample aUsuarioExample = new UsuarioExample();
			aUsuarioExample.createCriteria().andIdEqualTo(aUsuario.getId());
			usuarioMapper.deleteByExample(aUsuarioExample);
			}
		
	
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED)
	public void delete(UsuarioExample aUsuarioExample) {
					usuarioMapper.deleteByExample(aUsuarioExample);
			}

	public List<Usuario> getAll() {		
		return usuarioMapper.selectByExample(new UsuarioExample());
	}

	public List<Usuario> getAll(UsuarioExample aUsuarioExample) {		
		return usuarioMapper.selectByExample(aUsuarioExample);
	}
	
	public List<Usuario> getPaginated(UsuarioExample example,PaginationContext paginationContext) {
		int page = paginationContext.getCurrentPage();
		if(page < 1)
		{
			page = 1;
		}
		paginationContext.setSkipResults(paginationContext.getMaxResults() * (page - 1));
		paginationContext.updateTotalCount(usuarioMapper.countByExample(example));
		example.setLimit(paginationContext.getSkipResults() + paginationContext.getMaxResults());
		example.setOffset(paginationContext.getSkipResults());
		return  usuarioMapper.selectByExamplePagination(example);
	}
}
	