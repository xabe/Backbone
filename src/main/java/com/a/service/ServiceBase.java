package com.a.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.a.persistence.PaginationContext;
import com.a.service.ServiceBase;
import com.a.model.EntityBase;
import com.a.model.ExampleBase;
import com.a.service.ServiceBase;

public interface ServiceBase<T extends EntityBase, D extends ExampleBase> {
	public static final Logger LOGGER = LoggerFactory.getLogger(ServiceBase.class);

	void add(T t);

	void update(T t);
	
	void update(T t,D d);

	void delete(T t);
	
	void delete(D d);

	List<T> getAll();
	
	List<T> getAll(D d);
	
	List<T> getPaginated(D example,PaginationContext paginationContext);
}