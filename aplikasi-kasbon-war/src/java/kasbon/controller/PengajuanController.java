/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.controller;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import kasbon.entity.Karyawan;
import kasbon.entity.Pengajuan;
import kasbon.service.AplikasiKasbonService;

/**
 *
 * @author endy
 */
@ManagedBean
@SessionScoped
public class PengajuanController {
    @EJB
    private AplikasiKasbonService aplikasiKasbonService;

    private List<Karyawan> daftarKaryawan;
    private List<Pengajuan> daftarPengajuan;
    private Pengajuan pengajuan = new Pengajuan();
    private Date mulai;
    private Date sampai;

    public List<Karyawan> getDaftarKaryawan() {
        if(daftarKaryawan == null){
            daftarKaryawan = aplikasiKasbonService.findAllKaryawan();
        }
        return daftarKaryawan;
    }
    
    public String cari(){
        if(mulai != null && sampai != null){
            daftarPengajuan = aplikasiKasbonService.findAllPengajuan(mulai, sampai);
        } else {
            daftarPengajuan = aplikasiKasbonService.findAllPengajuan();
        }
        
        return "list?faces-redirect=true";
    }
    
    public String simpan(){
        aplikasiKasbonService.simpan(pengajuan);
        pengajuan = new Pengajuan();
        return "form?faces-redirect=true";
    }

    public List<Pengajuan> getDaftarPengajuan() {
        if(daftarPengajuan == null){
            daftarPengajuan = aplikasiKasbonService.findAllPengajuan();
        }
        return daftarPengajuan;
    }

    public Pengajuan getPengajuan() {
        return pengajuan;
    }

    public void setPengajuan(Pengajuan pengajuan) {
        this.pengajuan = pengajuan;
    }

    public Date getMulai() {
        return mulai;
    }

    public void setMulai(Date mulai) {
        this.mulai = mulai;
    }

    public Date getSampai() {
        return sampai;
    }

    public void setSampai(Date sampai) {
        this.sampai = sampai;
    }
    
    /** Creates a new instance of PengajuanController */
    public PengajuanController() {
    }
}
