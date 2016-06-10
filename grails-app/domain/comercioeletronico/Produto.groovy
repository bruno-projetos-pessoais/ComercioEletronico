package comercioeletronico

import grails.rest.Resource

@Resource(uri = '/produto', formats = ['html','json', 'xml'])
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
