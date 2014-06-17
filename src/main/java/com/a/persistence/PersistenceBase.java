package com.a.persistence;

import java.util.List;

import com.a.model.EntityBase;
import com.a.model.ExampleBase;

public interface PersistenceBase <T extends EntityBase, D extends ExampleBase> {

	void deleteAllData();
	
	List<T> selectByExamplePagination(D example);
}