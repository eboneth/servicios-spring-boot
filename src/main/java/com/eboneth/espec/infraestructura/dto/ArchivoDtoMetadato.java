package com.eboneth.espec.infraestructura.dto;

public class ArchivoDtoMetadato {

    private final String nombrePublico;
    private final String nombrePrivado;
    private final String tipoMIME;
    private final String tamanio;
    private final String extension;

    public ArchivoDtoMetadato(String nombrePublico, String nombrePrivado, String tipoMIME, String tamanio, String extension) {
        this.nombrePublico = nombrePublico;
        this.nombrePrivado = nombrePrivado;
        this.tipoMIME = tipoMIME;
        this.tamanio = tamanio;
        this.extension = extension;
    }

    public String getNombrePublico() {
        return nombrePublico;
    }

    public String getTamanio() {
        return tamanio;
    }

    public String getTipoMIME() {
        return tipoMIME;
    }

    public String getNombrePrivado() {
        return nombrePrivado;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return "ArchivoDtoMetadato{" +
                "nombrePublico='" + nombrePublico +
                "nombrePrivado='" + nombrePrivado +
                "tipoMIME='" + tipoMIME +
                "tamanio='" + tamanio +
                "extension='" + extension +
                '}';
    }
}
