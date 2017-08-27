/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.command;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import multichain.command.MultiChainCommand;
import multichain.command.MultichainException;
import multichain.object.Stream;
import multichain.object.StreamKey;
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

	private static void testlistStreams() {
		List<Stream> result = null;
		System.out.println("testlistStreams :");
		try {
			System.out.println("Stream *");
			result = multiChainCommand.getStreamCommand().listStreams("*");
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true");
			result = multiChainCommand.getStreamCommand().listStreams("*", true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true 1");
			result = multiChainCommand.getStreamCommand().listStreams("*", true, 1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("Stream * true 1 0");
			result = multiChainCommand.getStreamCommand().listStreams("*", true, 1, 0);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Result :");
		for (Stream stream : result) {
			System.out.println("   Stream :");
			System.out.println(stream.toString());
		}
	}

	private static void testcreate() {
		String result = "";
		System.out.println("testcreate :");
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

	private static void testpublish() {
		String result = "";
		System.out.println("testpublish :");
		try {
			result = multiChainCommand.getStreamCommand().publish(streamName, "StreamKey", "0123456789abcdef");

			for (int i = 0; i < 10; i++) {
				multiChainCommand.getStreamCommand().publish(streamName, "StreamKey-1",
						"10abcdef01234567890" + String.valueOf(i));
			}
			for (int i = 0; i < 10; i++) {
				multiChainCommand.getStreamCommand().publish(streamName, "StreamKey-2",
						"20abcdef01234567890" + String.valueOf(i));
			}
			for (int i = 0; i < 10; i++) {
				multiChainCommand.getStreamCommand().publish(streamName, "StreamKey-3",
						"30abcdef01234567890" + String.valueOf(i));
			}
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || "".equals(result)) {
			System.err.println("testpublish - result is empty");
		} else {
			System.out.println("Result :");
			System.out.println(result);
		}

	}

	private static void testsubscribe() {
		System.out.println("testsubscribe :");
		try {

			multiChainCommand.getStreamCommand().subscribe(streamName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result : done !");
	}

	private static void testunsubscribe() {
		System.out.println("testunsubscribe :");
		try {

			multiChainCommand.getStreamCommand().unsubscribe(streamName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Result : done !");
	}

	private static void testlistStreamKeys() {
		List<StreamKey> result = null;
		System.out.println("testlistStreamKeys :");
		try {
			System.out.println("StreamKey " + streamName);
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey");
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey");
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey true");
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey", true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey false");
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName, "StreamKey", false);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1");
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName, "*", false, 1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1 1");
			result = multiChainCommand.getStreamCommand().listStreamKeys(streamName, "*", false, 1, 1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKey item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	private static void testlistStreamKeyItems() {
		List<StreamKeyItem> result = null;
		System.out.println("testlistStreamKeyItems :");
		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1");
			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1");
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1 true");
			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1", true);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " StreamKey-1 false");
			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "StreamKey-1", false);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1");
			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "*", false, 1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

		try {
			System.out.println("StreamKey " + streamName + " * false 1 1");
			result = multiChainCommand.getStreamCommand().listStreamKeyItems(streamName, "*", false, 1, 1);
		} catch (MultichainException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == null || result.size() == 0) {
			System.err.println("testcreate - result list is null or empty");
		} else {
			System.out.println("Result :");
			for (StreamKeyItem item : result) {
				System.out.println("   Key :");
				System.out.println(item.toString());
			}
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of StreamCommandTest ---");

		// BlockChain TestCommand has to be created and started before
		multiChainCommand = new MultiChainCommand("localhost", "6824", "multichainrpc",
				"73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

		// BlockChain TestCommand has to be created and started before
		// ChainCommand.initializeChain("TestAPI1");
		SimpleDateFormat formater = new SimpleDateFormat("ddMMyyhhmmss");
		streamName = "TestAPI1" + formater.format(new Date());

		testlistStreams();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testcreate();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testsubscribe();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testpublish();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testlistStreamKeys();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testlistStreamKeyItems();

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

		testunsubscribe();

		System.out.println("--- End of StreamCommandTest ---");
	}

}
