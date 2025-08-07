package com.academia.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pagamento {

    private int id;
    private Membro membro;
    private LocalDate dataPagamento;
    private BigDecimal valorPago;
    private LocalDate mesReferencia;
    private String statusPagamento;

    public Pagamento() {
    }

    public Pagamento(int id, Membro membro, LocalDate dataPagamento, BigDecimal valorPago, LocalDate mesReferencia, String statusPagamento) {
        this.id = id;
        this.membro = membro;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
        this.mesReferencia = mesReferencia;
        this.statusPagamento = statusPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Membro getMembro() {
        return membro;
    }

    public void setMembro(Membro membro) {
        this.membro = membro;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getMesReferencia() {
        return mesReferencia;
    }

    public void setMesReferencia(LocalDate mesReferencia) {
        this.mesReferencia = mesReferencia;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
}