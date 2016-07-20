package br.com.grands.xmlstorage.application.service.xml;

import br.com.grands.xmlstorage.application.service.AbstractTest;
import br.com.grands.xmlstorage.domain.model.xml.DocFiscais;
import br.com.grands.xmlstorage.domain.model.xml.XmlDocFiscais;
import br.com.grands.xmlstorage.domain.model.xml.enums.TipoEvento;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by gelatti on 13/07/16.
 */
public class DocFiscaisServiceTest extends AbstractTest {

    @Autowired
    private DocFiscaisService docFiscaisService;

    private DocFiscais docFiscais;
    private XmlDocFiscais xmlDocFiscais;

    @Before
    public void setUp() {
        docFiscais = new DocFiscais();
        docFiscais.setChave("41160707219056000180651500000000011300200818");
        docFiscais.setData(new Date());
        docFiscais.setProtocolo("Protocolo Teste");
        docFiscais.setTipoEvento(TipoEvento.AUTORIZACAO);
        xmlDocFiscais = new XmlDocFiscais();
        xmlDocFiscais.setXml("<teste>dfsdfsdfsdfsdfds</teste>");
        docFiscais.setXml(xmlDocFiscais);
    }

    @Test
    public void testSave() {
        assertNotNull(docFiscaisService.save(docFiscais));
    }

    @Test
    public void getByChave() {
        assertNotNull(docFiscaisService.save(docFiscais));
        DocFiscais fiscais = docFiscaisService.getByChave(docFiscais.getChave());
        assertNotNull(fiscais);
        assertEquals(docFiscais.getChave(), fiscais.getChave());
    }

    @After
    public void tearDown() {
        try {
            docFiscaisService.delete(docFiscais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
