package com.empresa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idcliente;

	private String miembro;

	//bi-directional many-to-one association to Beneficiario
	@OneToMany(mappedBy="cliente", cascade = CascadeType.ALL)
	private List<Beneficiario> beneficiarios;

	//bi-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="idpersona")
	private Persona persona;

	//bi-directional many-to-one association to Cuenta
	@OneToMany(mappedBy="cliente")
	private List<Cuenta> cuentas;

	//bi-directional many-to-one association to Referencia
	@OneToMany(mappedBy="cliente")
	private List<Referencia> referencias;

	public Cliente() {
	}

	public int getIdcliente() {
		return this.idcliente;
	}

	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public String getMiembro() {
		return this.miembro;
	}

	public void setMiembro(String miembro) {
		this.miembro = miembro;
	}

	public List<Beneficiario> getBeneficiarios() {
		return this.beneficiarios;
	}

	public void setBeneficiarios(List<Beneficiario> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

	public Beneficiario addBeneficiario(Beneficiario beneficiario) {
		getBeneficiarios().add(beneficiario);
		beneficiario.setCliente(this);

		return beneficiario;
	}

	public Beneficiario removeBeneficiario(Beneficiario beneficiario) {
		getBeneficiarios().remove(beneficiario);
		beneficiario.setCliente(null);

		return beneficiario;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public Cuenta addCuenta(Cuenta cuenta) {
		getCuentas().add(cuenta);
		cuenta.setCliente(this);

		return cuenta;
	}

	public Cuenta removeCuenta(Cuenta cuenta) {
		getCuentas().remove(cuenta);
		cuenta.setCliente(null);

		return cuenta;
	}

	public List<Referencia> getReferencias() {
		return this.referencias;
	}

	public void setReferencias(List<Referencia> referencias) {
		this.referencias = referencias;
	}

	public Referencia addReferencia(Referencia referencia) {
		getReferencias().add(referencia);
		referencia.setCliente(this);

		return referencia;
	}

	public Referencia removeReferencia(Referencia referencia) {
		getReferencias().remove(referencia);
		referencia.setCliente(null);

		return referencia;
	}

}