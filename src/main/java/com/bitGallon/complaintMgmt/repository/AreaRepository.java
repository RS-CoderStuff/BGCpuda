package com.bitGallon.complaintMgmt.repository;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bitGallon.complaintMgmt.entity.Area;

@Repository
@Transactional
public class AreaRepository  {
	
	@Autowired
	private SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public Area getArea(String areaName) {
		List<Area> arealist = getSession()
				.createQuery("FROM Area a WHERE a.name =:p1")
				.setParameter("p1", areaName).list();
		if(arealist.size() != 0) {
			return arealist.get(0);
		}
		return null;
	}
}
