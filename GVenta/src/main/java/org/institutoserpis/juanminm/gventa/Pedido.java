package org.institutoserpis.juanminm.gventa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "pedido")
public class Pedido {
	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	@JoinColumn(name = "cliente",
	foreignKey = @ForeignKey(name = "pedido_ibfk_1")
	)
	private Cliente cliente;

	@Column(name = "`fecha`")
	private String fecha;

	@Column(name = "`importe`")
	private BigDecimal importe;

    @OneToMany(mappedBy = "pedido", cascade=CascadeType.ALL,
    		orphanRemoval=true)
    private List<PedidoLinea> pedidoLineas = new ArrayList<>();

	public Pedido() {
	}

	public Pedido(Cliente cliente, String fecha, BigDecimal importe) {
		this.cliente = cliente;
		this.fecha = fecha;
		this.importe = importe;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	public PedidoLinea[] getPedidoLineas() {
		return pedidoLineas.toArray(new PedidoLinea[pedidoLineas.size()]);
		//return pedidoLineas;
	}

	public void add(PedidoLinea pedidoLinea) {
		pedidoLineas.add(pedidoLinea);
	}

	@Override
	public String toString() {
		return String.format("[%s] %s %s ($s)", id, cliente, fecha, importe);
	}

}
