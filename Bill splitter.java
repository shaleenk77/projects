import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.FontUIResource;

class Expense {
    String title, paidBy;
    ArrayList<String> paidFor = new ArrayList<>();
    double amount;

    public Expense(String title, String paidBy, double amount) {
        this.title = title;
        this.paidBy = paidBy;
        this.amount = amount;
    }

    void setAmount(double amount) {
        this.amount = amount;
    }

    void setPaidBy(String name) {
        this.paidBy = name;
    }

    void addPaidFor(String name) {
        this.paidFor.add(name);
    }

    public String toString() {
        String str = paidBy + " paid " + amount + " for ";
        for (String pF : paidFor) {
            str = str + pF + ", ";
        }
        return str;
    }

}

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 0;

        System.out.println("\n\n   ====================  WELCOME TO BILL SPLITTER  ====================\n");
        while (true) {
            System.out.print("          ENTER NUMBER OF PARTICIPANTS : ");
            try {
                n = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("\n            !!! ENTER VALID NUMBER !!!\n");
            }
        }

        if (n == -1) {

            n = 4; // number of participants, get from runtime

            String[] participants = { "Shaleen", "Talha", "Inzamam", "Het" }; // name of all participants, get from
                                                                              // runtime

            HashMap<Integer, String> participantMap = new HashMap<>();
            HashMap<String, Integer> participantMapAlter = new HashMap<>();
            for (int i = 0; i < participants.length; i++) {
                participantMap.put(i, participants[i]);
                participantMapAlter.put(participants[i], i);
            }

            // static expenses for testing purposes, get from runtime
            ArrayList<Expense> expenses = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                expenses.add(new Expense("Expense" + (i + 1), null, 0));
            }
            expenses.get(0).amount = 300;
            expenses.get(0).paidBy = participantMap.get(1);
            expenses.get(0).addPaidFor(participantMap.get(0));
            expenses.get(0).addPaidFor(participantMap.get(1));

            expenses.get(1).amount = 726;
            expenses.get(1).paidBy = participantMap.get(0);
            expenses.get(1).addPaidFor(participantMap.get(0));
            expenses.get(1).addPaidFor(participantMap.get(1));
            expenses.get(1).addPaidFor(participantMap.get(2));
            expenses.get(1).addPaidFor(participantMap.get(3));

            expenses.get(2).amount = 640;
            expenses.get(2).paidBy = participantMap.get(2);
            expenses.get(2).addPaidFor(participantMap.get(0));
            expenses.get(2).addPaidFor(participantMap.get(1));
            expenses.get(2).addPaidFor(participantMap.get(2));
            expenses.get(2).addPaidFor(participantMap.get(3));

            expenses.get(3).amount = 120;
            expenses.get(3).paidBy = participantMap.get(3);
            expenses.get(3).addPaidFor(participantMap.get(0));
            expenses.get(3).addPaidFor(participantMap.get(1));
            expenses.get(3).addPaidFor(participantMap.get(2));
            expenses.get(3).addPaidFor(participantMap.get(3));

            double transactionGraph[][] = new double[n][n];
            for (int i = 0; i < expenses.size(); i++) {
                Expense crrExpense = expenses.get(i);
                for (int j = 0; j < crrExpense.paidFor.size(); j++) {
                    String paidFor = crrExpense.paidFor.get(j);
                    transactionGraph[participantMapAlter.get(paidFor)][participantMapAlter
                            .get(crrExpense.paidBy)] += crrExpense.amount / crrExpense.paidFor.size();
                }
            }

            for (int i = 0; i < transactionGraph.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (transactionGraph[i][j] > transactionGraph[j][i]) {
                        transactionGraph[j][i] = transactionGraph[i][j] - transactionGraph[j][i];
                        transactionGraph[i][j] = 0;
                    } else {
                        transactionGraph[i][j] = transactionGraph[j][i] - transactionGraph[i][j];
                        transactionGraph[j][i] = 0;
                    }
                }
            }

            double[] totalAmount = { 0, 0, 0, 0 };
            for (int i = 0; i < transactionGraph.length; i++) {
                double spent = 0, toReceive = 0;
                for (int j = 0; j < transactionGraph[i].length; j++) {
                    spent += transactionGraph[i][j];
                    toReceive += transactionGraph[j][i];
                }
                totalAmount[i] = spent - toReceive;
            }

            System.out.println("Suggested transactions inorder to settle amounts");

            int numOfSettledPraticipants = 0;

            for (int i = 0; i < totalAmount.length; i++) {
                if (totalAmount[i] == 0) {
                    numOfSettledPraticipants++;
                }
            }

            while (true) {
                if (numOfSettledPraticipants == n) {
                    break;
                }

                int minIndex = 0;
                int maxIndex = 0;

                for (int i = 1; i < totalAmount.length; i++) {
                    if (totalAmount[i] < totalAmount[minIndex]) {
                        minIndex = i;
                    } else if (totalAmount[i] > totalAmount[maxIndex]) {
                        maxIndex = i;
                    }
                }

                int absMinIndex = 0;
                if (Math.abs(totalAmount[minIndex]) > Math.abs(totalAmount[maxIndex])) {
                    absMinIndex = maxIndex;
                } else {
                    absMinIndex = minIndex;
                }

                double newMinIndexAmount = totalAmount[minIndex] + Math.abs(totalAmount[absMinIndex]);
                double newMaxIndexAmount = totalAmount[maxIndex] - Math.abs(totalAmount[absMinIndex]);
                double transfer = Math.abs(totalAmount[absMinIndex]);

                totalAmount[minIndex] = newMinIndexAmount;
                totalAmount[maxIndex] = newMaxIndexAmount;

                if (transfer != 0) {
                    System.out.println("\t" + participantMap.get(minIndex) + " must pay " + participantMap.get(maxIndex)
                            + " an amount of INR" + transfer);
                }

                numOfSettledPraticipants++;

            }

        } else {

            HashMap<Integer, String> participant = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                System.out.print("\n\n          ENTER NAME OF THE PARTICIPANT-" + i + " : ");
                String name = sc.nextLine();
                participant.put(i, name);
            }

            ArrayList<Expense> expenses = new ArrayList<>();

            boolean flag = true;
            double transactionGraph[][] = new double[n][n];
            while (flag) {
                // System.out.println( "\n\n -1. STATIC VALUE");
                System.out.println("          1. ADD EXPENSE");
                System.out.println("          2. EXIT\n");
                System.out.print("            ENTER : ");
                int x = 0;
                try {
                    x = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("INVALID INPUT");
                    System.exit(0);
                }
                switch (x) {

                    case 1:
                        for (int i = 1; i <= n; i++) {
                            System.out.println("               " + i + ". " + participant.get(i));
                        }
                        int payer = 0;
                        double amount =0;
                        String receive = "";
                        try{
                            System.out.print("\n          ENTER THE PERSON WHO PAYS : ");
                            payer = sc.nextInt();
                            System.out.print("\n          ENTER THE TOTAL AMOUNT PAID : ");
                            amount = sc.nextDouble();
                            sc.nextLine();
                            System.out.print("\n          ENTER RECEIVERS SEPERATED BY COMMA : ");
                            receive = sc.nextLine();
                        }catch( Exception e ){
                            System.out.println("INVALID INPUT");
                            System.exit(0);
                        }
                        String[] arr = receive.split(",");
                        Expense temp = new Expense("", participant.get(payer), amount);
                        for (int j = 0; j < arr.length; j++) {
                            transactionGraph[Integer.parseInt(arr[j]) - 1][payer - 1] += amount / arr.length;
                            temp.addPaidFor(participant.get(Integer.parseInt(arr[j])));
                        }
                        expenses.add(temp);

                        break;

                    case 2:
                        flag = false;
                        break;
                }
            }

            System.out.println("\n\n               TRANSACTIONS");
            for (Expense exp : expenses) {
                System.out.println("          " + exp.toString());
            }

            // for( int i = 0; i < n; i++ ){
            // for( int j = 0; j < n; j++ ){
            // System.out.print( transactionGraph[i][j] + " ");
            // }
            // System.out.println();
            // }

            // System.out.println("\n\nAFTER MINUS\n\n");
            for (int i = 0; i < transactionGraph.length; i++) {
                for (int j = 0; j <= i; j++) {
                    if (transactionGraph[i][j] > transactionGraph[j][i]) {
                        transactionGraph[j][i] = transactionGraph[i][j] - transactionGraph[j][i];
                        transactionGraph[i][j] = 0;
                    } else {
                        transactionGraph[i][j] = transactionGraph[j][i] - transactionGraph[i][j];
                        transactionGraph[j][i] = 0;
                    }
                }
            }

            // for( int i = 0; i < n; i++ ){
            // for( int j = 0; j < n; j++ ){
            // System.out.print( transactionGraph[i][j] + " ");
            // }
            // System.out.println();
            // }

            double[] totalAmount = new double[n];
            for (int i = 0; i < transactionGraph.length; i++) {
                double spent = 0, toReceive = 0;
                for (int j = 0; j < transactionGraph[i].length; j++) {
                    spent += transactionGraph[i][j];
                    toReceive += transactionGraph[j][i];
                }
                totalAmount[i] = spent - toReceive;
            }

            System.out.println("\n\n          SUGGESTED TRANSACTIONS IN ORDER TO SETTLE AMOUNTS");

            int numOfSettledPraticipants = 0;

            for (int i = 0; i < totalAmount.length; i++) {
                if (totalAmount[i] == 0) {
                    numOfSettledPraticipants++;
                }
            }

            while (true) {

                if (numOfSettledPraticipants == n) {
                    break;
                }

                int minIndex = 0;
                int maxIndex = 0;

                for (int i = 1; i < totalAmount.length; i++) {
                    if (totalAmount[i] < totalAmount[minIndex]) {
                        minIndex = i;
                    } else if (totalAmount[i] > totalAmount[maxIndex]) {
                        maxIndex = i;
                    }
                }

                int absMinIndex = 0;
                if (Math.abs(totalAmount[minIndex]) > Math.abs(totalAmount[maxIndex])) {
                    absMinIndex = maxIndex;
                } else {
                    absMinIndex = minIndex;
                }

                double newMinIndexAmount = totalAmount[minIndex] + Math.abs(totalAmount[absMinIndex]);
                double newMaxIndexAmount = totalAmount[maxIndex] - Math.abs(totalAmount[absMinIndex]);
                double transfer = Math.abs(totalAmount[absMinIndex]);

                totalAmount[minIndex] = newMinIndexAmount;
                totalAmount[maxIndex] = newMaxIndexAmount;

                if (transfer != 0) {
                    System.out
                            .println("\t" + participant.get(minIndex + 1) + " must pay " + participant.get(maxIndex + 1)
                                    + " an amount of INR" + transfer);
                }

                numOfSettledPraticipants++;

            }
        }
    }
}