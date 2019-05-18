package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should successfully read users'
    request {
        method GET()
        urlPath('/users') {
            queryParameters {
                parameter 'id', 1
            }
        }
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
            header authorization(), $(c(~/Bearer \{"userId":1,"roles":\[.*?]}/),
                    p(execute('getAuthorizationHeader()')))
        }
    }
    response {
        status OK()
        headers {
            contentType applicationJsonUtf8()
        }
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
