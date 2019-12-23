package com.btpns.training.latihan3.dao;

import com.btpns.training.latihan3.entity.RoleEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }
    @Override
    public RoleEntity findById(int roleID) {
        return (RoleEntity) this.getSession().createQuery("from RoleEntity where roleId= :idRole")
                .setParameter("idRole", roleID).uniqueResult();
    }

    @Override
    public RoleEntity findByName(String roleName) {
        return (RoleEntity) this.getSession().createQuery("from RoleEntity where roleName= :nameRole")
                .setParameter("nameRole",roleName).uniqueResult();
    }

    @Override
    public void insertRole(RoleEntity roleEntity) {
        this.getSession().save(roleEntity);
    }
}
