package xls;

import java.util.ArrayList;
import java.util.List;

public abstract class XlsData implements IEstructuraMarcaVenta, Comparable<IEstructuraMarcaVenta> {

    public int MAXCOLRANGE;
    protected int NUMBERCOL = 2;
    protected List<String> _datos;
    protected boolean _procesado;

    public XlsData(){
        _procesado = false;
    }
    
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof IEstructuraMarcaVenta)) {
            IEstructuraMarcaVenta foo = (IEstructuraMarcaVenta) obj;
            return (get(0).equals(foo.get(0))) && (get(1).equals(foo.get(1)));
        }
        return false;
    }

    @Override
    public int hashCode() {
        String hash = get(0) + get(1);
        return hash.trim().hashCode();
    }

    @Override
    public String getCell(int index) {
        return (String) this._datos.get(index);
    }

    @Override
    public List<String> getDatos() {
        return this._datos;
    }

    @Override
    public void setDatos(List<String> _datos) {
        this._datos = _datos;
    }
    
    @Override
    public void set(int index, String element) {
        //throw new UnsupportedOperationException("Not supported in this Class.");
        this._datos.set(index, element);
    }
        
    @Override
    public void add(int index, String element) {
        //throw new UnsupportedOperationException("Not supported in this Class.");
        this._datos.add(index, element);
    }
    
    @Override
    public String get(int index) {
        //throw new UnsupportedOperationException("Not supported in this Class.");
        try {
            return (String) this._datos.get(index);
        } catch (IndexOutOfBoundsException iobe) {
            if(index > NUMBERCOL){
                return "0.0";
            }
        }
        return "";
    }
    
    @Override
    public boolean isEmpty() {
        if(this._datos == null) return true;
        if(this._datos.isEmpty()) return true;
        //if(this._datos.size() == 0) return true;
        return false;
    }
    
    @Override
    public int compareTo(IEstructuraMarcaVenta o) {
        /*if(this.get(1).isEmpty()){
            return 1;
        }*/
        int last = this.get(1).compareTo(o.get(1));
        return last == 0 ? this.get(0).compareTo(o.get(0)) : last;
    }

    @Override
    public boolean isProcesado() {
        return _procesado;
    }

    @Override
    public void setProcesado(boolean _procesado) {
        this._procesado = _procesado;
    }
}
