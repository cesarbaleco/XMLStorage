package br.com.grands.xmlstorage.application.service.xml;

import br.com.grands.xmlstorage.application.repository.xml.DocFiscaisRepository;
import br.com.grands.xmlstorage.domain.model.xml.DocFiscais;
import gumga.framework.application.GumgaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by gelatti on 12/07/16.
 */
@Service
public class DocFiscaisService extends GumgaService<DocFiscais, Long> {

    private DocFiscaisRepository repository;

    @Autowired
    public DocFiscaisService(DocFiscaisRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
