package contracts.credential

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name 'should successfully create credential'
    request {
        method POST()
        urlPath '/credentials'
        headers {
            contentType applicationJson()
            accept applicationJson()
            header authorization(), execute('getAuthorizationHeader()')
        }
        body([
                credential: [
                        username: 'username',
                        password: 'password',
                        userId  : 4
                ]
        ])
    }
    response {
        status CREATED()
        body(
                userProfile: [
                        fullName          : 'Jane Doe',
                        firstName         : 'Jane',
                        lastName          : 'Doe',
                        email             : 'jane.doe.idseih2@gmail.com',
                        federatedId       : 'gb00a88a-5a51-5ff1-e1b5-50134f8c9f23',
                        isSubscribed      : 'N',
                        companyInformation: [
                                federatedId: 'gb0082c2-71e2-b1da-4d21-24d74b6c21e2',
                                bfoId      : '0011100001dIm6dAAC',
                                name       : 'Jane Doe Ltd'
                        ]
                ],
                accessToken: '921946e6ad03b29fb51eaaafc400ba7a',
                refreshToken: '921946e6ad03b29fb51eaaafc400ba7a'
        )
    }
}
