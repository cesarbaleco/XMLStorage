package br.com.grands.xmlstorage.domain.model.xml.enums;

/**
 * Created by gelatti on 12/07/16.
 */
public enum TipoEvento {

    AUTORIZACAO("Autorização de Uso"),
    CANCELAMENTO("Cancelamento"),
    CARTACORRECAOELETRONICA("Carta de correção eletronica"),
    CIENCIAOPERACAO("Ciência da operação"),
    CONFIRMACAOOPERACAO("Confirmação da operação"),
    OPERACAONAOREALIZADA("Operação não realizada"),
    DESCONHECIMENTOOPERACAO("Desconhecimento da operação");

    private final String label;

    TipoEvento(String label) {
        this.label = label;
    }

    public String getName(){
        return this.name();
    }

    public String getLabel() {
        return label;
    }

}
