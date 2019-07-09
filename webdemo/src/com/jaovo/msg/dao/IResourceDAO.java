package com.jaovo.msg.dao;

import java.util.List;

import com.jaovo.msg.model.Resource;;

public interface IResourceDAO {
   
	public void add(Resource resource);

    public void delete(int id);

    public void update(Resource resource);

    public Resource load(int id);

    public Resource loadByResname(String resourcename);

    public List<Resource> loadAll(); 
}