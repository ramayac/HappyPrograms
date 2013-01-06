package xls;

import dto.Consolidado;
import java.util.ArrayList;
import java.util.List;

public class xlsSheet {
    private String _sheetName = "";
    private List<xlsData> _sem1 = new ArrayList();
    private List<xlsData> _sem2 = new ArrayList();
    private List<xlsData> _proy = new ArrayList();

    private List<Consolidado> _cons = new ArrayList();

    public List<Consolidado> getCons() {
        return _cons;
    }

    public void setCons(List<Consolidado> _cons) {
        this._cons = _cons;
    }

    public List<xlsData> getProy() {
        return _proy;
    }

    public void setProy(List<xlsData> _proy) {
        this._proy.addAll(_proy);
    }

    public List<xlsData> getSem1() {
        return _sem1;
    }

    public void setSem1(List<xlsData> _sem1) {
        this._sem1.addAll(_sem1);
    }

    public List<xlsData> getSem2() {
        return _sem2;
    }

    public void setSem2(List<xlsData> _sem2) {
        this._sem2.addAll(_sem2);
    }

    public String getSheetName() {
        return this._sheetName;
    }

    public void setSheetName(String _sheetName) {
        this._sheetName = _sheetName;
    }

}
