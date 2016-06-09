package comercioeletronico

class Pedido {
    List<ListaProduto> itens = new ArrayList<ListaProduto>()
    static hasMany = [itens: ListaProduto]

    Date dataPedido
    static transients = ['total']

    BigDecimal getTotal() {
        itens.inject(0, { inicial, item ->
            return inicial + item.precoTotal
        })
    }

    static constraints = {
        itens minSize: 1
    }
}
