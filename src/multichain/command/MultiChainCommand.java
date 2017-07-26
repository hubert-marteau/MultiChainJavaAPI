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
 * @version 3.0
 */
public class MultiChainCommand {
	private AddressCommand addressCommand;
	private BalanceCommand balanceCommand;
	private BlockCommand blockCommand;
	private ChainCommand chainCommand;
	private GrantCommand grantCommand;
	private IssueCommand issueCommand;
	private RAWTransactionCommand rawTransactionCommand;
	private StreamCommand streamCommand;
	private WalletTransactionCommand walletTransactionCommand;

	/**
	 * 
	 */
	public MultiChainCommand(String ip, String port, String login, String password) {
		super();
		addressCommand = new AddressCommand(ip, port, login, password);
		balanceCommand = new BalanceCommand(ip, port, login, password);
		blockCommand = new BlockCommand(ip, port, login, password);
		chainCommand = new ChainCommand(ip, port, login, password);
		grantCommand = new GrantCommand(ip, port, login, password);
		issueCommand = new IssueCommand(ip, port, login, password);
		rawTransactionCommand = new RAWTransactionCommand(ip, port, login, password);
		streamCommand = new StreamCommand(ip, port, login, password);
		walletTransactionCommand = new WalletTransactionCommand(ip, port, login, password);
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

	/**
	 * @return the chainCommand
	 */
	public ChainCommand getChainCommand() {
		return chainCommand;
	}

	/**
	 * @param chainCommand
	 *            the chainCommand to set
	 */
	public void setChainCommand(ChainCommand chainCommand) {
		this.chainCommand = chainCommand;
	}

}
