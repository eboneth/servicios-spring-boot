package com.eboneth.espec.vacante.utilidad.querBuilder;

public class SqlBuilderVacante {

    private static final String CONSULTA_TXT = """
    SELECT
    v.id_vacante, v.titulo_vacante,
    v.detalle_vacante, v.fecha_inicio_vacante,
    v.fecha_fin_vacante, ev.nombre_estado_vacante as estado_vacante,
    v.min_salario_vacante, v.max_salario_vacante,
    j.nombre_jornada, a.nombre_privado_anuncio,
    m.nombre_modalidad, tc.nombre_tipo_contrato,
    e.nombre_empresa, ub.nombre_ubicacion,
    coalesce(string_agg(pc.texto_palabra_clave, ','), '') as palabras_claves
    FROM vacantes as v
         JOIN jornadas j ON v.id_jornada = j.id_jornada
         JOIN modalidades m ON v.id_modalidad = m.id_modalidad
         JOIN tipos_contratos tc ON v.id_tipo_contrato = tc.id_tipo_contrato
         JOIN ubicaciones ub ON ub.id_ubicacion = v.id_ubicacion
        JOIN empresas e ON e.id_empresa = v.id_empresa
         LEFT JOIN anuncios a ON a.id_vacante = v.id_vacante
         JOIN estados_vacantes ev on ev.id_estado_vacante = v.estado_vacante
         LEFT JOIN rel_vacante_palabraclave rel_pc ON v.id_vacante = rel_pc.id_vacante
         LEFT JOIN palabras_claves pc ON rel_pc.id_palabra_clave = pc.id_palabra_clave
    GROUP BY v.id_vacante,
         v.titulo_vacante,
         v.detalle_vacante,
         v.fecha_inicio_vacante,
         v.fecha_fin_vacante,
         v.estado_vacante,
         v.min_salario_vacante,
         v.max_salario_vacante,
         j.nombre_jornada,
         a.nombre_privado_anuncio,
         m.nombre_modalidad,
         tc.nombre_tipo_contrato,
         e.nombre_empresa,
         ub.nombre_ubicacion,
         ev.nombre_estado_vacante
    ORDER BY %s %s""";

    public static String consulta(String campoOrden, String tipoOrden){
        return String.format(CONSULTA_TXT, campoOrden, tipoOrden);
    }
    
}
