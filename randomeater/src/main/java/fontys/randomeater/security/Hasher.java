package fontys.randomeater.security;

import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

public final class Hasher {

    private static Hasher hasher;

    public static void current(){
        if(hasher == null) {
            hasher = new Hasher();
        }
    }

    private static Pbkdf2PasswordEncoder encoder;

    private Hasher() {
        encoder =  new Pbkdf2PasswordEncoder();
        encoder.setAlgorithm(Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA1);
    }

    public static String hash(String password)
    {
        return encoder.encode(password);
    }

    public static Boolean compare(String password, String hashedPassword)
    {
        return encoder.matches(password, hashedPassword);
    }
}