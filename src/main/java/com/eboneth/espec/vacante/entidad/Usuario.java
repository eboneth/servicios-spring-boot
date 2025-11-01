package com.eboneth.espec.vacante.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.Objects;

@Table(name = "usuarios")
@Entity(name = "vacante_Usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private Integer idUsuario;

    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id_ubicacion")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Ubicacion idUbicacion;

    @NotNull
    @Column(name="tipo_documento_usuario", nullable = false)
    private Short tipoDocumentoUsuario;

    @NotNull
    @Size(min=1,max=150)
    @Column(name="documento_usuario", nullable = false, length = 150, unique = true)
    private String documentoUsuario;

    @NotNull
    @Size(min=1,max=50)
    @Column(name="nombres_usuario", nullable = false, length = 50)
    private String nombresUsuario;

    @NotNull
    @Size(min=1,max=50)
    @Column(name="apellidos_usuario", nullable = false, length = 50)
    private String apellidosUsuario;

    @NotNull
    @Column(name="estado_usuario", nullable = false)
    private Short estadoUsuario;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, Ubicacion idUbicacion, Short tipoDocumentoUsuario, String documentoUsuario, String apellidosUsuario, String nombresUsuario, Short estadoUsuario) {
        this.idUsuario = idUsuario;
        this.idUbicacion = idUbicacion;
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
        this.documentoUsuario = documentoUsuario;
        this.apellidosUsuario = apellidosUsuario;
        this.nombresUsuario = nombresUsuario;
        this.estadoUsuario = estadoUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Ubicacion getIdUbicacion() {
        return idUbicacion;
    }

    public void setIdUbicacion(Ubicacion idUbicacion) {
        this.idUbicacion = idUbicacion;
    }

    public Short getTipoDocumentoUsuario() {
        return tipoDocumentoUsuario;
    }

    public void setTipoDocumentoUsuario(Short tipoDocumentoUsuario) {
        this.tipoDocumentoUsuario = tipoDocumentoUsuario;
    }

    public String getDocumentoUsuario() {
        return documentoUsuario;
    }

    public void setDocumentoUsuario(String documentoUsuario) {
        this.documentoUsuario = documentoUsuario;
    }

    public String getNombresUsuario() {
        return nombresUsuario;
    }

    public void setNombresUsuario(String nombresUsuario) {
        this.nombresUsuario = nombresUsuario;
    }

    public String getApellidosUsuario() {
        return apellidosUsuario;
    }

    public void setApellidosUsuario(String apellidosUsuario) {
        this.apellidosUsuario = apellidosUsuario;
    }

    public Short getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Short estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Usuario usuario)) return false;
        return Objects.equals(idUsuario, usuario.idUsuario) && Objects.equals(idUbicacion, usuario.idUbicacion) && Objects.equals(tipoDocumentoUsuario, usuario.tipoDocumentoUsuario) && Objects.equals(documentoUsuario, usuario.documentoUsuario) && Objects.equals(nombresUsuario, usuario.nombresUsuario) && Objects.equals(apellidosUsuario, usuario.apellidosUsuario) && Objects.equals(estadoUsuario, usuario.estadoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUsuario, idUbicacion, tipoDocumentoUsuario, documentoUsuario, nombresUsuario, apellidosUsuario, estadoUsuario);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                "idUbicacion=" + (idUbicacion != null ? idUbicacion.getIdUbicacion() : "null") +
                "tipoDocumentoUsuario=" + tipoDocumentoUsuario +
                "documentoUsuario='" + documentoUsuario +
                "nombresUsuario='" + nombresUsuario +
                "apellidosUsuario='" + apellidosUsuario +
                "estadoUsuario=" + estadoUsuario +
                '}';
    }
}
