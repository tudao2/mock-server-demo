package contracts.testapi

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        url ('/users') {
            queryParameters {
                parameter('id', '123')
            }
        }
//        body([
//                "name": $(regex('.*'))
//        ])
//        headers {
//            contentType('application/json')
//        }
    }
    response {
        status OK()
        body([
                "name": "tu"
        ])
        headers {
            contentType('application/json')
        }
    }
}
