package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class Message {

	private byte[] payload;

	public Message(byte[] payload) {
		if (payload.length < MessageConfig.SEGMENTSIZE) {
			this.payload = payload; // TODO: check for length within boundary
		}
	}

	public Message() {
		super();
	}

	public byte[] getData() {
		return this.payload;
	}

	public byte[] encapsulate() {

		byte[] encoded = null;

		// TODO
		// encapulate/encode the payload of this message in the
		// encoded byte array according to message format
		
		//Sa i video at i encoded[0] er størrelsen på payloaden.
		//Må lage encoded size å styr
		encoded = new byte[MessageConfig.SEGMENTSIZE];
		Integer payloadSize = payload.length;
		encoded[0] = payloadSize.byteValue(); //Sett størrelse på payload inn i plass 0 på encoda greia
		for(int i = 0; i < payloadSize; i++) {
			encoded[i+1] = payload[i]; //Sette resten av d som stend inne i payload inn i pakka/meldinga
		}
//
//		if (true)
//			throw new UnsupportedOperationException(TODO.method());

		return encoded;

	}

	public void decapsulate(byte[] received) {

		// TODO
		// decapsulate the data contained in the received byte array and store it
		// in the payload of this message

//		throw new UnsupportedOperationException(TODO.method());

		//Egt samme som encapsulate, må ha med this.payload og sette den til lengda til received ellers blir det null
		this.payload = new byte[received[0]];
		byte sizeRece = received[0];
		for(int i = 0; i < sizeRece; i++) { //received[0] he størrelsen på pakka
			payload[i] = received[i+1];
		}
	}
}
