/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.Block;

/**
 * @author Ub - H. MARTEAU
 * @version 2.0
 */
public class BlockCommandTest {
	static MultiChainCommand multiChainCommand;

	/**
	 *
	 */
	public BlockCommandTest() {
		// TODO Auto-generated constructor stub
	}
	
	private static void testlistBlocks() {
		List<Block> resultlist = multiChainCommand.getBlockCommand().listBlocksList("10-50,100",false);
		System.out.println("");
		System.out.println("resultlist size : " + resultlist.size());
		System.out.println("heights");
		for (int i =0; i<resultlist.size(); i++) {
			System.out.print(resultlist.get(i).getHeight()+"-");
		}
	}

	private static void testgetBlock() {
		Block result = null;
		try {
			result = multiChainCommand.getBlockCommand().getBlock(1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose) :" + result);
		System.out.println("");

		try {
			result = multiChainCommand.getBlockCommand().getBlock(1, true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose=true) :" + result);
		System.out.println("");

		try {
			result = multiChainCommand.getBlockCommand().getBlock(1, false);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result Block(1) (default verbose=false) :" + result);

		System.out.println("");
		System.out.println("");

		//
		try {
			result = multiChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8");
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose) :"
						+ result);
		System.out.println("");

		try {
			result = multiChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8", true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose=true) :"
						+ result);
		System.out.println("");

		try {
			result = multiChainCommand.getBlockCommand().getBlock(
					"0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8", false);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out
				.println("Result Block(0074ba967e7f7c3b04ed0429b796900136d82b52ecf44d5878f1f2dfdf5e1fb8) (default verbose=false) :"
						+ result);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of AddressCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand(TestConst.MULTICHAIN_SERVER_IP, TestConst.MULTICHAIN_SERVER_PORT, TestConst.MULTICHAIN_SERVER_LOGIN,
		    TestConst.MULTICHAIN_SERVER_PWD);

		testgetBlock();
		//testlistBlocks();

		System.out.println("--- End of AddressCommandTest ---");
	}

}
