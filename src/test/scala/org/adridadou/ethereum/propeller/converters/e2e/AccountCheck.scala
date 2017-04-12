package org.adridadou.ethereum.propeller.converters.e2e

import java.io.File

import org.adridadou.ethereum.propeller.CoreEthereumFacadeProvider
import org.adridadou.ethereum.propeller.backend.{EthereumTest, TestConfig}
import org.adridadou.ethereum.propeller.keystore.AccountProvider
import org.adridadou.ethereum.propeller.values._
import org.scalacheck.Arbitrary._
import org.scalacheck.Prop._
import org.scalatest.check.Checkers
import org.scalatest.{FlatSpec, Matchers}

/**
  * Created by davidroon on 26.03.17.
  * This code is released under Apache 2 license
  */
class AccountCheck extends FlatSpec with Matchers with Checkers {

  "The account type" should "be converted into an address and then encoded and the address should be decoded properly" in {
    val mainAccount = AccountProvider.fromSeed("test")
    val facade = CoreEthereumFacadeProvider.create(new EthereumTest(TestConfig.builder().balance(mainAccount, EthValue.ether(10000000)).build()))
    val contract = facade.compile(SoliditySourceFile.from(new File("src/test/resources/conversionContract.sol"))).get().findContract("myContract").get()
    val contractAddress = facade.publishContract(contract, mainAccount).get()

    val contractObject = facade.createContractProxy(contract, contractAddress, mainAccount, classOf[AccountContract])
    check(forAll(arbitrary[BigInt])(checkEncode(contractObject, _)))
  }

  private def checkEncode(contractObject: AccountContract, seed: BigInt) = {
    val account = new EthAccount(seed.bigInteger)
    contractObject.addressFunc(account) shouldEqual account.getAddress
    true
  }

}

trait AccountContract {
  def addressFunc(account: EthAccount): EthAddress
}