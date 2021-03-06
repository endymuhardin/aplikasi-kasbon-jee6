/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.controller;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import kasbon.entity.Karyawan;
import kasbon.service.AplikasiKasbonService;

/**
 *
 * @author endy
 */
@ManagedBean
@SessionScoped
public class KaryawanController {
    @EJB
    private AplikasiKasbonService aplikasiKasbonService;
    
    private Karyawan karyawan = new Karyawan();

    private List<Karyawan> daftarKaryawan;
    private DataModel<Karyawan> listDataModelKaryawan;
    
    
    public String simpan(){
        aplikasiKasbonService.simpan(karyawan);
        
        // reset, supaya bisa dipakai insert lagi
        karyawan = new Karyawan();
        
        // query ulang dari database
        refreshListKaryawan();
        return "list?faces-redirect=true";
    }
    
    public String create(){
        karyawan = new Karyawan();
        return "form?faces-redirect=true";
    }
    
    public String edit(){
        karyawan = listDataModelKaryawan.getRowData();
        return "form?faces-redirect=true";
    }
    
    public List<Karyawan> getDaftarKaryawan() {
        if(daftarKaryawan == null) {
            // isi daftar karyawan dari database
            daftarKaryawan = aplikasiKasbonService.findAllKaryawan();
        }
        return daftarKaryawan;
    }

    public DataModel<Karyawan> getListDataModelKaryawan() {
        if(listDataModelKaryawan == null) {
            listDataModelKaryawan = new ListDataModel<Karyawan>(getDaftarKaryawan());
        }
        return listDataModelKaryawan;
    }
    
    private void refreshListKaryawan(){
        daftarKaryawan = aplikasiKasbonService.findAllKaryawan();
        listDataModelKaryawan = new ListDataModel<Karyawan>(getDaftarKaryawan());
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
