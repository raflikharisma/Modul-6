
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
/**
 @author Rafli Kharisma Akbar
 NIM 202110370311402
 JavaDoc Implementation
 */
class Kumpul {
    int[] inNumber = {};
    String[] inString = {};
    String tempInput;
    int fIndexString = 0, fIndexNum = 0;

    Scanner userInput = new Scanner(System.in);

    /**
     * this method inputs a number from the user.
     * @exception IOException handling input-output exception..
     * @see IOException
     */
     void inputData() throws IOException {
        System.out.print("Input data anda\t\t: ");
        tempInput = userInput.next();
        //Separating user-input based on data type.
        if (tempInput.matches("[a-zA-Z]+")) {
            inString = Arrays.copyOf(inString, inString.length+1);
            inString[fIndexString] = tempInput;
            addingString(inString[fIndexString]); //Calling addingString methods.
            fIndexString++;
        } else if (tempInput.matches("[0-9]+")) {
            inNumber = Arrays.copyOf(inNumber, inNumber.length+1);
            inNumber[fIndexNum] = Integer.parseInt(tempInput);
            addingNum(String.valueOf(inNumber[fIndexNum])); //Calling addingString methods.
            fIndexNum++;
        } else {
            showingCurrentNumberData();
            showingCurrentStringData();
            throw new RuntimeException("ERROR ANJING");
        }
    }

    /**
     * This method showing a temporary from both array.
     */
    void currentlyAddedNumData() {
        System.out.print("New Number Added\t: ");
        if (inNumber.length == 0) {
            System.out.print("Nothing Added");
        } else {
            for (int j : inNumber) {
                System.out.print(j + "  ");
            }
        }
    }
    void currentlyAddedStrData(){
        System.out.print("\nNew String Added\t: ");
        if (inString.length == 0) {
            System.out.print("Nothing Added");
        } else {
            for (String s : inString) {
                System.out.print(s + "  ");
            }
        }
    }

    /**
     * These method adding data to .txt file
     * @param theInput parameter valued by user-input.
     * @throws IOException handling input-output.
     * @see IOException
     */
    void addingNum(String theInput) throws IOException {
        FileWriter wr = new FileWriter("numData.txt", true);
        BufferedWriter bufferWr = new BufferedWriter(wr);
        bufferWr.write(theInput);
        bufferWr.newLine();
        bufferWr.flush();
        bufferWr.close();
    }
    void addingString(String theInput) throws IOException {
        FileWriter wr = new FileWriter("stringData.txt", true);
        BufferedWriter bufferWr = new BufferedWriter(wr);
        bufferWr.write(theInput);
        bufferWr.newLine();
        bufferWr.flush();
        bufferWr.close();
    }

    /**
     * These methods calling data from txt file.
     * @see IOException handling input output.
     */
    void showingCurrentStringData() {
        try {
            String readData;
            FileReader readWay = new FileReader("stringData.txt");
            BufferedReader readerFile = new BufferedReader(readWay);
            readData = readerFile.readLine();
            System.out.print("\nString Data\t\t\t: ");
            while (readData != null) {
                System.out.print(readData + " | ");
                readData = readerFile.readLine();
            }
            readWay.close();
            readerFile.close();

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
        void showingCurrentNumberData() {
            try {
                String readData;
                FileReader readWay = new FileReader("numData.txt");
                BufferedReader readerFile = new BufferedReader(readWay);
                readData = readerFile.readLine();
                System.out.print("\nNum data\t\t\t: ");
                while (readData != null) {
                    System.out.print(readData + " | ");
                    readData = readerFile.readLine();
                }
                readWay.close();
                readerFile.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public class Drive {
        /**
         * This method demonstrates all the process.
         * @param args Unused.
         * @exception IOException On input error.
         * @see IOException
         */
        public static void main(String[] args) throws IOException {
            Kumpul objekKelas = new Kumpul();
            char answer;
            Scanner userInput2 = new Scanner(System.in);
            do {
                objekKelas.inputData();
                System.out.print("Lagi(y/n)\t\t\t: ");
                answer = userInput2.next().charAt(0);
            } while (answer == 'y');
            objekKelas.currentlyAddedNumData();
            objekKelas.currentlyAddedStrData();
            objekKelas.showingCurrentStringData();
            objekKelas.showingCurrentNumberData();
        }
    }



