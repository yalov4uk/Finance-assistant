package contracts.user

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should successfully create user'
    request {
        method POST()
        urlPath '/users'
        headers {
            contentType applicationJsonUtf8()
            accept applicationJsonUtf8()
        }
        body([
                user: [
                        name: 'name'
                ]
        ])
    }
    response {
        status CREATED()
        headers {
            header location(), regex(~/.*\/users\?id=\d+/)
        }
    }
}