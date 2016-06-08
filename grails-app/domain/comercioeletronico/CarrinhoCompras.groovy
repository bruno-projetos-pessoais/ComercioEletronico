package comercioeletronico

class CarrinhoCompras {

    ArrayList<ListaProduto> itens = new ArrayList<ListaProduto>()

    static hasMany = [itens: ListaProduto]

    static mapWith = "none"

    static transients = ['numeroItens', 'precoTotal']

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
