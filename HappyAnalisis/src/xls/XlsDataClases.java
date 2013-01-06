package xls;

import java.util.ArrayList;
import java.util.List;

public class XlsDataClases extends XlsData implements IEstructuraMarcaVenta {

    public XlsDataClases() {
        MAXCOLRANGE = 10;
        _datos = new ArrayList(MAXCOLRANGE);
        NUMBERCOL = 1;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof XlsDataClases)) {
            XlsDataClases foo = (XlsDataClases) obj;
            return (get(0).equals(foo.get(0)));
        }
        return false;
    }

    @Override
    public String getEstructura() {
        try {
            return (String) this._datos.get(0);
        } catch (IndexOutOfBoundsException iobe) {
        }
        return "";
    }

    @Override
    public String getMarca() {
        throw new UnsupportedOperationException("Not supported in this Class.");
    }

    @Override
    public String getTy() {
        return (String) this._datos.get(1);
    }

    @Override
    public String getLy() {
        return (String) this._datos.get(2);
    }

    @Override
    public String getVar() {
        return (String) this._datos.get(3);
    }

    @Override
    public int compareTo(IEstructuraMarcaVenta o) {
        /*if(this.get(1).isEmpty()){
         return 1;
         }*/
        return this.get(0).compareTo(o.get(0));
    }
    
    public int compareTo(XlsDataClases o) {
        /*if(this.get(1).isEmpty()){
         return 1;
         }*/
        return this.get(0).compareTo(o.get(0));
    }

    @Override
    public int hashCode() {
        String hash = get(0);
        return hash.trim().hashCode();
    }
    
}
