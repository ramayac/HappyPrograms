package xls;

import java.util.ArrayList;
import java.util.List;

public class XlsSheet {

    private String _sheetName = "";
    private List<IEstructuraMarcaVenta> _datos = new ArrayList();

    public String getSheetName() {
        return this._sheetName;
    }

    public void setSheetName(String _sheetName) {
        this._sheetName = _sheetName;
    }

    public List<IEstructuraMarcaVenta> getDatos() {
        return this._datos;
    }

    public void setDatos(List<IEstructuraMarcaVenta> _datos) {
        this._datos = _datos;
    }

    public int size() {
        return this._datos.size();
    }
}
