package br.unisc.pos.infra;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
public abstract class BaseEntity<K> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "CET")
    @Column(name = "LOG_DATA_HORA_INCLUSAO", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraInclusao;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "CET")
    @Column(name = "LOG_DATA_HORA_ULT_ALTERACAO", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraUltimaAlteracao;

    public abstract K getId();

    public abstract void setId(final K id);

    public Date getDataHoraInclusao() {
        return dataHoraInclusao;
    }

    public void setDataHoraInclusao(Date dataHoraInclusao) {
        this.dataHoraInclusao = dataHoraInclusao;
    }

    public Date getDataHoraUltimaAlteracao() {
        return dataHoraUltimaAlteracao;
    }

    public void setDataHoraUltimaAlteracao(Date dataHoraUltimaAlteracao) {
        this.dataHoraUltimaAlteracao = dataHoraUltimaAlteracao;
    }
}
