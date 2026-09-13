package silver.model;

public class Produto {
    private int id;
    private double valorCusto;
    private String descricao;
    private String nome;
    double valorVenda;
    int quantidadeEstoque;
    String codigoBarra;

    public Produto() {}

    public Produto(String nome, double valorVenda, int quantidadeEstoque, String codigoBarra) {
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.quantidadeEstoque = quantidadeEstoque;
        this.codigoBarra = codigoBarra;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValorCusto() { return valorCusto; }
    public void setValorCusto(double valorCusto) { this.valorCusto = valorCusto; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getValorVenda() { return valorVenda; }
    public void setValorVenda(double valorVenda) { this.valorVenda = valorVenda; }

    public int getQuantidadeEstoque() { return quantidadeEstoque; }
    public void setQuantidadeEstoque(int quantidadeEstoque) { this.quantidadeEstoque = quantidadeEstoque; }

    public String getCodigoBarra() { return codigoBarra; }
    public void setCodigoBarra(String codigoBarra) { this.codigoBarra = codigoBarra; }

    public boolean reduzirEstoque(int qtd) {
        if (this.quantidadeEstoque >= qtd) {
            this.quantidadeEstoque -= qtd;
            return true;
        }
        return false;
    }
}