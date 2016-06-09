package comercioeletronico

import grails.transaction.Transactional
import grails.validation.ValidationException

@Transactional
class PedidoService {

    Pedido registrarPedido(CarrinhoCompras carrinhoCompras) {
        Pedido novoPedido = new Pedido(carrinhoCompras.properties)
        if (!novoPedido.save()) {
            throw new ValidationException("", novoPedido.errors)
        }
        return novoPedido

    }
}
