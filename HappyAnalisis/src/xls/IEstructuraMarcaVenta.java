package xls;

import java.util.List;

/**
 *
 * @author Rodrigo
 */
interface IEstructuraMarcaVenta {
    public String getEstructura();
    public String getMarca();
    public String getTy();
    public String getLy();
    public String getVar();
    public String getCell(int index);
    public String get(int index);
    //public void setCell(String val);
    public List<String> getDatos();
    public void setDatos(List<String> _datos);
    public void add(int index, String element);
    public void set(int index, String element);
    @Override
    public int hashCode();
    public boolean isEmpty();
    
    public boolean isProcesado();
    public void setProcesado(boolean _procesado);
}
