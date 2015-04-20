package br.unisc.pos.infra;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    public abstract K getPrimaryKey();

    public abstract void setPrimaryKey(final K primaryKey);

}
