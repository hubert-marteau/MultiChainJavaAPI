package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.tools.MultichainTestParameter;

public class QueryBuilderMessaging extends QueryBuilderCommon {

	/**
	 * Verifies that message was approved by the owner of address by checking the
	 * base64-encoded digital signature provided.
	 * 
	 * @param address
	 *            (String, required) The owner address
	 * @param signature
	 *            (String, required) The base64-encoded digital signature to check
	 * @param message
	 *            (String, required) The message
	 * @return (Boolean) True if the message is approved, else false
	 * @throws MultichainException
	 */
	protected Object executeVerifyMessage(String address, String signature, String message) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("address", address);
		MultichainTestParameter.isNotNullOrEmpty("signature", signature);
		MultichainTestParameter.isNotNullOrEmpty("message", message);
		return execute(CommandEnum.VERIFYMESSAGE, address, signature, message);
	}

	/**
	 * Returns a base64-encoded digital signature which proves that message was
	 * approved by the owner of the address or any other private key given in
	 * addressORPrivateKey.
	 * 
	 * @param addressORPrivateKey
	 *            (String, required) The address or the private key (which must
	 *            belong to this wallet)
	 * @param message
	 *            (String, required) The message to approved
	 * @return (String) The base64-encoded digital signature
	 * @throws MultichainException
	 */
	protected Object executeSignMessage(String addressORPrivKey, String message) throws MultichainException {
		MultichainTestParameter.isNotNullOrEmpty("addressORPrivKey", addressORPrivKey);
		MultichainTestParameter.isNotNullOrEmpty("message", message);
		return execute(CommandEnum.SIGNMESSAGE, addressORPrivKey, message);
	}
}