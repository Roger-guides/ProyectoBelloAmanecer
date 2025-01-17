package belloamanecer.acceso.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fac_reservas database table.
 * 
 */
@Entity
@Table(name="fac_reservas")
@NamedQuery(name="FacReserva.findAll", query="SELECT f FROM FacReserva f")
public class FacReserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private Integer idreserva;

	@Column(nullable=false)
	private Integer estadopago;

	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	private Date fechareserva;

	@Column(nullable=false)
	private Time horareserva;

	//bi-directional many-to-one association to FacDetalle
	@OneToMany(mappedBy="facReserva")
	private List<FacDetalle> facDetalles;

	//bi-directional many-to-one association to FacParametro
	@ManyToOne
	@JoinColumn(name="descuento", nullable=false)
	private FacParametro facParametro;

	//bi-directional many-to-one association to InvUsuario
	@ManyToOne
	@JoinColumn(name="idusuario", nullable=false)
	private InvUsuario invUsuario;

	public FacReserva() {
	}

	public Integer getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(Integer idreserva) {
		this.idreserva = idreserva;
	}

	public Integer getEstadopago() {
		return this.estadopago;
	}

	public void setEstadopago(Integer estadopago) {
		this.estadopago = estadopago;
	}

	public Date getFechareserva() {
		return this.fechareserva;
	}

	public void setFechareserva(Date fechareserva) {
		this.fechareserva = fechareserva;
	}

	public Time getHorareserva() {
		return this.horareserva;
	}

	public void setHorareserva(Time horareserva) {
		this.horareserva = horareserva;
	}

	public List<FacDetalle> getFacDetalles() {
		return this.facDetalles;
	}

	public void setFacDetalles(List<FacDetalle> facDetalles) {
		this.facDetalles = facDetalles;
	}

	public FacDetalle addFacDetalle(FacDetalle facDetalle) {
		getFacDetalles().add(facDetalle);
		facDetalle.setFacReserva(this);

		return facDetalle;
	}

	public FacDetalle removeFacDetalle(FacDetalle facDetalle) {
		getFacDetalles().remove(facDetalle);
		facDetalle.setFacReserva(null);

		return facDetalle;
	}

	public FacParametro getFacParametro() {
		return this.facParametro;
	}

	public void setFacParametro(FacParametro facParametro) {
		this.facParametro = facParametro;
	}

	public InvUsuario getInvUsuario() {
		return this.invUsuario;
	}

	public void setInvUsuario(InvUsuario invUsuario) {
		this.invUsuario = invUsuario;
	}

}