package br.com.grands.xmlstorage.domain.model.xml;

import br.com.grands.xmlstorage.domain.model.xml.enums.TipoEvento;
import gumga.framework.domain.GumgaModel;
import gumga.framework.domain.GumgaMultitenancy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gelatti on 12/07/16.
 */
@GumgaMultitenancy
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_DOCFISCAIS")
@Indexed
@Audited
@Entity
public class DocFiscais extends GumgaModel<Long> {

    @Version
    @ApiModelProperty(hidden = true)
    private Integer version;
    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Armazena o tipo de evento do xml que esta sendo salvo", position = 1)
    private TipoEvento tipoEvento;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @ApiModelProperty(value = "Armazena o xml", position = 2)
    private XmlDocFiscais xml;
    @ApiModelProperty(value = "Armazena a chave de acesso do xml", position = 3)
    private String chave;
    @ApiModelProperty(value = "Armazena o protocolo do xml", position = 4)
    private String protocolo;
    @ApiModelProperty(value = "Armazena a data que foi gravado o xml", position = 5)
    private Date data;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getProtocolo() {
        return protocolo;
    }

    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public XmlDocFiscais getXml() {
        return xml;
    }

    public void setXml(XmlDocFiscais xml) {
        this.xml = xml;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
