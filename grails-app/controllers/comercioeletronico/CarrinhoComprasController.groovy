package comercioeletronico

import grails.converters.JSON
import grails.validation.ValidationException

class CarrinhoComprasController {

    static responseFormats = ['json', 'xml']
    static scope = "session"
    CarrinhoCompras carrinhoCompras = new CarrinhoCompras()
    def messageSource
    def pedidoService
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

    def removerProduto(Produto produto) {
        try {
            carrinhoCompras.removerProduto(produto)
        }
        catch (Exception e) {
            render([erro: e.message] as JSON)
            return
        }
        render([sucesso: "Produto removido com sucesso"] as JSON)

    }

    def finalizarCarrinho() {
        try {
            pedidoService.registrarPedido(carrinhoCompras)
        }
        catch (ValidationException e) {
            def erros = e.errors.allErrors.inject([], { listaErros, erro ->
                (listaErros << messageSource.getMessage(erro, Locale.default))
            })

            render(erros as JSON)
            return
        }
        carrinhoCompras = new ArrayList<ListaProduto>()
        render([sucesso: "Pedido finalizado com sucesso"])
    }
}
