package com.eboneth.espec.usuario.entidad;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;

@Entity(name = "usuario_Imagenes")
@Table(name = "imagenes")
public class Imagen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagen", nullable = false)
    private Integer idImagen;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    @Size(max = 200)
    @NotNull
    @Column(name = "nombre_publico_imagen", nullable = false, length = 200)
    private String nombrePublicoImagen;

    @Size(max = 200)
    @NotNull
    @Column(name = "nombre_privado_imagen", nullable = false, length = 200)
    private String nombrePrivadoImagen;

    @Size(max = 50)
    @NotNull
    @Column(name = "tipo_imagen", nullable = false, length = 50)
    private String tipoImagen;

    @Size(max = 50)
    @NotNull
    @Column(name = "tamanio_imagen", nullable = false, length = 50)
    private String tamanioImagen;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "favorita_imagen", nullable = false)
    private Short favoritaImagen = 1;

    public Integer getId() {
        return idImagen;
    }

    public void setId(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
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

    public Short getFavoritaImagen() {
        return favoritaImagen;
    }

    public void setFavoritaImagen(Short favoritaImagen) {
        this.favoritaImagen = favoritaImagen;
    }

}