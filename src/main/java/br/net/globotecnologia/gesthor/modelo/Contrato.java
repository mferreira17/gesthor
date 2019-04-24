package br.net.globotecnologia.gesthor.modelo;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 7)
    private Integer numero;

    @Column(length = 4, nullable = false)
    private Integer ano;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataAssinatura;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date inicioVigencia;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date finalVigencia;

    @Column(precision = 2, scale = 3, length = 10, columnDefinition = "DECIMAL", nullable = false)
    @NumberFormat(style = Style.NUMBER, pattern = "#.###.###.###,##")
    private BigDecimal valor;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false, length = 200)
    private String objeto;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Gestor gestor;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Gestor fiscal;

    public Long getId() {

        return this.id;
    }

    public void setId(final Long id) {

        this.id = id;
    }

    public Integer getNumero() {

        return this.numero;
    }

    public void setNumero(final Integer numero) {

        this.numero = numero;
    }

    public Integer getAno() {

        return this.ano;
    }

    public void setAno(final Integer ano) {

        this.ano = ano;
    }

    public Date getDataAssinatura() {

        return this.dataAssinatura;
    }

    public void setDataAssinatura(final Date dataAssinatura) {

        this.dataAssinatura = dataAssinatura;
    }

    public Date getInicioVigencia() {

        return this.inicioVigencia;
    }

    public void setInicioVigencia(final Date inicioVigencia) {

        this.inicioVigencia = inicioVigencia;
    }

    public Date getFinalVigencia() {

        return this.finalVigencia;
    }

    public void setFinalVigencia(final Date finalVigencia) {

        this.finalVigencia = finalVigencia;
    }

    public BigDecimal getValor() {

        return this.valor;
    }

    public void setValor(final BigDecimal valor) {

        this.valor = valor;
    }

    public Status getStatus() {

        return this.status;
    }

    public void setStatus(final Status status) {

        this.status = status;
    }

    public String getObjeto() {

        return this.objeto;
    }

    public void setObjeto(final String objeto) {

        this.objeto = objeto;
    }

    public Empresa getEmpresa() {

        return this.empresa;
    }

    public void setEmpresa(final Empresa empresa) {

        this.empresa = empresa;
    }

    public Gestor getGestor() {

        return this.gestor;
    }

    public void setGestor(final Gestor gestor) {

        this.gestor = gestor;
    }

    public Gestor getFiscal() {

        return this.fiscal;
    }

    public void setFiscal(final Gestor fiscal) {

        this.fiscal = fiscal;
    }

}
