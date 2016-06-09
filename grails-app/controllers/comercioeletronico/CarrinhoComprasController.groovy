package comercioeletronico

import grails.converters.JSON

class CarrinhoComprasController {

    static responseFormats = ['json', 'xml']
    static scope = "session"
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()
    def messageSource
    static allowedMethods = [index: 'GET', adicionarProduto: 'POST']

    def index() {
        respond carrinhoCompras
    }

    def adicionarProduto(ListaProduto listaProduto) {
        if (!listaProduto.validate()) {
            def erros = listaProduto.errors.allErrors.inject([], { listaErros, erro ->
                (listaErros << messageSource.getMessage(erro, null))
            })
            render erros as JSON
            return
        }
        carrinhoCompras.adicionarProduto(listaProduto)
        render([mensagem: "Produto adicionado com sucesso"] as JSON)
    }
}
