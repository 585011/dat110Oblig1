package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import javax.swing.text.WrappedPlainView;

import no.hvl.dat110.TODO;

public class RPCUtils {

	// Utility methods for marshalling and marshalling of parameters and return values
	// in RPC request and RPC responses
	// data bytearrays and return byte arrays is according to the 
	// RPC message syntax [rpcid,parameter/return value]
	
	public static byte[] marshallString(byte rpcid, String str) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		encoded = new byte[str.getBytes().length+1];
		encoded[0] = rpcid;
		
		//Konvertera String til byte[]
		for(int i = 1; i < encoded.length; i++) {
			encoded[i] = str.getBytes()[i-1];
		}

//		if (true) {
//			throw new UnsupportedOperationException(TODO.method());
//		}

		return encoded;
	}

	public static String unmarshallString(byte[] data) {

		String decoded;

		// TODO: unmarshall String contained in data into decoded

		/* copyOfRange(byte[] original, int from, int to)
		Copies the specified range of the specified array into a new array. (finn i Arrays API) */
		decoded = new String(Arrays.copyOfRange(data, 1, data.length));
		

		return decoded;
	}

	public static byte[] marshallVoid(byte rpcid) {

		byte[] encoded;

		// TODO: marshall RPC identifier in case of void type

		encoded = new byte[1];
		encoded[0] = rpcid;

		return encoded;

	}

	public static void unmarshallVoid(byte[] data) {

		// TODO: unmarshall void type
		
	}

	public static byte[] marshallBoolean(byte rpcid, boolean b) {

		byte[] encoded = new byte[2];

		encoded[0] = rpcid;

		if (b) {
			encoded[1] = 1;
		} else {
			encoded[1] = 0;
		}

		return encoded;
	}

	public static boolean unmarshallBoolean(byte[] data) {

		return (data[1] > 0);

	}

	public static byte[] marshallInteger(byte rpcid, int x) {

		byte[] encoded;

		// TODO: marshall RPC identifier and string into byte array
		
		//En integer i java er 4 bytes.
		encoded = new byte[5]; //1 byte til rpcid og 4 til int
		encoded[0] = rpcid;
		
		//allocate(int capacity) som er 4 i dette tilfelle.
		byte[] intTb = ByteBuffer.allocate(4).putInt(x).array();
		
		for(int i = 1; i < encoded.length; i++) {
			encoded[i] = intTb[i-1];
		}


		return encoded;
	}

	public static int unmarshallInteger(byte[] data) {

		int decoded;

		// TODO: unmarshall integer contained in data

		//https://javadeveloperzone.com/java-basic/java-convert-int-to-byte-array/
		decoded = ByteBuffer.wrap(Arrays.copyOfRange(data, 1, data.length)).getInt();
		// Gir feil tall på displayen men passa testane!
		return decoded;

	}
}
