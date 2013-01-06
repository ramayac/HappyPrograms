package dto;

/**
 *
 * @author ramayac
 */
public class Consolidado {

    private String pais;
    private String marca;
    private Double IMU1;
    private Double GM1;
    private Double rotacion1;
    private Double markDown1;
    private Double IMU2;
    private Double GM2;
    private Double rotacion2;
    private Double markDown2;
    private Double IMU3;
    private Double GM3;
    private Double rotacion3;
    private Double markDown3;

    public Consolidado(String pais, String marca) {
        this.pais = pais;
        this.marca = marca;
    }

    public Consolidado(String pais, String marca, Double IMU1, Double GM1, Double rotacion1, Double markDown1) {
        this.pais = pais;
        this.marca = marca;
        this.IMU1 = IMU1;
        this.GM1 = GM1;
        this.rotacion1 = rotacion1;
        this.markDown1 = markDown1;
    }

    public void SetSem1(Double IMU1, Double GM1, Double rotacion1, Double markDown1) {
        this.IMU1 = IMU1;
        this.GM1 = GM1;
        this.rotacion1 = rotacion1;
        this.markDown1 = markDown1;
    }

    public void SetSem2(Double IMU2, Double GM2, Double rotacion2, Double markDown2) {
        this.IMU2 = IMU2;
        this.GM2 = GM2;
        this.rotacion2 = rotacion2;
        this.markDown2 = markDown2;
    }

    public void SetProy(Double IMU3, Double GM3, Double rotacion3, Double markDown3) {
        this.IMU3 = IMU3;
        this.GM3 = GM3;
        this.rotacion3 = rotacion3;
        this.markDown3 = markDown3;
    }

    public Double getGM1() {
        if(GM1 != null){
            return GM1;
        } else {
            return 0.0;
        }
    }

    public void setGM1(Double GM1) {
        this.GM1 = GM1;
    }

    public Double getGM2() {
        if(GM2 != null){
            return GM2;
        } else {
            return 0.0;
        }
    }

    public void setGM2(Double GM2) {
        this.GM2 = GM2;
    }

    public Double getGM3() {
        if(GM3 != null){
            return GM3;
        } else {
            return 0.0;
        }
    }

    public void setGM3(Double GM3) {
        this.GM3 = GM3;
    }

    public Double getIMU1() {
        if(IMU1 != null){
            return IMU1;
        } else {
            return 0.0;
        }
    }

    public void setIMU1(Double IMU1) {
        this.IMU1 = IMU1;
    }

    public Double getIMU2() {
        if(IMU2 != null){
            return IMU2;
        } else {
            return 0.0;
        }
    }

    public void setIMU2(Double IMU2) {
        this.IMU2 = IMU2;
    }

    public Double getIMU3() {
        if(IMU3 != null){
            return IMU3;
        } else {
            return 0.0;
        }
    }

    public void setIMU3(Double IMU3) {
        this.IMU3 = IMU3;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getMarkDown1() {
        if(markDown1 != null){
            return markDown1;
        } else {
            return 0.0;
        }
    }

    public void setMarkDown1(Double markDown1) {
        this.markDown1 = markDown1;
    }

    public Double getMarkDown2() {
        if(markDown2 != null){
            return markDown2;
        } else {
            return 0.0;
        }
    }

    public void setMarkDown2(Double markDown2) {
        this.markDown2 = markDown2;
    }

    public Double getMarkDown3() {
        if(markDown3 != null){
            return markDown3;
        } else {
            return 0.0;
        }
    }

    public void setMarkDown3(Double markDown3) {
        this.markDown3 = markDown3;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getRotacion1() {
        if(rotacion1 != null){
            return rotacion1;
        } else {
            return 0.0;
        }
    }

    public void setRotacion1(Double rotacion1) {
        this.rotacion1 = rotacion1;
    }

    public Double getRotacion2() {
        if(rotacion2 != null){
            return rotacion2;
        } else {
            return 0.0;
        }
    }

    public void setRotacion2(Double rotacion2) {
        this.rotacion2 = rotacion2;
    }

    public Double getRotacion3() {
        if(rotacion3 != null){
            return rotacion3;
        } else {
            return 0.0;
        }
    }

    public void setRotacion3(Double rotacion3) {
        this.rotacion3 = rotacion3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Consolidado other = (Consolidado) obj;
        if ((this.pais == null) ? (other.pais != null) : !this.pais.equals(other.pais)) {
            return false;
        }
        if ((this.marca == null) ? (other.marca != null) : !this.marca.equals(other.marca)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.pais != null ? this.pais.hashCode() : 0);
        hash = 97 * hash + (this.marca != null ? this.marca.hashCode() : 0);
        return hash;
    }
}
