package xls;

import java.util.ArrayList;
import java.util.List;

public class xlsData {

    public static int MAXCOLRANGE = 18;
    private List<String> _datos = new ArrayList(MAXCOLRANGE);

    /*public boolean equals(Object obj) {
    if ((obj instanceof xlsData)) {
    xlsData foo = (xlsData) obj;

    return (getTienda().equals(foo.getTienda())) && (getSku().equals(foo.getSku()));
    }

    return false;
    }*/

    /*public int hashCode() {
    String hash = getTienda() + getSku();
    return hash.hashCode();
    }*/
    /*public String getSku() {
    try {
    return (String) this._datos.get(7);
    } catch (IndexOutOfBoundsException iobe) {
    }
    return "";
    }*/
    public String getPais() {
        try {
            String pais = (String) this._datos.get(0);
            if(pais.contains("- ")){
                int idx = pais.lastIndexOf("- ");
                pais = pais.subSequence(idx + 2, pais.length()).toString();
                return pais;
            }
            return pais;
        } catch (IndexOutOfBoundsException ibe){
            return "";
        }
    }

    public String getMarca() {
        try {
            String marca = (String) this._datos.get(1);
            if(marca.contains("- ")){
                int idx = marca.lastIndexOf("- ");
                marca = marca.subSequence(idx + 2, marca.length()).toString();
                return marca;
            }
            return marca;
        } catch (IndexOutOfBoundsException ibe){
            return "";
        }
    }

    public Double getIMU() {
        try {
            return Double.valueOf(Double.parseDouble((String) this._datos.get(2)));
        } catch (NumberFormatException nfe) {
        } catch (IndexOutOfBoundsException ibe){
            return 0.0;
        }
        return Double.valueOf(0.0);
    }

    public Double getGM() {
        try {
            return Double.valueOf(Double.parseDouble((String) this._datos.get(3)));
        } catch (NumberFormatException nfe) {
        } catch (IndexOutOfBoundsException ibe){
            return 0.0;
        }
        return Double.valueOf(0.0);
    }

    public Double getRotacion() {
        try {
            return Double.valueOf(Double.parseDouble((String) this._datos.get(4)));
        } catch (NumberFormatException nfe) {
        } catch (IndexOutOfBoundsException ibe){
            return 0.0;
        }
        return Double.valueOf(0.0);
    }

    public Double getMarkDown() {
        try {
            return Double.valueOf(Double.parseDouble((String) this._datos.get(5)));
        } catch (NumberFormatException nfe) {
        } catch (IndexOutOfBoundsException ibe){
            return 0.0;
        }
        return Double.valueOf(0.0);
    }

    public List<String> getDatos() {
        return this._datos;
    }

    public void setDatos(List<String> _datos) {
        this._datos = _datos;
    }
}
