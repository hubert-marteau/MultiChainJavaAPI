/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.StreamKeyItem;

/**
 * @author Ub - H. MARTEAU
 * @version 1.1
 */
public class StreamCommandTest {
	static MultiChainCommand multiChainCommand;

	static String streamName = "";

	/**
	 *
	 */
	public StreamCommandTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testcreate() {
		String result = "";
		try {

			result = multiChainCommand.getStreamCommand().create(streamName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testcreate - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}
	}

	private static void testlistStreamKeyItems() {
		List<StreamKeyItem> result = null;
		try {
			multiChainCommand.getStreamCommand().publish(streamName, "StreamKey", "abcdef0123456789");

			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey", true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() != 2) {
			System.err.println("testcreate - result list <> 2");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Item :");
				System.out.println(item.toString());
			}
		}
	}

	private static void testpublish() {
		String result = "";
		try {
			result = multiChainCommand.getStreamCommand().publish(streamName, "StreamKey", "0123456789abcdef");
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testcreate - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}
	}

	private static void testsubscribe() {
		try {

			multiChainCommand.getStreamCommand().subscribe(streamName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result : done !");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of StreamCommandTest ---");

		multiChainCommand = new MultiChainCommand("TestAPI1");

		// BlockChain TestCommand has to be created and started before
		// ChainCommand.initializeChain("TestAPI1");
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		streamName = "TestAPI1" + formater.format(new Date());
		testcreate();
		testsubscribe();
		testpublish();
		testlistStreamKeyItems();

		System.out.println("--- End of StreamCommandTest ---");
	}

}
