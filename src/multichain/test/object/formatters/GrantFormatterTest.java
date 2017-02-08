/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.test.object.formatters;

import java.util.List;

import multichain.object.Permission;
import multichain.object.formatters.GrantFormatter;

/**
 * @author Ub - H. MARTEAU
 * @version 1.0
 */
public class GrantFormatterTest {

	/**
	 *
	 */
	public GrantFormatterTest() {
		// TODO Auto-generated constructor stub
	}

	private static void testformatPermission() {
		String jsonPermission = "{"
				+ "\"address\" : \"aBcDeFgH123IjKlMnOp456\","
				+ "\"type\" : \"receive\","
				+ "\"startblock\" : 0,"
				+ "\"endblock\" : 4294967295"
				+ "}";
		Permission permission = GrantFormatter.formatPermission(jsonPermission);

		if (!"aBcDeFgH123IjKlMnOp456".equals(permission.getAddress())) { System.err.println("testformatPermission - address <> aBcDeFgH123IjKlMnOp456"); };
		if (!"receive".equals(permission.getType())) { System.err.println("testformatPermission - type <> receive"); };
		if (permission.getStartblock() != 0) { System.err.println("testformatPermission - startblock <> 0"); };
		if (permission.getEndblock() != 4294967295L ) { System.err.println("testformatPermission - endblock <> 4294967295"); };

	}


	private static void testformatPermissions() {
		String jsonPermissions = "["
				+ "{"
				+ "\"address\" : \"aBcDeFgH123IjKlMnOp456\","
				+ "\"type\" : \"connect\","
				+ "\"startblock\" : 0,"
				+ "\"endblock\" : 4294967295"
				+ "},"
				+ "{"
				+ "\"address\" : \"aBcDeFgH123IjKlMnOp456\","
				+ "\"type\" : \"send\","
				+ "\"startblock\" : 0,"
				+ "\"endblock\" : 5927694924"
				+ "}"
				+ "]";
		List<Permission> permissionList = GrantFormatter.formatPermissionList(jsonPermissions);

		if (permissionList.size() != 2) { System.err.println("testformatPermissions - result list size <> 2"); };

		if (!"aBcDeFgH123IjKlMnOp456".equals(permissionList.get(0).getAddress())) { System.err.println("testformatPermissions - address[0] <> aBcDeFgH123IjKlMnOp456"); };
		if (!"connect".equals(permissionList.get(0).getType())) { System.err.println("testformatPermissions - type[0] <> connect"); };
		if (permissionList.get(0).getStartblock() != 0) { System.err.println("testformatPermissions - startblock[0] <> 0"); };
		if (permissionList.get(0).getEndblock() != 4294967295L ) { System.err.println("testformatPermissions - endblock[0] <> 4294967295"); };

		if (!"aBcDeFgH123IjKlMnOp456".equals(permissionList.get(1).getAddress())) { System.err.println("testformatPermissions - address[1] <> aBcDeFgH123IjKlMnOp456"); };
		if (!"send".equals(permissionList.get(1).getType())) { System.err.println("testformatPermissions - type[1] <> send"); };
		if (permissionList.get(1).getStartblock() != 0) { System.err.println("testformatPermissions - startblock[1] <> 0"); };
		if (permissionList.get(1).getEndblock() != 5927694924L ) { System.err.println("testformatPermissions - endblock[1] <> 5927694924"); };

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("--- Start of GrantFormatterTest ---");

		testformatPermission();
		testformatPermissions();

		System.out.println("--- End of GrantFormatterTest ---");
	}

}
