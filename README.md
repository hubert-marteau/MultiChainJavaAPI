# MultiChainJavaAPI

MultiChainJAVAAPI is an open source Java interface [MultiChain](http://www.multichain.com/) blockchains, written in Java.

https://github.com/SimplyUb/MultiChainJavaAPI

    Copyright (c) 2017 Worldline
    License: GNU General Public License version 3, see COPYING

	
	
### System requirements

These compilation instructions have been tested on Windows 7.0 and Ubuntu 12.4 x64 only with Java 1.7.0_80 with Multichain 2.0 beta 2.


## Dependencies

    * Multichain 2.0 beta 2
    * Java 1.7.0 is needed, upper version should be compatible.
	* All other dependencies are managed by Maven.

## Installation
```
	.\install.sh
```
or manually :
```
	mvn clean install
```
will create 2 jar files in local repository :
- version : light version
- version : full directly included all dependencies


## Architecture

### Global Architecture
The goal of the API is to directly integrate calls to command system and Json Formating to make Java development easier :

![alt tag](Archi.png)

The initial mind of the project is to manage Wallet.
There's no command to manage the BlockChain like : create a blockChain, join a blockChain, ...
Theses commands are more linked with the system.
Next versions will decide to integrate (or not) theses commands.

### Project Architecture

#### multichain.command and CommandManager
The package multichain.command and the Class `CommandManager` are the essentials of the project.
They contain Java ***the*** command to call.

```
public Object invoke(CommandElt command, Object... parameters) throws MultichainException
```
- command : Multichain command to call
- parameters : (optional) list of parameters joined to the command

Examples of command calls can be found in `test/multichain.command.CommandManagerTest`.

A simple example to get addresses :
```
//BlockChain has to be created and started before
CommandManager commandManager= new CommandManager("localhost", "6824", "multichainrpc","73oYQWzx45hossFPPWUgicpLvHhsD8PempYxnSF6bnY9");

// localhost is the IP used by Multichain
// 6824 is, here, the port used by the BlockChain, corresponding of the value of default-rpc-port in the file params.dat 
// multichainrpc and 73oYQWzx45h... are login and password to access to RPC commands, values can be found in the file multichain.conf

Object addressResult = null;

try {
  addressResult = commandManager.invoke(CommandElt.GETADDRESSES);
} catch (MultichainException e) {
  e.printStackTrace();
  fail();
}

//result contains the addresses of the wallet as list of String (verbose is false).
//class java.util.ArrayList
//class java.lang.String

try {
  addressResult = commandManager.invoke(CommandElt.GETADDRESSES, true);
} catch (MultichainException e) {
  e.printStackTrace();
  fail();
}

//result contains the addresses of the wallet as list of Addresses (verbose is true).
//class java.util.ArrayList
//class multichain.object.Address
```

#### multichain.command.CommandElt

This Enum contains command definitions, for example :
```
GETADDRESSES("getaddresses", null, new Class<?>[] {String.class, Address.class}, true),
```
|element name | GETADDRESSES |
|-|-|
| multichain command | **"getaddresses"** : call this multichain command |
| input parameters | **null** : *#TODO#* |
| output parameters | **new Class<?>[] {String.class, Address.class}** : output can be either String or Address |
| output list flag | **true** : output will follow list format |

`multichain.object.formatters.GenericOutputFormatter` is the only formatter and is based on the output defined in this Enum. To format Json to Java, it's using [Gson API](https://github.com/google/gson).


#### multichain.object
The package `multichain.object` contains Java objects which can be used  to call functions (in queryobjects) or returned by functions.

#### a few examples
```
String message = (String) commandManager.invoke(CommandElt.GETNEWADDRESS);

List<Permission> listPermissions = (List<Permission>) commandManager.invoke(CommandElt.LISTPERMISSIONS);

String message = (String) commandManager.invoke(CommandElt.GRANT, addressString, GrantElt.grantElements(permissions));

AssetParams params = new AssetParams(name, true);
String message = (String) commandManager.invoke(CommandElt.ISSUEFROM, fromAddressString, toAddressString, params, quantity, 1);

MultiBalance balance = (MultiBalance)commandManager.invoke(CommandElt.GETMULTIBALANCES);

List<BalanceAssetGeneral> balance = (List<BalanceAssetGeneral>)commandManager.invoke(CommandElt.GETADDRESSBALANCES, AddressString);

Map<String, Double> basket = new HashMap();
basket.put(assetName1, assetQty1);
basket.put(assetName2, assetQty2);
String message = (String)commandManager.invoke(CommandElt.SENDFROM, fromAddressString, toAddressString, basket);
String message = (String)commandManager.invoke(CommandElt.SENDWITHDATAFROM, fromAddressString, toAddressString, basket, metadata);
```


## Versions

### 2.0.1
* All new version :-)
* Only one calling command : **invoke**

### 1.3.0
* Direct RPC Server calls
* Dependencies under Maven

### 1.2.0
Based on functions contained in MultiChain 1.0 Beta 1

Integrated functions about :
* Streams

### 1.1.0
Based on functions contained in MultiChain Alpha 24

Integrated functions about :
* Block
* Address
* Grant
* Balance
* Wallet
* Issue/Assets
* Transaction
* Transaction	RAW


## License

MultiChainJAVAAPI is released under the [GNU General Public License version 3] (LICENSE).


```
Copyright (c) 2017 Worldline.

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
```

