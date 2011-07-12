/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author endy
 */
@Entity
public class Persetujuan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne
    @JoinColumn(name="id_pengajuan", nullable=false)
    private Pengajuan pengajuan;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="waktu_persetujuan", nullable=false)
    private Date waktuPersetujuan = new Date();
    
    @ManyToOne
    @JoinColumn(name="id_approver", nullable=false)
    private Karyawan disetujuiOleh;
    
    @Column(name="nilai_disetujui", nullable=false)
    private BigDecimal nilaiDisetujui;

    public Karyawan getDisetujuiOleh() {
        return disetujuiOleh;
    }

    public void setDisetujuiOleh(Karyawan disetujuiOleh) {
        this.disetujuiOleh = disetujuiOleh;
    }

    public BigDecimal getNilaiDisetujui() {
        return nilaiDisetujui;
    }

    public void setNilaiDisetujui(BigDecimal nilaiDisetujui) {
        this.nilaiDisetujui = nilaiDisetujui;
    }

    public Pengajuan getPengajuan() {
        return pengajuan;
    }

    public void setPengajuan(Pengajuan pengajuan) {
        this.pengajuan = pengajuan;
    }

    public Date getWaktuPersetujuan() {
        return waktuPersetujuan;
    }

    public void setWaktuPersetujuan(Date waktuPersetujuan) {
        this.waktuPersetujuan = waktuPersetujuan;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persetujuan)) {
            return false;
        }
        Persetujuan other = (Persetujuan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasbon.entity.Persetujuan[ id=" + id + " ]";
    }
    
}
