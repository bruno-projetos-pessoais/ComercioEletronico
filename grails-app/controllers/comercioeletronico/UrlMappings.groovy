package comercioeletronico

class UrlMappings {

    static mappings = {
        "/pedido"(resources: "pedido")
        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
