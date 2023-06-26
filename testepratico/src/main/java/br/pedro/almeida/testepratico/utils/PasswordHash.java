package br.pedro.almeida.testepratico.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash {
    public static String hash(String password) throws NoSuchAlgorithmException {
        // Gerar senha HASH
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update((password.getBytes()));
        BigInteger no = new BigInteger(1, md.digest());
        String passwordHash = no.toString(16);

        return passwordHash;
    }

}
