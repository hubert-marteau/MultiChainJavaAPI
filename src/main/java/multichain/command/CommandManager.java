/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import multichain.object.formatters.GenericOutputFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0.1
 */
public class CommandManager extends QueryBuilderCommon {

  public CommandManager(String ip, String port, String login, String password) {
    initialize(ip, port, login, password, null);
  }

  public CommandManager(String ip, String port, String login, String password,
      RuntimeParameters runtimeparameters) {
    initialize(ip, port, login, password, runtimeparameters);
  }


  public Object invoke(CommandElt command, Object... parameters) throws MultichainException {
    // Command Management
    Object commandValue = execute(command, parameters);

    // Ouput Management
    Class<?>[] returnedTypes = command.getReturnedClass();
    if (returnedTypes != null && returnedTypes.length > 0) {
      try {
        if (command.isResultByList()) {
          return GenericOutputFormatter.formatList(commandValue, returnedTypes);
        } else {
          return GenericOutputFormatter.format(commandValue, returnedTypes);
        }
      } catch (Exception e) {
        // TODO log exception
        return commandValue;
      }
    } else {
      return commandValue;
    }
  }

  public Object invokeWithControl(CommandElt command, Object... parameters)
      throws MultichainException {

    // Input Management
    Object commandParameters = command.getCommandParameters();
    boolean controlValue = true; // Will be done in 6.02

    if (controlValue) {
      return invoke(command, parameters);
    } else {
      throw new MultichainException("Arguments Problem", "Arguments aren't validate by control !");

    }
  }

}
