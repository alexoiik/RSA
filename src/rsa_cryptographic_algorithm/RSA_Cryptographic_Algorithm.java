package rsa_cryptographic_algorithm;

//Importing libraries for RSA:
import java.security.KeyPair; 
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;

/**
 *
 * @author Alexandros Oikonomou
 */

public class RSA_Cryptographic_Algorithm {

    /**
     * @param args the command line arguments
     */
    
    private static final String algorithm = "RSA"; //RSA cryptographic algorithm

    //Encryption method:
    public static byte[] encrypt(byte[] plaintext, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(plaintext);
    }

    //Decryption method:
    public static byte[] decrypt(byte[] ciphertext, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance(algorithm);
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(ciphertext);
    }
    
    public static void main(String[] args) throws Exception {
        //Generating Key pair:
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(algorithm);
        keyPairGenerator.initialize(2048); //Key size: 2048 bits
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        
        //Returning Public key and Private key:
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        //Encryption and Decryption of the message:
        String plaintext = "Hello, world!";
        byte[] cipherText = encrypt(plaintext.getBytes(), publicKey); //encryption
        byte[] decryptedText = decrypt(cipherText, privateKey); //dencryption
        System.out.println(new String(decryptedText)); //Message transferred safely!
    }
}