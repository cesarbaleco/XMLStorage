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
        xmlDocFiscais.setXml("<NFe xmlns='v3a10.edge.wrapperxml.nfe.edge.datacoper.com'><infNFe Id='NFe41160707219056000180651500000000011300200818' " +
                "versao='3.10' xmlns='v3a10.edge.wrapperxml.nfe.edge.datacoper.com'><ide><cUF>41</cUF><natOp>Venda Simples" +
                "</natOp><indPag>0</indPag><mod>65</mod><serie>150</serie><nNF>1</nNF><dhEmi>2016-07-13T10:19:18-03:00</dhEmi>" +
                "<tpNF>1</tpNF><idDest>1</idDest><cMunFG>4105508</cMunFG><tpImp>4</tpImp><tpEmis>1</tpEmis><finNFe>1</finNFe>" +
                "<indFinal>1</indFinal><indPres>1</indPres></ide><emit><CNPJ>07219056000180</CNPJ><xNome>G Grands Informática Ltda.</xNome>" +
                "<xFant>Grands</xFant><enderEmit><xLgr>Avenida Espirito Santo</xLgr><nro>786</nro><xCpl>Grands</xCpl><xBairro>Zona 1</xBairro>" +
                "<cMun>4105508</cMun><xMun>Cianorte</xMun><UF>PR</UF><CEP>87200059</CEP><cPais>1058</cPais><xPais>Brasil</xPais>" +
                "</enderEmit><IE>9039419286</IE><CRT>3</CRT></emit><det nItem='1'><prod><cProd>2</cProd><cEAN></cEAN><xProd>" +
                "NOTA FISCAL EMITIDA EM AMBIENTE DE HOMOLOGACAO - SEM VALOR FISCAL</xProd><NCM>01012100</NCM><CFOP>5102</CFOP>" +
                "<uCom>Un</uCom><qCom>10.0000</qCom><vUnCom>125.0000000000</vUnCom><vProd>1250.00</vProd><cEANTrib></cEANTrib>" +
                "<uTrib>Un</uTrib><qTrib>10.0000</qTrib><vUnTrib>125.0000000000</vUnTrib><indTot>1</indTot></prod><imposto><ICMS>" +
                "<ICMS00><orig>0</orig><CST>00</CST><modBC>0</modBC><vBC>125.00</vBC><pICMS>18.0000</pICMS><vICMS>22.50</vICMS>" +
                "</ICMS00></ICMS><PIS><PISAliq><CST>01</CST><vBC>125.00</vBC><pPIS>0.1300</pPIS><vPIS>0.16</vPIS></PISAliq></PIS>" +
                "<COFINS><COFINSAliq><CST>01</CST><vBC>125.00</vBC><pCOFINS>3.0000</pCOFINS><vCOFINS>3.75</vCOFINS></COFINSAliq>" +
                "</COFINS></imposto></det><total><ICMSTot><vBC>125.00</vBC><vICMS>22.50</vICMS><vICMSDeson>0.00</vICMSDeson><vBCST>0.00</vBCST>" +
                "<vST>0.00</vST><vProd>1250.00</vProd><vFrete>0.00</vFrete><vSeg>0.00</vSeg><vDesc>0.00</vDesc><vII>0.00</vII><vIPI>0.00</vIPI>" +
                "<vPIS>0.16</vPIS><vCOFINS>3.75</vCOFINS><vOutro>0.00</vOutro><vNF>1250.00</vNF></ICMSTot></total><transp><modFrete>9</modFrete>" +
                "</transp><pag><tPag>04</tPag><vPag>1250.00</vPag><card CNPJ_Opc='99999999999999' cAut_Opc='999999999' tpIntegra_Opc='02' tBand_Opc='99'>" +
                "<tBandOpc>OUTROS</tBandOpc><tpIntegraOpc>NAO_INTEGRADO</tpIntegraOpc></card></pag><infAdic><infCpl>Trib aprox R: 77.50 " +
                "Federal importado, R:52.50 Federal nacional, R:0.00 Estadual e R:0.00 Municipal, Fonte: IBPT ca7gi3;</infCpl></infAdic></infNFe></NFe>");
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
