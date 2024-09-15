package edu.grinnell.csc207.main;

import java.io.PrintWriter;
import edu.grinnell.csc207.util.CipherUtils;

/**
 * Alternate main file that encodes and decodes using all letters of the alphabet.
 * Uses Caesar Cipher.
 */
public class AllCaesar {

  /**
   * @param args arguments passed in as input. An encoding option and string.
   */
  public static void main(String[] args) {
    if (args.length < 2) {
      System.err.println("Error: Incorrect number of parameters.");
      return;
    } /*Checks for incorrect number of parameters */
    String str = args[1];
    String codeType = args[0];
    if (!str.contains("abcdefghijklmnopqrstuvwxyz")) {
      System.err.println("Error: String contains characters other than lowercase letters.");
      return;
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
