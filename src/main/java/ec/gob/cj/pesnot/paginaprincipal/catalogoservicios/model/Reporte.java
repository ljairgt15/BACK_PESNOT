package ec.gob.cj.pesnot.paginaprincipal.catalogoservicios.model;

public class Reporte {
    private String nombreCatalogoActoNotarial;
    private String articuloCatalogoActoNotarial;
    private String nombreTipoLibro;

    public Reporte() {
    }

    public Reporte(String nombreCatalogoActoNotarial, String articuloCatalogoActoNotarial, String nombreTipoLibro) {
        this.nombreCatalogoActoNotarial = nombreCatalogoActoNotarial;
        this.articuloCatalogoActoNotarial = articuloCatalogoActoNotarial;
        this.nombreTipoLibro = nombreTipoLibro;
    }

    public String getNombreCatalogoActoNotarial() {
        return nombreCatalogoActoNotarial;
    }

    public void setNombreCatalogoActoNotarial(String nombreCatalogoActoNotarial) {
        this.nombreCatalogoActoNotarial = nombreCatalogoActoNotarial;
    }

    public String getArticuloCatalogoActoNotarial() {
        return articuloCatalogoActoNotarial;
    }

    public void setArticuloCatalogoActoNotarial(String articuloCatalogoActoNotarial) {
        this.articuloCatalogoActoNotarial = articuloCatalogoActoNotarial;
    }

    public String getNombreTipoLibro() {
        return nombreTipoLibro;
    }

    public void setNombreTipoLibro(String nombreTipoLibro) {
        this.nombreTipoLibro = nombreTipoLibro;
    }

    @Override
    public String toString() {
        return "Reporte{" +
                "nombreCatalogoActoNotarial='" + nombreCatalogoActoNotarial + '\'' +
                ", articuloCatalogoActoNotarial='" + articuloCatalogoActoNotarial + '\'' +
                ", nombreTipoLibro='" + nombreTipoLibro + '\'' +
                '}';
    }
}
