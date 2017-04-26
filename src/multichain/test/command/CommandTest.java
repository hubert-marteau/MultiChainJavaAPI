/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.util.List;

import multichain.command.*;
import multichain.object.Stream;
import multichain.object.StreamItem;
import multichain.object.StreamKeyPublisherInfo;

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
		String streamNames = "unpublishedwork,teststream";
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

	private static void testSubscribe() {
		try {
			StreamCommand.subscribeAssetsOrStreams("teststream, teststream1");
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testUnsubscribe() {
		try {
			StreamCommand.unsubscribeAssetsOrStreams("teststream");
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testGetStreamItem() {
		try {
			StreamItem result = StreamCommand.getStreamItem("unpublishedwork", "ca3607812837fd68bc6e094f5715b03a721636fe85e711a0ab565c9ba5f2f93c", "true");
			System.out.println(result.toString());
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testListStreamKeyItems() {
		try {
			List<StreamItem> result = StreamCommand.listStreamKeyItems("unpublishedwork", "doc1");
			for(StreamItem i : result)
				System.out.println(i.toString());
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testListStreamKeys() {
		try {
			List<StreamKeyPublisherInfo> result = StreamCommand.listStreamKeys("unpublishedwork");
			for(StreamKeyPublisherInfo i : result)
				System.out.println(i.toString());
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testListStreamItems() {
		try {
			List<StreamItem> result = StreamCommand.listStreamItems("unpublishedwork", "true");
			for(StreamItem i : result)
				System.out.println(i.toString());
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testListStreamPublisherItems() {
		try {
			List<StreamItem> result = StreamCommand.listStreamPublisherItems("unpublishedwork", "1TyYAuoJkowfZgM5cP6Y7U2HP43oevJYYNjYfd", "true");
			for(StreamItem i : result)
				System.out.println(i.toString());
		} catch (MultichainException e) {
			e.printStackTrace();
		}
	}

	private static void testListStreamPublishers() {
		try {
			List<StreamKeyPublisherInfo> result = StreamCommand.listStreamPublishers("unpublishedwork");
			for(StreamKeyPublisherInfo i : result)
				System.out.println(i.toString());
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
		//testPublishStream();
		//testSubscribe();
		//testUnsubscribe();
		//testGetStreamItem();
		//testListStreamKeyItems();
		//testListStreamKeys();
		//testListStreamItems();
		//testListStreamPublisherItems();
		testListStreamPublishers();
		System.out.println("--- End of CommandTest ---");
	}

}
