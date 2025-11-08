package com.eboneth.espec.vacante.utilidad.mapeador;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import jakarta.persistence.*;

import com.eboneth.espec.infraestructura.utilidad.mapeador.MapeoNativoDto;
import com.eboneth.espec.vacante.dto.VacanteDtoConsulta;

@Component
public class VacanteMapperNativo implements MapeoNativoDto<VacanteDtoConsulta> {

    @Override
    public VacanteDtoConsulta mapearDesdeTupla(Tuple miTupla){
        String palabrasClaveRaw = miTupla.get("palabras_claves", String.class);
        List<String> palabraClaves = (palabrasClaveRaw == null || palabrasClaveRaw.isBlank()) 
        ? Collections.emptyList() 
        : Arrays.stream(palabrasClaveRaw.split(",")).map(String::trim).toList();

        Instant instantFechaInicio = miTupla.get("fecha_inicio_vacante", Instant.class);
        OffsetDateTime fechaInicio = null;
        if(instantFechaInicio != null){
            fechaInicio = instantFechaInicio.atZone(ZoneId.systemDefault()).toOffsetDateTime();
        }

        Instant instantFechaFin = miTupla.get("fecha_inicio_vacante", Instant.class);
        OffsetDateTime fechaFin = null;
        if(instantFechaFin != null){
            fechaInicio = instantFechaFin.atZone(ZoneId.systemDefault()).toOffsetDateTime();
        }

        return new VacanteDtoConsulta(
            miTupla.get("id_vacante", Integer.class),
            miTupla.get("titulo_vacante", String.class),
            miTupla.get("detalle_vacante", String.class),
            fechaInicio,
            fechaFin,
            miTupla.get("min_salario_vacante",String.class),
            miTupla.get("max_salario_vacante",String.class),
            miTupla.get("nombre_ubicacion",String.class),
            miTupla.get("nombre_empresa",String.class),
            miTupla.get("nombre_jornada",String.class),
            miTupla.get("nombre_modalidad",String.class),
            miTupla.get("nombre_tipo_contrato",String.class),
            miTupla.get("nombre_privado_anuncio",String.class),
            miTupla.get("estado_vacante",String.class),
            palabraClaves 
            );

    }

    
}
