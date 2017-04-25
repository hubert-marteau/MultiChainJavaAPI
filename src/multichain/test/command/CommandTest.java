/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.util.Arrays;
import java.util.List;

import multichain.command.*;
import multichain.object.Stream;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class CommandTest {

	/**
	 *
	 */
	public CommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testgetAddresses() {
		List<String> result = null;
		try {
			result = AddressCommand.getAddresses();
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) { System.err.println("testgetAddresses - result list is empty"); }
		else {
            for (String address : result) {
                grantPermissionCreate(address);
            }
        }
	}

	private static void grantPermissionCreate(String address){
        try {
            String result = GrantCommand.grant(address, GrantCommand.CREATE);
            System.out.println(result);
        } catch (MultichainException e) {
            e.printStackTrace();
        }
    }

	private static void testCreateStream() {
		String transactionId = null;
		try {
			transactionId = StreamCommand.createStream("teststream1", true);
		} catch (MultichainException e) {
			e.printStackTrace();
		}
		System.out.println(transactionId);
	}

	private static void testListStreams() {
		List<Stream> allAvailableStreams = null;
		String streamNames = "unpublishedwork";
		try {
			allAvailableStreams = StreamCommand.listStreams(streamNames);
			for (Stream stream : allAvailableStreams) {
				System.out.println(stream.toString());
			}
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testPublishStream() {
		String transactionId = null;
		try {
			transactionId = StreamCommand.publishStream("unpublishedwork", "doc1", "5361792048656c6c6f20746f204d79204c6974746c6520467269656e64");
			System.out.println(transactionId);
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of CommandTest ---");

		//BlockChain TestCommand has to be created and started before
		ChainCommand.initializeChain("plagchain");
		//testgetAddresses();
		//testCreateStream();
		//testListStreams();
		testPublishStream();
		System.out.println("--- End of CommandTest ---");
	}

}
