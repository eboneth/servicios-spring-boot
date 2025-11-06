package com.eboneth.espec.usuario.dto;

public class ImagenDtoMetadato {
    private String nombrePublicoImagen;
    private String nombrePrivadoImagen;
    private String tipoImagen;
    private String tamanioImagen;
    private Short favoritoImagen;

    public ImagenDtoMetadato() {
    }

    public ImagenDtoMetadato(String nombrePublicoImagen,
                             String nombrePrivadoImagen,
                             String tipoImagen,
                             String tamanioImagen,
                             Short favoritoImagen) {
        this.nombrePublicoImagen = nombrePublicoImagen;
        this.nombrePrivadoImagen = nombrePrivadoImagen;
        this.tipoImagen = tipoImagen;
        this.tamanioImagen = tamanioImagen;
        this.favoritoImagen = favoritoImagen;
    }

    public ImagenDtoMetadato(String nombrePublicoImagen, String tamanioImagen, String tipoImagen, String nombrePrivadoImagen) {
        this.nombrePublicoImagen = nombrePublicoImagen;
        this.tamanioImagen = tamanioImagen;
        this.tipoImagen = tipoImagen;
        this.nombrePrivadoImagen = nombrePrivadoImagen;
    }

    public String getNombrePublicoImagen() {
        return nombrePublicoImagen;
    }

    public void setNombrePublicoImagen(String nombrePublicoImagen) {
        this.nombrePublicoImagen = nombrePublicoImagen;
    }

    public String getNombrePrivadoImagen() {
        return nombrePrivadoImagen;
    }

    public void setNombrePrivadoImagen(String nombrePrivadoImagen) {
        this.nombrePrivadoImagen = nombrePrivadoImagen;
    }

    public String getTipoImagen() {
        return tipoImagen;
    }

    public void setTipoImagen(String tipoImagen) {
        this.tipoImagen = tipoImagen;
    }

    public String getTamanioImagen() {
        return tamanioImagen;
    }

    public void setTamanioImagen(String tamanioImagen) {
        this.tamanioImagen = tamanioImagen;
    }

    public Short getFavoritoImagen() {
        return favoritoImagen;
    }

    public void setFavoritoImagen(Short favoritoImagen) {
        this.favoritoImagen = favoritoImagen;
    }
}
