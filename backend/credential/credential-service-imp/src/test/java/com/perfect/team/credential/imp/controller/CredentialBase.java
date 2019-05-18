package com.perfect.team.credential.imp.controller;

import static org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode.LOCAL;

import com.perfect.team.common.contract.ContractBaseTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;

@AutoConfigureStubRunner(ids = "com.perfect.team:user-service-imp", stubsMode = LOCAL)
public abstract class CredentialBase extends ContractBaseTest {

}
