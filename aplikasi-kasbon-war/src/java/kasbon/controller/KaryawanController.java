/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.controller;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import kasbon.entity.Karyawan;
import kasbon.service.AplikasiKasbonService;

/**
 *
 * @author endy
 */
@ManagedBean
@RequestScoped
public class KaryawanController {
    @EJB
    private AplikasiKasbonService aplikasiKasbonService;
    
    private Karyawan karyawan = new Karyawan();

    public String simpan(){
        aplikasiKasbonService.simpan(karyawan);
        
        // reset, supaya bisa dipakai insert lagi
        karyawan = new Karyawan();
        
        return "form?faces-redirect=true";
    }
    
    public Karyawan getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    public KaryawanController() {
    }
}
