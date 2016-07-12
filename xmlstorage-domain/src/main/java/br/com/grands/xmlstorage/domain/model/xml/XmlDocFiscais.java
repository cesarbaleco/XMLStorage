package br.com.grands.xmlstorage.domain.model.xml;

import gumga.framework.domain.GumgaModel;
import gumga.framework.domain.GumgaMultitenancy;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import org.hibernate.envers.Audited;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Created by gelatti on 12/07/16.
 */
@GumgaMultitenancy
@SequenceGenerator(name = GumgaModel.SEQ_NAME, sequenceName = "SEQ_XMLDOCFISCAIS")
@Indexed
@Audited
@Entity
public class XmlDocFiscais extends GumgaModel<Long> {

    @Version
    @ApiModelProperty(hidden = true)
    private Integer version;
    @ApiModelProperty(value = "Salva o texto do xml", position = 2)
    private String xml;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }
}
