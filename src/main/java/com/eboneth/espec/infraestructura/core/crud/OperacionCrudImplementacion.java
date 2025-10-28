package com.eboneth.espec.infraestructura.core.crud;

import com.eboneth.espec.infraestructura.core.busqueda.BusquedaServicio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class OperacionCrudImplementacion<T, ID> implements OperacionCrud<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final BusquedaServicio<T, ID> servicioBuscar;

    public OperacionCrudImplementacion(BusquedaServicio<T, ID> servicioBuscar) {
        this.servicioBuscar = servicioBuscar;
    }

    protected abstract JpaRepository<T, ID> getRepositorio();

    @Override
    public Long cantidadRegistros() {
        return getRepositorio().count();
    }

    @Override
    public T agregar(T miEntidad) {
        return getRepositorio().save(miEntidad);
    }

    @Override
    public List<T> consultarTodos(Sort sort) {
        return getRepositorio().findAll(sort);
    }

    @Override
    public T buscarPorId(ID id) {
        return servicioBuscar.porId(getRepositorio(), id);
    }

    @Override
    public T buscarPorId(ID id, String mensaje) {
        return servicioBuscar.porId(getRepositorio(), id, mensaje);
    }

    @Override
    public boolean eliminar(ID id) {
        if (getRepositorio().existsById(id)) {
            getRepositorio().deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public T actualizar(T miEntidad) {
        return getRepositorio().save(miEntidad);
    }

}
