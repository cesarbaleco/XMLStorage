package br.com.grands.xmlstorage.presentation.api.xml;

import br.com.grands.xmlstorage.domain.model.xml.DocFiscais;
import gumga.framework.application.GumgaService;
import gumga.framework.presentation.GumgaAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
