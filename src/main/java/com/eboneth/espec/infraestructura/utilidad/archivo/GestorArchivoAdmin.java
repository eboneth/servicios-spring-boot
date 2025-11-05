package com.eboneth.espec.infraestructura.utilidad.archivo;

import com.eboneth.espec.infraestructura.constante.ConstanteTipoArchivo;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Paths;

@Component
public class GestorArchivoAdmin {
    private final RutaArchivo rutaArchivo;

    public GestorArchivoAdmin(RutaArchivo rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public GestorArchivoInstancia crear(
            ConstanteTipoArchivo tipoArchivo,
            String nombreArchivo,
            String respaldo,
            MultipartFile archivo){

        String rutaBase = switch(tipoArchivo){
            case DOCUMENTO -> rutaArchivo.getDocumentos();
            case COMPRIMIDO ->  rutaArchivo.getComprimidos();
            case IMAGEN_VACANTE -> rutaArchivo.getImagenesVacantes();
            default -> rutaArchivo.getImagenes();
        };
        return new GestorArchivoInstancia(
                Paths.get(rutaBase),
                nombreArchivo,
                respaldo,
                archivo);

    }
}
