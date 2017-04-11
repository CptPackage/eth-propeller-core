package org.adridadou.ethereum.propeller.keystore;

import org.adridadou.ethereum.propeller.values.EthAccount;

import java.io.File;

/**
 * Created by davidroon on 26.07.16.
 * This code is released under Apache 2 license
 */
public class FileSecureKey implements SecureKey {
    private final File keyfile;

    public FileSecureKey(File keyfile) {
        this.keyfile = keyfile;
    }

    public EthAccount decode(final String password) throws Exception {
        return Keystore.fromKeystore(keyfile, password);
    }

    public String getName() {
        return keyfile.getName();
    }
}
