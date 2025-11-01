package com.eboneth.espec.vacante.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;

@Table(name="vacantes")
@Entity(name = "vacantes_Vacantes")
public class Vacante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vacante")
    private Integer idVacante;

    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ubicacion idUbicacion;

    @JoinColumns({
            @JoinColumn(name="id_usuario", referencedColumnName = "id_usuario"),
            @JoinColumn(name="id_empresa", referencedColumnName = "id_empresa")
    })
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RelUsuarioEmpresa relUsuarioEmpresa;

    @JoinColumn(name = "id_jornada", referencedColumnName = "id_jornada")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Jornada idJornada;

    @JoinColumn(name = "id_modalidad", referencedColumnName = "id_modalidad")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Modalidad idModalidad;

    @JoinColumn(name = "id_tipo_contrato", referencedColumnName = "id_tipo_contrato")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoContrato idTipoContrato;

    @NotNull
    @Size(min = 1, max = 300)
    @Column(name="titulo_vacante", nullable=false, length = 300)
    private String tituloVacante;

    @NotNull
    @Lob
    @Column(name="detalle_vacante", nullable=false)
    private String detalleVacante;

    @NotNull
    @Column(name="fecha_inicio_vacante", nullable = false)
    private OffsetDateTime fechaInicioVacante;

    @NotNull
    @Column(name="fecha_fin_vacante", nullable = false)
    private OffsetDateTime fechaFinVacante;

    @NotNull
    @Column(name="estado_vacante", nullable = false)
    private Short estadoVacante;

    @NotNull
    @Column(name="min_salario_vacante", nullable = false, length = 100)
    private String minSalarioVacante;

    @NotNull
    @Column(name="max_salario_vacante", nullable = false, length = 100)
    private String maxSalarioVacante;

    public Vacante() {
    }

    public Vacante(Integer idVacante) {
        this.idVacante = idVacante;
    }

    public Vacante(Integer idVacante, Ubicacion idUbicacion, RelUsuarioEmpresa relUsuarioEmpresa, Jornada idJornada, Modalidad idModalidad, TipoContrato idTipoContrato, String tituloVacante, String detalleVacante, OffsetDateTime fechaInicioVacante, OffsetDateTime fechaFinVacante, Short estadoVacante, String minSalarioVacante, String maxSalarioVacante) {
        this.idVacante = idVacante;
        this.idUbicacion = idUbicacion;
        this.relUsuarioEmpresa = relUsuarioEmpresa;
        this.idJornada = idJornada;
        this.idModalidad = idModalidad;
        this.idTipoContrato = idTipoContrato;
        this.tituloVacante = tituloVacante;
        this.detalleVacante = detalleVacante;
        this.fechaInicioVacante = fechaInicioVacante;
        this.fechaFinVacante = fechaFinVacante;
        this.estadoVacante = estadoVacante;
        this.minSalarioVacante = minSalarioVacante;
        this.maxSalarioVacante = maxSalarioVacante;
    }

    public Integer getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(Integer idVacante) {
        this.idVacante = idVacante;
    }

    public Ubicacion getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicacion idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public RelUsuarioEmpresa getRelUsuarioEmpresa() {
        return relUsuarioEmpresa;
    }

    public void setRelUsuarioEmpresa(RelUsuarioEmpresa relUsuarioEmpresa) {
        this.relUsuarioEmpresa = relUsuarioEmpresa;
    }

    public Jornada getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Jornada idJornada) {
        this.idJornada = idJornada;
    }

    public Modalidad getIdModalidad() {
        return idModalidad;
    }

    public void setIdModalidad(Modalidad idModalidad) {
        this.idModalidad = idModalidad;
    }

    public TipoContrato getIdTipoContrato() {
        return idTipoContrato;
    }

    public void setIdTipoContrato(TipoContrato idTipoContrato) {
        this.idTipoContrato = idTipoContrato;
    }

    public String getDetalleVacante() {
        return detalleVacante;
    }

    public void setDetalleVacante(String detalleVacante) {
        this.detalleVacante = detalleVacante;
    }

    public String getTituloVacante() {
        return tituloVacante;
    }

    public void setTituloVacante(String tituloVacante) {
        this.tituloVacante = tituloVacante;
    }

    public OffsetDateTime getFechaInicioVacante() {
        return fechaInicioVacante;
    }

    public void setFechaInicioVacante(OffsetDateTime fechaInicioVacante) {
        this.fechaInicioVacante = fechaInicioVacante;
    }

    public OffsetDateTime getFechaFinVacante() {
        return fechaFinVacante;
    }

    public void setFechaFinVacante(OffsetDateTime fechaFinVacante) {
        this.fechaFinVacante = fechaFinVacante;
    }

    public Short getEstadoVacante() {
        return estadoVacante;
    }

    public void setEstadoVacante(Short estadoVacante) {
        this.estadoVacante = estadoVacante;
    }

    public String getMinSalarioVacante() {
        return minSalarioVacante;
    }

    public void setMinSalarioVacante(String minSalarioVacante) {
        this.minSalarioVacante = minSalarioVacante;
    }

    public String getMaxSalarioVacante() {
        return maxSalarioVacante;
    }

    public void setMaxSalarioVacante(String maxSalarioVacante) {
        this.maxSalarioVacante = maxSalarioVacante;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vacante vacante = (Vacante) o;
        return Objects.equals(idVacante, vacante.idVacante);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idVacante);
    }

    @Override
    public String toString() {
        return "Vacante{" +
                "idVacante=" + idVacante +
                "idUbicacion=" + idUbicacion +
                "relUsuarioEmpresa=" + relUsuarioEmpresa +
                "idJornada=" + idJornada +
                "idModalidad=" + idModalidad +
                "idTipoContrato=" + idTipoContrato +
                "tituloVacante='" + tituloVacante +
                "detalleVacante='" + detalleVacante +
                "fechaInicioVacante=" + fechaInicioVacante +
                "fechaFinVacante=" + fechaFinVacante +
                "estadoVacante=" + estadoVacante +
                "minSalarioVacante='" + minSalarioVacante +
                "maxSalarioVacante='" + maxSalarioVacante +
                '}';
    }
}
