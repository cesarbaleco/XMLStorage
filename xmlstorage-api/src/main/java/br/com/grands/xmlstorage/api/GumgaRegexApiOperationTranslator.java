package br.com.grands.xmlstorage.api;

import gumga.framework.security.ApiOperationTranslator;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GumgaRegexApiOperationTranslator implements ApiOperationTranslator {

    private final List<OperationExpression> operations = Arrays.asList(
            new OperationExpression("ALL_OPERATIONS", ".*", ".*")
    );

    @Override
    public String getOperation(String url, String method) {
        for (OperationExpression oe : operations) {
            if (url.matches(oe.getUrl()) && method.matches(oe.getMethod())) {
                return oe.getOperation();
            }
        }
        return "NOOP";

    }

    class OperationExpression {

        private String url, method, operation;

        public OperationExpression(String operation, String url, String method) {
            this.url = url;
            this.method = method;
            this.operation = operation;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public String getOperation() {
            return operation;
        }

        public void setOperation(String operation) {
            this.operation = operation;
        }
    }

}
