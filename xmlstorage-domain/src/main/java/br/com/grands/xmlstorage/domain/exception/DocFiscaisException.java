package br.com.grands.xmlstorage.domain.exception;

/**
 * Created by gelatti on 29/07/16.
 */
public class DocFiscaisException extends RuntimeException {

    /**
     * @param message mensagem que será emitada na exceção
     */
    public DocFiscaisException(String message) {
        super(message);
    }
}
