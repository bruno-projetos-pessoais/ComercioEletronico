package comercioeletronico

import grails.rest.RestfulController

class PedidoController extends RestfulController<Pedido> {

    static responseFormats = ['json', 'xml']

    PedidoController() {
        super(Pedido.class, true)
    }
}
