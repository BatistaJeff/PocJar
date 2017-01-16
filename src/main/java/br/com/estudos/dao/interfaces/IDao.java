package br.com.estudos.dao.interfaces;

import java.util.List;

public interface IDao<T> {

	void insert(T t) throws Exception;
	void update(T t) throws Exception;
	void delete(Integer id) throws Exception;
	List<T> listAll() throws Exception;
	
}
