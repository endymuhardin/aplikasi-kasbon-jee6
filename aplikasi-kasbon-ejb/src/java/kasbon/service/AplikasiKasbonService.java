/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.service;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import kasbon.entity.Karyawan;
import kasbon.entity.Pengajuan;

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
        if(karyawan.getId() == null){
            em.persist(karyawan);
        } else {
            em.merge(karyawan);
        }
    }

    public Karyawan findKaryawanById(Long id){
        return em.find(Karyawan.class, id);
    }
    
    public List<Karyawan> findAllKaryawan(){
        return em.createQuery("select k from Karyawan k order by k.nip")
                .getResultList();
    }
    
    public List<Karyawan> findAllKaryawan(Integer start, Integer rows){
        return em.createQuery("select k from Karyawan k order by k.nip")
                .setFirstResult(start)
                .setMaxResults(rows)
                .getResultList();
    }
    
    public Long countAllKaryawan(){
        return (Long) em.createQuery("select count(k) from Karyawan k ")
                .getSingleResult();
    }
    
    public List<Karyawan> findKaryawanByNama(String nama){
        return em.createQuery("select k from Karyawan k "
                + "where k.nama like :nama "
                + "order by k.nip")
                .setParameter("nama", "%"+nama+"%")
                .getResultList();
    }

    public void simpan(Pengajuan pengajuan) {
        if(pengajuan.getId() == null){
            em.persist(pengajuan);
        } else {
            em.merge(pengajuan);
        }
    }

    public List<Pengajuan> findAllPengajuan() {
        return em.createQuery("select p from Pengajuan p "
                + "order by p.waktuPengajuan")
                .getResultList();
    }

    public List<Pengajuan> findAllPengajuan(Date mulai, Date sampai) {
        return em.createQuery("select p from Pengajuan p "
                + " where p.waktuPengajuan between :mulai and :sampai "
                + " order by p.waktuPengajuan")
                .setParameter("mulai", mulai)
                .setParameter("sampai", sampai)
                .getResultList();
    }
}
