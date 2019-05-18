package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should successfully read users'
    request {
        method GET()
        urlPath('/users') {
            queryParameters {
                parameter 'id', 1
                parameter 'name', 'name'
            }
        }
        headers {
            contentType applicationJson()
            accept applicationJson()
            header authorization(), execute('getAuthorizationHeader()')
        }
    }
    response {
        status OK()
        body([
                users: [
                        [
                                id  : 1,
                                name: 'name'
                        ]
                ]
        ])
    }
}
