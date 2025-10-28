package com.eboneth.espec.infraestructura.excepcion;

import com.eboneth.espec.infraestructura.dto.ErrorDtoExcepcion;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.OffsetDateTime;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorControlador {

    private static final Logger log = LoggerFactory.getLogger(ErrorControlador.class);

    // Seguridad
    // *************************************************************************
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<ErrorDtoExcepcion> credencialesInvalidas(BadCredentialsException ex) {
//        return construirRespuesta(HttpStatus.UNAUTHORIZED, "Credenciales inválidas",
//                "El correo electrónico o contraseña son incorrectos");
//    }
//
//    @ExceptionHandler(DisabledException.class)
//    public ResponseEntity<ErrorDtoExcepcion> usuarioDeshabilitado(DisabledException ex) {
//        return construirRespuesta(HttpStatus.UNAUTHORIZED, "Usuario inactivo",
//                "El usuario no tiene permisos o su cuenta está inactiva");
//    }
//
//    @ExceptionHandler(ExpiredJwtException.class)
//    public ResponseEntity<ErrorDtoExcepcion> tokenExpirado(ExpiredJwtException ex) {
//        return construirRespuesta(HttpStatus.UNAUTHORIZED, "Token expirado",
//                "Tu sesión ha caducado. Debes iniciar sesión nuevamente");
//    }
//
//    @ExceptionHandler(ExcepcionSeguridad.class)
//    public ResponseEntity<ErrorDtoExcepcion> errorSeguridad(ExcepcionSeguridad ex) {
//        return construirRespuesta(HttpStatus.UNAUTHORIZED, "Acceso bloqueado", ex.getMessage());
//    }
    // *************************************************************************
    // Errores comunes
    // *************************************************************************
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDtoExcepcion> rutaNoEncontrada(NoHandlerFoundException ex) {
        return construirRespuesta(HttpStatus.NOT_FOUND, "Ruta no encontrada", ex.getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ErrorDtoExcepcion> tamanioNoPermitido(MaxUploadSizeExceededException ex) {
        return construirRespuesta(HttpStatus.PAYLOAD_TOO_LARGE, "Tamaño de archivo no permitido", ex.getMessage());
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorDtoExcepcion> noEncontrado(NoSuchElementException ex) {
        return construirRespuesta(HttpStatus.NOT_FOUND, "Recurso no encontrado", ex.getMessage());
    }

    @ExceptionHandler({IllegalArgumentException.class, MethodArgumentTypeMismatchException.class})
    public ResponseEntity<ErrorDtoExcepcion> argumentoInvalido(RuntimeException ex) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, "Argumento inválido", ex.getMessage());
    }

    @ExceptionHandler(UnrecognizedPropertyException.class)
    public ResponseEntity<ErrorDtoExcepcion> propiedadDesconocida(UnrecognizedPropertyException ex) {
        String campo = ex.getPropertyName();
        String mensaje = "El campo '" + campo + "' no es reconocido. Verifica la estructura del JSON.";
        return construirRespuesta(HttpStatus.BAD_REQUEST, "Propiedad desconocida", mensaje);
    }

    // Reglas de negocio y validaciones
    // *************************************************************************
    @ExceptionHandler(ExcepcionNegocio.class)
    public ResponseEntity<ErrorDtoExcepcion> conflictoNegocio(ExcepcionNegocio ex) {
        return construirRespuesta(HttpStatus.CONFLICT, "Conflicto de regla de negocio", ex.getMessage());
    }

    @ExceptionHandler(ExcepcionValidacion.class)
    public ResponseEntity<ErrorDtoExcepcion> errorValidacion(ExcepcionValidacion ex) {
        return construirRespuesta(HttpStatus.BAD_REQUEST, "Error de validación", ex.getMessage());
    }

    // Y en caso de respaldo?
    // *************************************************************************
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDtoExcepcion> errorGeneral(Exception ex) {
        log.error("Error no controlado", ex);

        String detalle = (ex.getMessage() != null && !ex.getMessage().isBlank())
                ? ex.getMessage()
                : "Error inesperado. Contacte al administrador";

        return construirRespuesta(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Error interno del servidor",
                detalle
        );
    }

    // El wraper para entregar errores
    private ResponseEntity<ErrorDtoExcepcion> construirRespuesta(HttpStatus estado, String error, String detalle) {
        ErrorDtoExcepcion respuesta = new ErrorDtoExcepcion(
                estado.value(),
                OffsetDateTime.now(),
                error,
                detalle
        );
        return ResponseEntity.status(estado).body(respuesta);
    }
}
