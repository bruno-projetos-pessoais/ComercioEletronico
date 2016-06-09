package comercioeletronico

import grails.converters.JSON

class CarrinhoComprasController {

    static responseFormats = ['json', 'xml']
    static scope = "session"
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()

    def index() {
        respond carrinhoCompras
    }
}
