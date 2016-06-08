package comercioeletronico

class ListaProduto {

    Produto produto
    Integer quantidade

    static transients = ['precoTotal']

    BigDecimal getPrecoTotal() {
        return quantidade * produto.preco
    }

    static constraints = {
    }
}
