package com.eboneth.espec.vacante.servicio;

import com.eboneth.espec.infraestructura.constante.ConstanteTipoArchivo;
import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import com.eboneth.espec.infraestructura.core.crud.OperacionCrudImplementacion;
import com.eboneth.espec.infraestructura.excepcion.ExcepcionNegocio;
import com.eboneth.espec.infraestructura.utilidad.archivo.GestorArchivoAdmin;
import com.eboneth.espec.infraestructura.utilidad.archivo.GestorArchivoInstancia;
import com.eboneth.espec.vacante.dto.AnuncionDtoMetadato;
import com.eboneth.espec.vacante.dto.VacanteDtoCrear;
import com.eboneth.espec.vacante.dto.VacanteDtoRespuesta;
import com.eboneth.espec.vacante.entidad.*;
import com.eboneth.espec.vacante.entidad.pk.RelVacantePalabraClavePK;
import com.eboneth.espec.vacante.repositorio.*;
import com.eboneth.espec.vacante.utilidad.mapeador.VacanteMapper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class VacanteCrearServicio extends OperacionCrudImplementacion <Vacante, Integer>{

    private final VacanteRepositorio vacanteRepositorio;
    private final RelVacantePalabraClaveRepositorio relVacantePalabraClaveRepositorio;
    private final AnuncioRepositorio anuncioRepositorio;
    private final HistorialEstadoVacanteRepositorio historialEstadoVacanteRepositorio;
    private final EstadoVacanteRepositorio estadoVacanteRepositorio;
    private final VacanteMapper vacanteMapper;
    private final GestorArchivoAdmin gestorArchivoAdmin;

    public VacanteCrearServicio(BusquedaServicio<Vacante, Integer> servicioBuscar,
                                VacanteRepositorio vacanteRepositorio,
                                RelVacantePalabraClaveRepositorio relVacantePalabraClaveRepositorio,
                                AnuncioRepositorio anuncioRepositorio,
                                HistorialEstadoVacanteRepositorio historialEstadoVacanteRepositorio,
                                EstadoVacanteRepositorio estadoVacanteRepositorio,
                                VacanteMapper vacanteMapper, GestorArchivoAdmin gestorArchivoAdmin) {
        super(servicioBuscar);
        this.vacanteRepositorio = vacanteRepositorio;
        this.relVacantePalabraClaveRepositorio = relVacantePalabraClaveRepositorio;
        this.anuncioRepositorio = anuncioRepositorio;
        this.historialEstadoVacanteRepositorio = historialEstadoVacanteRepositorio;
        this.estadoVacanteRepositorio = estadoVacanteRepositorio;
        this.vacanteMapper = vacanteMapper;
        this.gestorArchivoAdmin = gestorArchivoAdmin;
    }

    @Override
    protected JpaRepository<Vacante, Integer> getRepositorio() {
       return vacanteRepositorio;
    }

    @Transactional
    public VacanteDtoRespuesta CrearVacante(VacanteDtoCrear dtoVacante,
                                            AnuncionDtoMetadato anuncioDtoMetadato) {
        Vacante vacante = vacanteMapper.desdeDto(dtoVacante);
        vacante = vacanteRepositorio.save(vacante);

        guardarPalabraClave(dtoVacante,vacante);

        guardarAnuncio(anuncioDtoMetadato, vacante);

        guardarHistorial(dtoVacante, vacante);

        guardarImagenServidor(dtoVacante.getArchivo(), anuncioDtoMetadato);

        return vacanteMapper.desdeEntidad(vacante);

    }

    private void guardarHistorial(VacanteDtoCrear dtoVacante, Vacante vacante) {
        EstadoVacante estadoVacante = estadoVacanteRepositorio
                .findById((int) dtoVacante.getEstadoVacante())
                .orElseThrow(()-> new ExcepcionNegocio("Estado no encontrado"));

        HistorialEstadoVacante historialEstadoVacante = new HistorialEstadoVacante();
        historialEstadoVacante.setIdVacante(vacante);
        historialEstadoVacante.setFechaHistorialEstadoVacante(OffsetDateTime.now());
        historialEstadoVacante.setIdEstadoVacante(estadoVacante);
        historialEstadoVacanteRepositorio.save(historialEstadoVacante);
    }

    private void guardarAnuncio(AnuncionDtoMetadato anuncionDtoMetadato, Vacante vacante) {
        Anuncio anuncio = new Anuncio();
        anuncio.setVacante(vacante);
        anuncio.setNombrePublicoAnuncio(anuncionDtoMetadato.getNombrePublicoAnuncio());
        anuncio.setNombrePrivadoAnuncio(anuncionDtoMetadato.getNombrePrivadoAnuncio());
        anuncio.setTipoAnuncio(anuncionDtoMetadato.getTipoAnuncio());
        anuncio.setTamanioAnuncio(anuncionDtoMetadato.getTamanioAnuncio());

        anuncioRepositorio.save(anuncio);
    }

    private void guardarPalabraClave(VacanteDtoCrear dtoVacante, Vacante vacante) {
        if (dtoVacante.getIdPalabraClave() == null || dtoVacante.getIdPalabraClave().isEmpty()) {
            return;
        }
        List<RelVacantePalabraClave> relaciones = dtoVacante.getIdPalabraClave().stream()
                .map((idPalabra) ->{
                    RelVacantePalabraClave relVacantePalabraClave = new RelVacantePalabraClave();
                    relVacantePalabraClave.setId(new RelVacantePalabraClavePK(vacante.getIdVacante(), idPalabra));
                    relVacantePalabraClave.setVacante(vacante);
                    relVacantePalabraClave.setPalabraClave(entityManager.getReference(PalabraClave.class, idPalabra));

                    return relVacantePalabraClave;
                }).toList();

        relVacantePalabraClaveRepositorio.saveAll(relaciones);
    }

    private void guardarImagenServidor(MultipartFile archivo, AnuncionDtoMetadato anuncioDtoMetadato) {
        GestorArchivoInstancia instancia = gestorArchivoAdmin.crear(
                ConstanteTipoArchivo.IMAGEN_VACANTE,
                anuncioDtoMetadato.getNombrePrivadoAnuncio(),
                null,
                archivo
        );

        boolean exito = instancia.guardar();
        if (!exito) {
            throw new ExcepcionNegocio("No se pudo guardar el imagen");
        }

    }
}
