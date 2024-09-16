/**
 * Benjamin Sheeley.
 * CSC207 Mini Project 1.
 * CipherUtils.java.
 */
package edu.grinnell.csc207.util;

/**
 * Utils to implement other files in the project.
 */
public class CipherUtils {
  /**
   * length of alphabet.
   */
  private static final int ALPHABET_LENGTH = 26;

  /**
   * offset to convert character to letter.
   */
  private static final int LETTER_OFFSET = 97;


  /**
   * @param letter character to be turned into an integer.
   * @return returns int that matches letter.
   */
  private static int letter2int(char letter) {
    int convertedInt = (int) letter - LETTER_OFFSET;
    return convertedInt;
  } /*letter2int() */

/**
 * @param i int to be converted to character.
 * @return returns character that matches i.
 */
  private static char int2letter(int i) {
    char convertedLetter = (char) (i + LETTER_OFFSET);
    return convertedLetter;
  } /*int2letter() */


  /**
   * @param str string to be encrypted.
   * @param letter letter used to encrypt str with.
   * @return returns encrypted string with caesar cipher.
   */
  public static String caesarEncrypt(String str, char letter) {
    int key = letter2int(letter);
    char[] encryptArr = str.toCharArray();
    char[] encryptArrNew = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      encryptArrNew[i] = int2letter((letter2int(encryptArr[i]) + key) % ALPHABET_LENGTH);
    } /*ends loop for decrypting cipher */
    String encryptedString = new String(encryptArrNew);
    return encryptedString;
  } /*caesarEncrypt */

/**
 * @param str String to be decrypted
 * @param letter letter we use to decrypt str.
 * @return returns a decrypted string with the caesar cipher.
 */

  public static String caesarDecrypt(String str, char letter) {
    int key = letter2int(letter);
    char[] decryptArr = str.toCharArray();
    char[] decryptArrNew = new char[str.length()];
    for (int i = 0; i < str.length(); i++) {
      int arrConvert = letter2int(decryptArr[i]) - key;
      decryptArrNew[i] = int2letter(arrConvert);
      if (letter2int(decryptArrNew[i]) < 0) {
        int restoreChar = letter2int(decryptArrNew[i]) + ALPHABET_LENGTH;
        decryptArrNew[i] = int2letter(restoreChar);
      } /*accounts for alphabet overflow */
    } /*ends loop over string to be decrypted */
    String decryptedString = new String(decryptArrNew);
    return decryptedString;
  } /*caesarDecrypt()*/


  /**
   * @param str string to be ecnrypted.
   * @param key key to encrypt string with.
   * @return returns a encrypted string with a vigenere cipher.
   */
  public static String vigenereEncrypt(String str, String key) {
    char[] strArr = str.toCharArray();
    char[] keyArr = key.toCharArray();
    char[] strArrNew = new char[str.length()];
    int tracker = 0;
    for (int i = 0; i < str.length(); i++) {
      if ((i % key.length()) >= 0) {
        if (((i % key.length()) == 0) && (i >= key.length())) {
          tracker += key.length();
        } /*increase tracker offset */
        int encryptKey = (letter2int(keyArr[i - tracker]));
        if ((encryptKey + letter2int(strArr[i])) >= ALPHABET_LENGTH) {
          strArrNew[i] = int2letter((letter2int(strArr[i]) + encryptKey) % ALPHABET_LENGTH);
          continue;
        } /*encrypt while overflowing back to the beginning of the alphabet */ else {
          strArrNew[i] = int2letter(letter2int(strArr[i]) + encryptKey);
          continue;
        } /* if all other conditions fail, encrypt as normal*/
      } /*end of calculations using tracker */
      int encryptKey = (letter2int(keyArr[i]));
      strArrNew[i] = int2letter(letter2int(strArr[i]) + encryptKey);
    } /*Finish encrypting */
    String encryptedStr = new String(strArrNew);
    return encryptedStr;
  } // vigenereEncrypt()



  /**
   * @param str string to be decrypted.
   * @param key key to decrypted str with.
   * @return A Decrypted vigenere cipher.
   */
  public static String vigenereDecrypt(String str, String key) {
    char[] strArr = str.toCharArray();
    char[] keyArr = key.toCharArray();
    char[] strArrNew = new char[str.length()];
    int tracker = 0;
    for (int i = 0; i < str.length(); i++) {
      if ((i % key.length()) >= 0) {
        if (((i % key.length()) == 0) && (i >= key.length())) {
          tracker += key.length();
        } //adding more indices to subtract for tracker
        int decryptKey = (letter2int(keyArr[i - tracker]));
        if ((letter2int(strArr[i]) - decryptKey) < 0) {
          strArrNew[i] = int2letter((letter2int(strArr[i]) - decryptKey + ALPHABET_LENGTH));
          continue;
        } /*overflowing onto other end of alphabet*/ else {
          strArrNew[i] = int2letter(letter2int(strArr[i]) - decryptKey);
          continue;
        } /*end of tracker iteration block*/
      } /*end of iteration within tracker*/
      int decryptKey = (letter2int(keyArr[i]));
      strArrNew[i] = int2letter(letter2int(strArr[i]) - decryptKey);
    } /*end of for loop*/
    String decryptedStr = new String(strArrNew);
    return decryptedStr;
  }  /*vigenereDecrypt()*/
} /*CipherUtils*/
