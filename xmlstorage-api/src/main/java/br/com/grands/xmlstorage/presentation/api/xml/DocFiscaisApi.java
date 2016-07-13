package br.com.grands.xmlstorage.presentation.api.xml;

import br.com.grands.xmlstorage.application.service.xml.DocFiscaisService;
import br.com.grands.xmlstorage.domain.model.xml.DocFiscais;
import gumga.framework.application.GumgaService;
import gumga.framework.presentation.GumgaAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gelatti on 12/07/16.
 */
@RestController
@RequestMapping("/api/docfiscais")
public class DocFiscaisApi extends GumgaAPI<DocFiscais, Long> {

    @Autowired
    public DocFiscaisApi(GumgaService<DocFiscais, Long> service) {
        super(service);
    }

    @Transactional
    @RequestMapping(method = RequestMethod.GET, value = "/getbychave", params = "chave")
    public DocFiscais getByChave(@RequestParam("chave") String chave) {
        return ((DocFiscaisService)service).getByChave(chave);
    }
}
