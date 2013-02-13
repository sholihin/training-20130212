/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artivisi.training.dao;

import com.artivisi.training.domain.Produk;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author endy
 */
@Repository
@Transactional
public class ProdukDao {
    @PersistenceContext 
    private EntityManager entityManager;
    
    public void simpan(Produk p) throws Exception {
        entityManager.persist(p);
    }
    
    public void hapus(Produk p) throws Exception {
        entityManager.remove(p);
    }
    
    public Produk cariById(Integer id){
        return null;
    }
}
