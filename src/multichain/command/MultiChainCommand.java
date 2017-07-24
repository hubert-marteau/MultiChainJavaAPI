/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class MultiChainCommand {
	private AddressCommand addressCommand;
	private BalanceCommand balanceCommand;
	private BlockCommand blockCommand;
	private GrantCommand grantCommand;
	private IssueCommand issueCommand;
	private RAWTransactionCommand rawTransactionCommand;
	private StreamCommand streamCommand;
	private WalletTransactionCommand walletTransactionCommand;

	/**
	 * 
	 */
	public MultiChainCommand(String chainName) {
		super();
		addressCommand = new AddressCommand(chainName);
		balanceCommand = new BalanceCommand(chainName);
		blockCommand = new BlockCommand(chainName);
		grantCommand = new GrantCommand(chainName);
		issueCommand = new IssueCommand(chainName);
		rawTransactionCommand = new RAWTransactionCommand(chainName);
		streamCommand = new StreamCommand(chainName);
		walletTransactionCommand = new WalletTransactionCommand(chainName);
	}

	/**
	 * @return the issueCommand
	 */
	public IssueCommand getIssueCommand() {
		return issueCommand;
	}

	/**
	 * @param issueCommand
	 *            the issueCommand to set
	 */
	public void setIssueCommand(IssueCommand issueCommand) {
		this.issueCommand = issueCommand;
	}

	/**
	 * @return the streamCommand
	 */
	public StreamCommand getStreamCommand() {
		return streamCommand;
	}

	/**
	 * @param streamCommand
	 *            the streamCommand to set
	 */
	public void setStreamCommand(StreamCommand streamCommand) {
		this.streamCommand = streamCommand;
	}

	/**
	 * @return the rawTransactionCommand
	 */
	public RAWTransactionCommand getRawTransactionCommand() {
		return rawTransactionCommand;
	}

	/**
	 * @param rawTransactionCommand
	 *            the rawTransactionCommand to set
	 */
	public void setRawTransactionCommand(RAWTransactionCommand rawTransactionCommand) {
		this.rawTransactionCommand = rawTransactionCommand;
	}

	/**
	 * @return the addressCommand
	 */
	public AddressCommand getAddressCommand() {
		return addressCommand;
	}

	/**
	 * @param addressCommand
	 *            the addressCommand to set
	 */
	public void setAddressCommand(AddressCommand addressCommand) {
		this.addressCommand = addressCommand;
	}

	/**
	 * @return the balanceCommand
	 */
	public BalanceCommand getBalanceCommand() {
		return balanceCommand;
	}

	/**
	 * @param balanceCommand
	 *            the balanceCommand to set
	 */
	public void setBalanceCommand(BalanceCommand balanceCommand) {
		this.balanceCommand = balanceCommand;
	}

	/**
	 * @return the blockCommand
	 */
	public BlockCommand getBlockCommand() {
		return blockCommand;
	}

	/**
	 * @param blockCommand
	 *            the blockCommand to set
	 */
	public void setBlockCommand(BlockCommand blockCommand) {
		this.blockCommand = blockCommand;
	}

	/**
	 * @return the grantCommand
	 */
	public GrantCommand getGrantCommand() {
		return grantCommand;
	}

	/**
	 * @param grantCommand
	 *            the grantCommand to set
	 */
	public void setGrantCommand(GrantCommand grantCommand) {
		this.grantCommand = grantCommand;
	}

	/**
	 * @return the walletTransactionCommand
	 */
	public WalletTransactionCommand getWalletTransactionCommand() {
		return walletTransactionCommand;
	}

	/**
	 * @param walletTransactionCommand
	 *            the walletTransactionCommand to set
	 */
	public void setWalletTransactionCommand(WalletTransactionCommand walletTransactionCommand) {
		this.walletTransactionCommand = walletTransactionCommand;
	}

}
