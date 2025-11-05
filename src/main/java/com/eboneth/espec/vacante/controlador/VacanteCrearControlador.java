package com.eboneth.espec.vacante.controlador;

import com.eboneth.espec.infraestructura.dto.ArchivoDtoMetadato;
import com.eboneth.espec.infraestructura.utilidad.respuesta.RespuestaHttp;
import com.eboneth.espec.infraestructura.utilidad.validacion.ArchivoRegla;
import com.eboneth.espec.vacante.dto.AnuncionDtoMetadato;
import com.eboneth.espec.vacante.dto.VacanteDtoCrear;
import com.eboneth.espec.vacante.dto.VacanteDtoRespuesta;
import com.eboneth.espec.vacante.entidad.Vacante;
import com.eboneth.espec.vacante.servicio.VacanteCrearServicio;
import com.eboneth.espec.vacante.utilidad.mapeador.VacanteMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/vacancy")
public class VacanteCrearControlador {

    private final VacanteCrearServicio vacanteCrearServicio;
    private static  final long TAMANIO_ARCHIVO = 1024 * 1024 * 5;
    private static  final List<String> TIPO_ARCHIVO_PERMITIDO = List.of(
            "image/jpeg",
            "image/png",
            "image/jpg"
    );

    public VacanteCrearControlador(VacanteCrearServicio vacanteCrearServicio) {
        this.vacanteCrearServicio = vacanteCrearServicio;
    }

    @PostMapping("/add")
    public ResponseEntity<?> nuevaVacante (@ModelAttribute VacanteDtoCrear vacanteDtoCrear) {

        MultipartFile archivo = vacanteDtoCrear.getArchivo();
        ArchivoRegla.verificar(archivo, TIPO_ARCHIVO_PERMITIDO, TAMANIO_ARCHIVO);
        ArchivoDtoMetadato metadato = ArchivoRegla.extraerMetadatos(archivo);

        AnuncionDtoMetadato anuncionDtoMetadato = new AnuncionDtoMetadato(
                metadato.getNombrePublico(),
                metadato.getNombrePrivado(),
                metadato.getTipoMIME(),
                metadato.getTamanio());

        VacanteDtoRespuesta vacanteDtoRespuesta = vacanteCrearServicio.CrearVacante(vacanteDtoCrear, anuncionDtoMetadato);
        return RespuestaHttp.ok("Vacante creado correctamente", vacanteDtoRespuesta);
    }
}
