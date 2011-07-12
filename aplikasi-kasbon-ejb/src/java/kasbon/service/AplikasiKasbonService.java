/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.service;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasbon.entity.Karyawan;

/**
 *
 * @author endy
 */
@Stateless
@LocalBean
public class AplikasiKasbonService {
    @PersistenceContext(unitName = "aplikasi-kasbon-ejbPU")
    private EntityManager em;
    
    public void simpan(Karyawan karyawan) {
        em.persist(karyawan);
    }

}
