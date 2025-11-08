package com.eboneth.espec.vacante.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class VacanteDtoConsulta {
    
    private final Integer idVacante;
    private final String tituloVacante;
    private final String detalleVacante;
    private final OffsetDateTime fechaInicioVacante;
    private final OffsetDateTime fechaFinVacante;
    private final String minSalarioVacante;
    private final String maxSalarioVacante;
    private final String nombreUbicacion;
    private final String nombreEmpresa;
    private final String nombrejornada;
    private final String nombreModalidad;
    private final String nombreTipoContrato;
    private final String nombrePrivadoAnuncio;
    private final String nombreEstadoVacante;
    private final List<String> palabraClave;

    private final String imagenURL;

    public VacanteDtoConsulta(Integer idVacante, String tituloVacante, String detalleVacante,
            OffsetDateTime fechaInicioVacante, OffsetDateTime fechaFinVacante, String minSalarioVacante,
            String maxSalarioVacante, String nombreUbicacion, String nombreEmpresa, String nombrejornada,
            String nombreModalidad, String nombreTipoContrato, String nombrePrivadoAnuncio, String nombreEstadoVacante,
            List<String> palabraClave, String imagenURL) {
        this.idVacante = idVacante;
        this.tituloVacante = tituloVacante;
        this.detalleVacante = detalleVacante;
        this.fechaInicioVacante = fechaInicioVacante;
        this.fechaFinVacante = fechaFinVacante;
        this.minSalarioVacante = minSalarioVacante;
        this.maxSalarioVacante = maxSalarioVacante;
        this.nombreUbicacion = nombreUbicacion;
        this.nombreEmpresa = nombreEmpresa;
        this.nombrejornada = nombrejornada;
        this.nombreModalidad = nombreModalidad;
        this.nombreTipoContrato = nombreTipoContrato;
        this.nombrePrivadoAnuncio = nombrePrivadoAnuncio;
        this.nombreEstadoVacante = nombreEstadoVacante;
        this.palabraClave = palabraClave;
        this.imagenURL = imagenURL;
    }

    public VacanteDtoConsulta(Integer idVacante, String tituloVacante, String detalleVacante,
            OffsetDateTime fechaInicioVacante, OffsetDateTime fechaFinVacante, String minSalarioVacante,
            String maxSalarioVacante, String nombreUbicacion, String nombreEmpresa, String nombrejornada,
            String nombreModalidad, String nombreTipoContrato, String nombrePrivadoAnuncio, String nombreEstadoVacante,
            List<String> palabraClave) {
        
            this(idVacante, tituloVacante, 
            detalleVacante, fechaInicioVacante, 
            fechaFinVacante, minSalarioVacante, 
            maxSalarioVacante, nombreUbicacion, 
            nombreEmpresa, nombrejornada, 
            nombreModalidad, nombreTipoContrato, 
            nombrePrivadoAnuncio, nombreEstadoVacante, 
            palabraClave, null);
    }

    public Integer getIdVacante() {
        return idVacante;
    }

    public String getTituloVacante() {
        return tituloVacante;
    }

    public String getDetalleVacante() {
        return detalleVacante;
    }

    public OffsetDateTime getFechaInicioVacante() {
        return fechaInicioVacante;
    }

    public OffsetDateTime getFechaFinVacante() {
        return fechaFinVacante;
    }

    public String getMinSalarioVacante() {
        return minSalarioVacante;
    }

    public String getMaxSalarioVacante() {
        return maxSalarioVacante;
    }

    public String getNombreUbicacion() {
        return nombreUbicacion;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getNombrejornada() {
        return nombrejornada;
    }

    public String getNombreModalidad() {
        return nombreModalidad;
    }

    public String getNombreTipoContrato() {
        return nombreTipoContrato;
    }

    public String getNombrePrivadoAnuncio() {
        return nombrePrivadoAnuncio;
    }

    public String getNombreEstadoVacante() {
        return nombreEstadoVacante;
    }

    public List<String> getPalabraClave() {
        return palabraClave;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    
public VacanteDtoConsulta conImagenUrl(String imgUrl){
    return new VacanteDtoConsulta(idVacante, tituloVacante, 
    detalleVacante, fechaInicioVacante, 
    fechaFinVacante, minSalarioVacante, 
    maxSalarioVacante, nombreUbicacion, 
    nombreEmpresa, nombrejornada, 
    nombreModalidad, nombreTipoContrato, 
    nombrePrivadoAnuncio, nombreEstadoVacante, 
    palabraClave, imgUrl);
}
    



}
