package silver.model;

import java.util.Date; 

public class Pedidos {
    private int id;
    private int idCliente;
    private Date dataPedido;
    private double total; 
    private String status;

    public Pedidos() {
    }

    // --- GETTERS E SETTERS ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public Date getDataPedido() { return dataPedido; }
    public void setDataPedido(Date dataPedido) { this.dataPedido = dataPedido; }

    // CORREÇÃO DO TOTAL:
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total; 
    }

    // CORREÇÃO DO STATUS:
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getIdPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}