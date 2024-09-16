package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Alternate main file that encodes and decodes using all letters of the alphabet.
 * Uses Caesar Cipher.
 */
public class AllCaesar {


  /**
   * represents the maximum bound of the lowercase alphabet in unicode integers.
   */
  private static final int ALPHABET_MAX_LEN = 122;

  /**
   * represents the minimum bound of the lowercase alphabet in unicode integers.
   */
  private static final int ALPHABET_MIN_LEN = 97;


  /**
   * @param args arguments passed in as input. An encoding option and string.
   */
  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } /*Checks for incorrect number of parameters */
    String str = args[1];
    char[] caseCheck = str.toCharArray();
    String codeType = args[0];
    for (int i = 0; i > str.length(); i++) {
      if ((int) caseCheck[i] < ALPHABET_MIN_LEN | ((int) caseCheck[i] > ALPHABET_MAX_LEN)) {
        System.err.println("Error: strings must be only lowercase letters");
        return;
      } /*Checks to see if any letters are out of bounds */
    } /*Checks for invalid characters used in arguments */
    if (codeType.compareTo("encode") == 0) {
      AllCaesar.encodeCaesar(str);
    } /*Calls encodeCaesar method for string in args*/ else if (codeType.compareTo("decode") == 0) {
      AllCaesar.decodeCaesar(str);
    } /*Calls decodeCaesar method for string in args */ else {
      System.err.println("Error: Invalid option. Valid options are \"encode\" and \"decode\"");
      return;
    } /*Checks for invalid encoding options */
  } /*main() */

  /**
   * @param str string to encode using all letters of the alphabet using a caesar cipher.
   */
  public static void encodeCaesar(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarEncrypt(str, ch));
    } /*loops over all letters in the alphabet and prints out result */
    pen.close();
  } /*encodeCaesar() */

  /**
   * @param str string to decode using all letters of the alphabet using a caesar cipher.
   */
  public static void decodeCaesar(String str) {
    PrintWriter pen = new PrintWriter(System.out, true);
    for (char ch = 'a'; ch <= 'z'; ch++) {
      pen.printf("n = %c: %s\n", ch, CipherUtils.caesarDecrypt(str, ch));
    } /*loops over all letters in the alphabet and prints out result */
    pen.close();
  } /*decodeCaesar() */





} /*AllCaesar */
