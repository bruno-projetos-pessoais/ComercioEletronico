package comercioeletronico

class Produto {

    String sku
    String titulo
    String descricao
    BigDecimal preco

    static mapping = {
        descricao type: 'text'
    }

    static constraints = {

    }
}
