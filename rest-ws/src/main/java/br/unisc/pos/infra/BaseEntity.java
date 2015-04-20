package br.unisc.pos.infra;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract K getId();

    public abstract void setId(final K id);

}
