package org.ithinking.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T, ID extends Serializable> {

	public T get(ID id);

	public <S extends T> S save(T t);

	public int update(T t);

	public int delete(ID id);
	
	public List<T> getAll();
}
