package test_util;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public abstract class Key {
	/**
	 * Reads in key from sauce.key in repository root.
	 * http://username:---@ondemand.saucelabs.com:80/wd/hub
	 **/
	public static String getSauceKey() {
		try {
			final File key = new File("sauce.key");
			final byte[] data = new byte[(int) key.length()];
			DataInputStream dis = new DataInputStream(new FileInputStream(key));
			dis.readFully(data);
			dis.close();

			return new String(data).trim();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
