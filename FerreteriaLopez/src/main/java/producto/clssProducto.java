
package producto;


public class clssProducto {
    
    private String nomProduc;
    private String cantidad;

    public clssProducto(String nomProduc, String cantidad) {
        this.nomProduc = nomProduc;
        this.cantidad = cantidad;
    }

    public String getNomProduc() {
        return nomProduc;
    }

    public void setNomProduc(String nomProduc) {
        this.nomProduc = nomProduc;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    
    
}
