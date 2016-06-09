package comercioeletronico

class CarrinhoCompras {

    def messageSource

    List<ListaProduto> itens = new ArrayList<ListaProduto>()

    static hasMany = [itens: ListaProduto]

    static mapWith = "none"

    static transients = ['numeroItens', 'precoTotal']

    void adicionarProduto(ListaProduto listaProduto) {
        ListaProduto itemExistente = itens.find { item -> item.produto.id == listaProduto.produto.id }
        if (itemExistente) {
            itemExistente.quantidade += listaProduto.quantidade
            return
        }
        this.itens.add(listaProduto)
    }

    Integer getNumeroItens() {
        return itens.size()
    }

    BigDecimal getPrecoTotal() {
        itens.inject(0, { inicial, item ->
            return inicial + item.precoTotal
        })
    }

    static constraints = {
    }
}
