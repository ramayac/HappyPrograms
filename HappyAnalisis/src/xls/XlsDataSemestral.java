package xls;

import java.util.ArrayList;
import java.util.List;

public class XlsDataSemestral extends XlsData implements IEstructuraMarcaVenta {

    public XlsDataSemestral() {
        MAXCOLRANGE = 10;
        _datos = new ArrayList(MAXCOLRANGE);
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
        try {
            return (String) this._datos.get(1);
        } catch (IndexOutOfBoundsException iobe) {
        }
        return "";
    }

    @Override
    public String getTy() {
        return (String) this._datos.get(2);
    }

    @Override
    public String getLy() {
        return (String) this._datos.get(3);
    }

    @Override
    public String getVar() {
        return (String) this._datos.get(4);
    }

}
