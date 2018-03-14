/**
 * 
 */
package multichain.object;

import multichain.command.MultichainException;

/**
 * @author Ub - H. Marteau
 * @version 4.10
 *
 */
public interface AddressBalance {
	public String getAddress();
	public void isFilled() throws MultichainException;
	public Object getValue() throws MultichainException;
}
