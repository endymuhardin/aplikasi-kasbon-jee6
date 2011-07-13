/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kasbon.converter;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import kasbon.entity.Karyawan;
import kasbon.service.AplikasiKasbonService;

/**
 *
 * @author endy
 */
@FacesConverter(forClass = Karyawan.class)
public class KaryawanConverter implements Converter {
    AplikasiKasbonService aplikasiKasbonService = lookupAplikasiKasbonServiceBean();
    

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        // Convert the object to its unique String representation.
        return String.valueOf(((Karyawan) value).getId());
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return aplikasiKasbonService.findKaryawanById(Long.valueOf(value));
    }

    private AplikasiKasbonService lookupAplikasiKasbonServiceBean() {
        try {
            Context c = new InitialContext();
            return (AplikasiKasbonService) c.lookup("java:global/aplikasi-kasbon/aplikasi-kasbon-ejb/AplikasiKasbonService!kasbon.service.AplikasiKasbonService");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    
}
