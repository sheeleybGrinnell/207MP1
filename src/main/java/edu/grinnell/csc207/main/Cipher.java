/**
 * Benjamin Sheeley.
 * CSC207 Mini Project 1.
 * Cipher.java.
 */
package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;


/**
 * Main class of program, performs both caesar and vigenere ciphers one string at a time.
 */
public class Cipher {


  /**
   * represents the maximum bound of the lowercase alphabet in unicode integers.
   */
  private static final int ALPHABET_MAX_LEN = 122;

  /**
   * represents the minimum bound of the lowercase alphabet in unicode integers.
   */
  private static final int ALPHABET_MIN_LEN = 97;
  /**
   * amount of parameters accepted for input.
   */
  private static final int PARAM_AMOUNT = 4;

  /**
   * @param args arguments passed as input for cipher.
   */
  public static void main(String[] args) {
    if (args.length < PARAM_AMOUNT) {
      System.err.println("Error: Expected 4 parameters, received " + args.length);
      return;
    } /*test for lack of parameters */
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if (args[i].contains("-encode")) {
        args[i] = "CaseFilled";
        Cipher.encode(args);
        return;
      } /*controls for -encode argument */ else if (args[i].contains("-decode")) {
        args[i] = "CaseFilled";
        Cipher.decode(args);
        return;
      } /*controls for -decode argument */
    } /*loops until it finds an encode or decode argument */
    System.err.println("Error: Legal Action values are '-encode' and '-decode'");
    return;
  } /*main() */

  /**
   * @param args passes in same set of arguments from main function.
   */
  public static void encode(String[] args) {
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if (args[i].contains("-caesar")) {
        args[i] = "CaseFilled";
        Cipher.encodeCaesar(args);
        return;
      } /*sends arguments to encode with caesar cipher */ else if (args[i].contains("-vigenere")) {
        args[i] = "CaseFilled";
        Cipher.encodeVigenere(args);
        return;
      } /*sends arguments to encode with vigenere cipher */
    } /*loops until it finds cipher to encode with */
  } /*encode() */

  /**
   * @param args passes in same set of arguments from main function.
   */
  public static void decode(String[] args) {
    for (int i = 0; i < PARAM_AMOUNT;  i++) {
      if (args[i].contains("-caesar")) {
        args[i] = "CaseFilled";
        Cipher.decodeCaesar(args);
        return;
      } /*sends arguments to decode with caesar cipher */ else if (args[i].contains("-vigenere")) {
        args[i] = "CaseFilled";
        Cipher.decodeVigenere(args);
        return;
      } /*sends arguments to decode with vigenere cipher */
    } /*loops until it finds cipher to encode with */
  } /*decode() */

  /**
   * @param args passes in same set of args from encode().
   */
  public static void encodeCaesar(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if ((args[i].compareTo("CaseFilled") != 0)) {
        String str = args[i];
        char[] caseCheck = str.toCharArray();
        for (int k = 0; k < str.length(); k++) {
          if ((int) caseCheck[k] < ALPHABET_MIN_LEN | ((int) caseCheck[k] > ALPHABET_MAX_LEN)) {
            System.err.println("Error: strings must be only lowercase letters");
            return;
          } /*Checks to see if any letters are out of bounds */
        } /*Checks for invalid characters used in arguments */
        args[i] = "CaseFilled";
        for (int j = 0; j < PARAM_AMOUNT; j++) {
          if ((args[j].compareTo("CaseFilled") != 0)) {
            char[] keyArray = args[j].toCharArray();
            if (keyArray.length != 1) {
              System.err.println("Error: Caesar ciphers require a one-character key");
              return;
            } /*controls for a multi-character key as an argument */
            char key = keyArray[0];
            String encryptedCaesar = CipherUtils.caesarEncrypt(str, key);
            pen.println(encryptedCaesar);
            pen.close();
            return;
          } /*loops over filled arguments to find the key */
        } /*loops over arguments until the final argument is found and used as key */
      } /*checks over arguments to find string to encode */
    } /*loops over arguments to find string to encode */
  } /*encodeCaesar() */

  /**
   * @param args passes in same arguments from encode().
   */
  public static void encodeVigenere(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if ((args[i].compareTo("CaseFilled") != 0)) {
        if (args[i + 1].length() == 0) {
          System.err.println("Error: Empty keys are not permitted");
          return;
        } /*checks to see if empty key is passed in as a parameter */
        char[] caseCheck = args[i].toCharArray();
        for (int k = 0; k < args[i].length(); k++) {
          if ((int) caseCheck[k] < ALPHABET_MIN_LEN | ((int) caseCheck[k] > ALPHABET_MAX_LEN)) {
            System.err.println("Error: strings must be only lowercase letters");
            return;
          } /*Checks to see if any letters are out of bounds */
        } /*Checks for invalid characters used in arguments */
        String encryptedVigenere = CipherUtils.vigenereEncrypt(args[i], args[i + 1]);
        pen.println(encryptedVigenere);
        pen.close();
        return;
      } /*checks over arguments to find string to encode */
    } /*loops over all arguments to find string to encode */
  } /*encodeVigenere() */

  /**
   * @param args passes in same arguments from decode().
   */
  public static void decodeCaesar(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if ((args[i].compareTo("CaseFilled") != 0)) {
        String str = args[i];
        char[] caseCheck = str.toCharArray();
        for (int k = 0; k < str.length(); k++) {
          if ((int) caseCheck[k] < ALPHABET_MIN_LEN | ((int) caseCheck[k] > ALPHABET_MAX_LEN)) {
            System.err.println("Error: strings must be only lowercase letters");
            return;
          } /*Checks to see if any letters are out of bounds */
        } /*Checks for invalid characters used in arguments */
        args[i] = "CaseFilled";
        for (int j = 0; j < PARAM_AMOUNT; j++) {
          if ((args[j].compareTo("CaseFilled") != 0)) {
            char[] keyArray = args[j].toCharArray();
            if (keyArray.length > 1) {
              System.err.println("Error: Caesar ciphers require a one-character key");
              return;
            } /*checks for multicharacter keys */
            char key = keyArray[0];
            String decryptedCaesar = CipherUtils.caesarDecrypt(str, key);
            pen.println(decryptedCaesar);
            pen.close();
            return;
          } /*checks for final parameter to use as key */
        } /*loops until it finds key parameter */
      } /*checks for parameter to use as string to decode*/
    } /*loops until it finds string paramenter to decode*/
  } /*decodeCaesar() */

  /**
   * @param args passes in same arguments as decode()
   */
  public static void decodeVigenere(String[] args) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (int i = 0; i < PARAM_AMOUNT; i++) {
      if ((args[i].compareTo("CaseFilled") != 0)) {
        if (args[i + 1].length() == 0) {
          System.err.println("Error: Empty keys are not permitted");
          return;
        } /*Controls for empty key being used to decode */
        char[] caseCheck = args[i].toCharArray();
        for (int k = 0; k < args[i].length(); k++) {
          if ((int) caseCheck[k] < ALPHABET_MIN_LEN | ((int) caseCheck[k] > ALPHABET_MAX_LEN)) {
            System.err.println("Error: strings must be only lowercase letters");
            return;
          } /*Checks to see if any letters are out of bounds */
        } /*Checks for invalid characters used in arguments */
        CipherUtils.vigenereDecrypt(args[i], args[i + 1]);
        String decryptedVigenere = CipherUtils.vigenereDecrypt(args[i], args[i + 1]);
        pen.println(decryptedVigenere);
        pen.close();
        return;
      } /*checks for string to decode */
    } /*loops until it finds string to decode */
  } /*decodeVigenere() */
} /*Cipher */
