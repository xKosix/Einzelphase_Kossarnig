package com.example.einzelphase_kossarnig;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestThread extends Thread{
    String mtnr;
    String answer = "";
    RequestThread (String mtnr){
        this.mtnr = mtnr;
    }

    @Override
    public void run() {
        try {
            String sentence = this.mtnr;
            String modifiedSentence;
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);

            DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            outToServer.writeBytes(sentence + '\n');

            answer = inFromServer.readLine();

            clientSocket.close();

        } catch (Exception e){
            answer = "crashed ";
            //e.printStackTrace();
        }
    }

    public String getAnswer() {
        return answer;
    }
}