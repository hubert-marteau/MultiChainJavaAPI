/*
 * Copyright (C) 2017 Worldline, Inc.
 *
 * MultiChainJavaAPI code distributed under the GPLv3 license, see COPYING file.
 * https://github.com/SimplyUb/MultiChainJavaAPI/blob/master/LICENSE
 *
 */
package multichain.object;

/**
 * @author Ub - H. MARTEAU
 * @version 4.14
 */
public class Address extends AddressInfo {
	String address = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Address [address=" + address + ", " + super.toString() + "]";
	}

	// HashMap<String, Permission> permissions;
	/**
	 *
	 */
	public Address() {
		super();

		// permissions = new HashMap<String, Permission>();
	}

	/**
	 * @param address
	 */
	public Address(String address) {
		super();
		this.address = address;
		// permissions = new HashMap<String, Permission>();
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	// /**
	// * @return the permissions
	// */
	// public HashMap<String, Permission> getPermissions() {
	// return permissions;
	// }
	//
	//
	// /**
	// * @param permissions the permissions to set
	// */
	// public void setPermissions(HashMap<String, Permission> permissions) {
	// this.permissions = permissions;
	// }

	// /**
	// * @param permissions the permissions to set
	// */
	// public void addPermission(Permission permission) {
	// if (permission != null && permission.getType() != null && !"".equals(permission.getType())) {
	// this.permissions.put(permission.getType(), permission);
	// }
	// }

}
