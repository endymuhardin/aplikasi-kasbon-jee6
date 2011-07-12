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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author endy
 */
@Entity
public class Pembayaran implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @ManyToOne @JoinColumn(name="id_pinjaman", nullable=false)
    private Pinjaman pinjaman;
    
    @ManyToOne @JoinColumn(name="id_kasir", nullable=false)
    private Karyawan kasir;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="waktu_pembayaran", nullable=false)
    private Date waktuPembayaran = new Date();
    
    @Column(nullable=false)
    private BigDecimal nilai;

    public Karyawan getKasir() {
        return kasir;
    }

    public void setKasir(Karyawan kasir) {
        this.kasir = kasir;
    }

    public BigDecimal getNilai() {
        return nilai;
    }

    public void setNilai(BigDecimal nilai) {
        this.nilai = nilai;
    }

    public Pinjaman getPinjaman() {
        return pinjaman;
    }

    public void setPinjaman(Pinjaman pinjaman) {
        this.pinjaman = pinjaman;
    }

    public Date getWaktuPembayaran() {
        return waktuPembayaran;
    }

    public void setWaktuPembayaran(Date waktuPembayaran) {
        this.waktuPembayaran = waktuPembayaran;
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
        if (!(object instanceof Pembayaran)) {
            return false;
        }
        Pembayaran other = (Pembayaran) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "kasbon.entity.Pembayaran[ id=" + id + " ]";
    }
    
}
