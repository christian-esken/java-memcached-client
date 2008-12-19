package net.spy.memcached.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Utilities for processing key values.
 */
public class KeyUtil {

	/**
	 * Get the bytes for a key.
	 *
	 * @param k the key
	 * @return the bytes
	 */
	public static byte[] getKeyBytes(String k) {
		try {
			return k == null ? null : k.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Get the string representation of the given byte[] (intended for use as
	 * a key).
	 *
	 * @param b the byte
	 * @return the key
	 */
	public static String getKeyString(byte[] b) {
		try {
			return new String(b, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Get the keys in byte form for all of the string keys.
	 *
	 * @param keys a collection of keys
	 * @return return a collection of the byte representations of keys
	 */
	public static Collection<byte[]> getKeyBytes(Collection<String> keys) {
		Collection<byte[]> rv=new ArrayList<byte[]>(keys.size());
		for(String s : keys) {
			rv.add(getKeyBytes(s));
		}
		return rv;
	}
}
