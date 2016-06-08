package comercioeletronico

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ListaProduto)
class ListaProdutoSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    @Unroll("Quando o preço do produto é #preco e a quantidade é #quantidade, o preço total é: #precoEsperado")
    void "Retornar preço total"() {
        when: "Criar um produto"
        def produto = new Produto(preco: preco)

        and: "Criar uma lista produto"
        def listaProduto = new ListaProduto(produto: produto, quantidade: quantidade)

        then: "Preço calculado é igual ao preço esperado"
        listaProduto.precoTotal == precoEsperado

        where:
        preco | quantidade || precoEsperado
        10    | 5          || 50
        8     | 0          || 0
        56.75 | 5          || 283.75
    }
}
