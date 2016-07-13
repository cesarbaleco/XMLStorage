package br.com.grands.xmlstorage.application.service.xml;

import br.com.grands.xmlstorage.application.repository.xml.DocFiscaisRepository;
import br.com.grands.xmlstorage.domain.model.xml.DocFiscais;
import gumga.framework.application.GumgaService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gelatti on 12/07/16.
 */
@Service
public class DocFiscaisService extends GumgaService<DocFiscais, Long> {

    private DocFiscaisRepository docFiscaisRepository;

    @Autowired
    public DocFiscaisService(DocFiscaisRepository repository) {
        super(repository);
        this.docFiscaisRepository = repository;
    }

    @Transactional
    public DocFiscais getByChave(String chave) {
        DocFiscais docFiscais = docFiscaisRepository.getByChave(chave);
        Hibernate.initialize(docFiscais.getXml());
        return docFiscais;
    }
}
