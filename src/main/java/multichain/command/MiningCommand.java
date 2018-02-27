package multichain.command;

import multichain.command.builders.QueryBuilderMining;

public class MiningCommand extends QueryBuilderMining {
	public MiningCommand(String ip, String port, String login, String password) {
		initialize(ip, port, login, password);
	}
	
	public Object pauseMining() throws MultichainException {
		return executePauseMining();
	}
	
	public Object resumeMining() throws MultichainException {
		return executeResumeMining();
	}
	
}
