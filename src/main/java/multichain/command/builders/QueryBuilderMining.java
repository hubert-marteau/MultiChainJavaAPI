package multichain.command.builders;

import multichain.command.MultichainException;
import multichain.command.builders.QueryBuilderCommon.CommandEnum;
import multichain.command.tools.MultichainTestParameter;

public class QueryBuilderMining extends QueryBuilderCommon {
	protected Object executePauseMining() throws MultichainException {
		return execute(CommandEnum.PAUSE, "mining");
	}
	
	protected Object executeResumeMining() throws MultichainException {
		return execute(CommandEnum.RESUME, "mining");
	}
	
}
