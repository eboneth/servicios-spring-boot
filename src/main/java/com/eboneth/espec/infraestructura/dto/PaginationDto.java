
package com.eboneth.espec.infraestructura.dto;

import java.util.List;

public class PaginationDto <T>{
    private List<T> contenido;
    private int paginaActual;
    private int tamanio;
    private int totalPaginas;
    private int totalElementos;

    public PaginationDto(List<T> contenido, int paginaActual, int tamanio, int totalPaginas, int totalElementos) {
        this.contenido = contenido;
        this.paginaActual = paginaActual;
        this.tamanio = tamanio;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
    }

    public List<T> getContenido() {
        return contenido;
    }

    public void setContenido(List<T> contenido) {
        this.contenido = contenido;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(int totalElementos) {
        this.totalElementos = totalElementos;
    }
    
    
}
