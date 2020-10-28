public class ShiftRailFenceCipher {

    public static String encryption(String plaintext, int key) {
        plaintext=plaintext.toUpperCase();
        char[] transpositedCharAarry = new char[plaintext.length()];
        int n = 0;
        int shift=key;
        int numberOfRow=key;

        for(int k = 0 ; k < numberOfRow; k ++) {
            int index = k;
            boolean condition = true;
            while(index < plaintext.length() ) {

                transpositedCharAarry[n] = plaintext.charAt(index);
                n++;

                if(k == 0 || k == numberOfRow - 1) {
                    index = index + 2 * (numberOfRow - 1);
                }
                else if(condition) {
                    index = index +  2 * (numberOfRow - k - 1);
                    condition = !condition;
                }
                else {
                    index = index + 2 * k;
                    condition = !condition;
                }
            }//End of While
        }//End of for statement
        String transpositedString=String.valueOf(transpositedCharAarry);
        //shift
        String substitutionString ="";

        for (int i = 0; i < transpositedString.length(); i++) {
            char character = (char) (((int) transpositedString.charAt(i) + shift - 65) % 26 + 65);
            substitutionString+=character;
        }
        String cipherText=substitutionString;

        return cipherText;
    }

    public static String decryption(String ciphertext, int key) {
        ciphertext=ciphertext.toUpperCase();
        String substitutionString ="";
        for (int i=0; i<ciphertext.length(); i++)
        {
            char character = (char)( ((((int) ciphertext.charAt(i) -key - 65) % 26)+26)%26 + 65);
            substitutionString+=character;
        }

        char[] transpositedCharAarry = new char[substitutionString.length()];
        int n = 0;
        int shift=key;
        int numberOfRow=key;
        for(int k = 0 ; k < numberOfRow; k ++) {
            int index = k;
            boolean condition = true;
            while(index < ciphertext.length() ) {
                //System.out.println(k + " " + index+ " "+ n );
                transpositedCharAarry[index] = substitutionString.charAt(n);
                n++;
                if(k == 0 || k == numberOfRow - 1) {
                    index = index + 2 * (numberOfRow - 1);
                }
                else if(condition) {
                    index = index +  2 * (numberOfRow - k - 1);
                    condition = !condition;
                }
                else {
                    index = index + 2 * k;
                    condition = !condition;
                }
            }
        }
        String plaintext=String.valueOf(transpositedCharAarry);
        return plaintext;
    }

    public static void main(String[] args) {
        String data = "meetmeafterthetogaparty";
        String encrypted =encryption(data,2);
        System.out.println(encrypted);
        String decrypted = decryption(encrypted,2);
        System.out.println(decrypted);


    }
}


