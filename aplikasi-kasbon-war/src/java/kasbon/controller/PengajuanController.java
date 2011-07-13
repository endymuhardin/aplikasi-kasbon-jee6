/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import kasbon.entity.Karyawan;
import kasbon.entity.Pengajuan;
import kasbon.service.AplikasiKasbonService;

/**
 *
 * @author endy
 */
@ManagedBean
@RequestScoped
public class PengajuanController {
    @EJB
    private AplikasiKasbonService aplikasiKasbonService;

    private List<Karyawan> daftarKaryawan;
    private List<Pengajuan> daftarPengajuan;
    private Pengajuan pengajuan = new Pengajuan();

    public List<Karyawan> getDaftarKaryawan() {
        if(daftarKaryawan == null){
            daftarKaryawan = aplikasiKasbonService.findAllKaryawan();
        }
        return daftarKaryawan;
    }
    
    public String simpan(){
        aplikasiKasbonService.simpan(pengajuan);
        pengajuan = new Pengajuan();
        return "form?faces-redirect=true";
    }

    public List<Pengajuan> getDaftarPengajuan() {
        if(daftarPengajuan == null){
            daftarPengajuan = new ArrayList<Pengajuan>();
        }
        return daftarPengajuan;
    }

    public Pengajuan getPengajuan() {
        return pengajuan;
    }

    public void setPengajuan(Pengajuan pengajuan) {
        this.pengajuan = pengajuan;
    }
    
    /** Creates a new instance of PengajuanController */
    public PengajuanController() {
    }
}
