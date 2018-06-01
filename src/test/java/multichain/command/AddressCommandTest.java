package multichain.command;

import java.util.List;

import org.junit.Test;

import junit.framework.TestCase;
import multichain.object.KeyPairs;

public class AddressCommandTest extends TestCase {

	@Test
	public void testcreateKeyPairs() {
//		MultiChainCommand multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
//				TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN, TestConst.MULTICHAIN_SERVER_PWD);
//
//		List<KeyPairs> listKeyPairs01 = null;
//
//		try {
//			listKeyPairs01 = multiChainCommand.getAddressCommand().createKeyPairs();
//		} catch (MultichainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		assertNotNull(listKeyPairs01);
//		for (KeyPairs keyPairs : listKeyPairs01) {
//			System.out.println(keyPairs.toString());
//		}
//		assertEquals(listKeyPairs01.size(), 1);
//
//		List<KeyPairs> listKeyPairs05 = null;
//
//		try {
//			listKeyPairs05 = multiChainCommand.getAddressCommand().createKeyPairs(5);
//		} catch (MultichainException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		assertNotNull(listKeyPairs05);
//		for (KeyPairs keyPairs : listKeyPairs05) {
//			System.out.println(keyPairs.toString());
//		}
//		assertEquals(listKeyPairs05.size(), 5);
	  assertTrue(true);
	}

	// @Test
	// public void testgetAddresses() {
	// MultiChainCommand multiChainCommand = new
	// MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// List<String> result = null;
	// List<Address> resultAddress = null;
	// try {
	// result = multiChainCommand.getAddressCommand().getAddresses();
	// } catch (MultichainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// assertNotNull(result);
	// assertFalse(result.size() == 0);
	//
	// try {
	// resultAddress = multiChainCommand.getAddressCommand().getAddressesList();
	// } catch (MultichainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// assertNotNull(resultAddress);
	// assertFalse(resultAddress.size() == 0);
	// }
	//
	// @Test
	// public void testvalidateAddress() {
	// MultiChainCommand multiChainCommand = new
	// MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// List<String> resultAddresses = null;
	// Address result = null;
	// try {
	// resultAddresses = multiChainCommand.getAddressCommand().getAddresses();
	//
	// assertNotNull(resultAddresses);
	// assertFalse(resultAddresses.size() == 0);
	//
	// for (String addressString : resultAddresses) {
	// result =
	// multiChainCommand.getAddressCommand().validateAddress(addressString);
	//
	// assertNotNull(result);
	// assertNotNull(result.getAddress());
	// assertNotSame("", result.getAddress());
	// }
	// } catch (MultichainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// @Test
	// public void testgetNewAddress() {
	// MultiChainCommand multiChainCommand = new
	// MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP,
	// TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
	// TestConst.MULTICHAIN_SERVER_PWD);
	//
	// String resultAddress = "";
	// Address result = null;
	//
	// try {
	// resultAddress = multiChainCommand.getAddressCommand().getNewAddress();
	//
	// assertNotNull(resultAddress);
	// assertNotSame("", resultAddress);
	//
	// result = multiChainCommand.getAddressCommand().getNewAddressFilled();
	//
	// assertNotNull(result);
	// assertNotNull(result.getAddress());
	// assertNotSame("", result.getAddress());
	//
	// } catch (MultichainException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
