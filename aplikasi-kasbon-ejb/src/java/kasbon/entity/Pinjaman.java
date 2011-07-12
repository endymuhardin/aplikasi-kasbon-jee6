/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author endy
 */
@Entity
public class Pinjaman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne @JoinColumn(name="id_peminjam", nullable=false)
    private Karyawan peminjam;
    
    @OneToOne @JoinColumn(name="id_persetujuan", nullable=false)
    private Persetujuan persetujuan;
    
    @Column(nullable=false)
    private BigDecimal nilai;
    
    @Enumerated(EnumType.STRING)
    @Column(name="status_pinjaman", nullable=false)
    private StatusPinjaman statusPinjaman = StatusPinjaman.DISETUJUI;
    
    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Karyawan getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(Karyawan peminjam) {
        this.peminjam = peminjam;
    }

    public Persetujuan getPersetujuan() {
        return persetujuan;
    }

    public void setPersetujuan(Persetujuan persetujuan) {
        this.persetujuan = persetujuan;
    }

    public StatusPinjaman getStatusPinjaman() {
        return statusPinjaman;
    }

    public void setStatusPinjaman(StatusPinjaman statusPinjaman) {
        this.statusPinjaman = statusPinjaman;
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
        if (!(object instanceof Pinjaman)) {
            return false;
        }
        Pinjaman other = (Pinjaman) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasbon.entity.Pinjaman[ id=" + id + " ]";
    }
    
}
