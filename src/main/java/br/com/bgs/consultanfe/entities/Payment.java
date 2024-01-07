package br.com.bgs.consultanfe.entities;

public enum Payment {
    DINHEIRO(1),
    CREDITO(3),
    DEBITO(4),
    VALE_ALIMENTACAO(10);

    private final Integer code;

    Payment(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
