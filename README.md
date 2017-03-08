# MultiChainJavaAPI

MultiChainJAVAAPI is an open source Java interface [MultiChain](http://www.multichain.com/) blockchains, written in Java.

https://github.com/SimplyUb/MultiChainJavaAPI

    Copyright (c) 2017 Worldline
    License: GNU General Public License version 3, see COPYING

	
	
### System requirements

These compilation instructions have been tested on Ubuntu 12.4 x64 only with Java 1.7.0_80


## Linux Build Notes (on Ubuntu 12.4 x64 only with Java 1.7.0_80)

### ClassPath dependencies

    * Java 1.7.0 is needed, upper version should be compatible
	* Project uses [Gson API](https://github.com/google/gson)

### Notes

* The classpath file is called "project.classpath" and has to ne rename in ".classpath" for compilation.

## Architecture

### Global Architecture
The goal of the API is to directly integrate calls to command system and Json Formating to make Java developing easier :

![alt tag](Archi.png)

The initial mind of the project is to manage Wallet.
There's no command to manage the BlockChain like : create a blockChain, join a blockChain, ...
Theses commands are more linked with the system.
Next versions will decide to integrate (or not) theses commands.

### Project Architecture

#### multichain.command
The package `multichain.command` is the essential of the project.
The package contains Java commands to call.

Examples of command calls can be found in `multichain.test.command`.

A simple example to get addresses :
```
//BlockChain TestCommand has to be created and started before
ChainCommand.initializeChain("TestCommand");

List<String> result = null;
try {
	result = AddressCommand.getAddresses();
} catch (MultichainException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

//result contains the addresses of the wallet as list of String.
```


#### multichain.object
The package `multichain.object` contains Java objects which can be used to call functions or returned by functions.

The package contains `formatters` with technical classes used to format Json to Java using [Gson API](https://github.com/google/gson).

## Versions

## License

MultiChainJAVAAPI is released under the [GNU General Public License version 3] (LICENSE).

#### multichain.test.object.formatters
The package `multichain.test` contains Java unit test.
Test are written with `main()` function to be executed whatever IDE or system used.

The package `command` has to contain unit tests for each command.
The package `object.formatters` is helpful to test the good work of Formatters Json<->Java.

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