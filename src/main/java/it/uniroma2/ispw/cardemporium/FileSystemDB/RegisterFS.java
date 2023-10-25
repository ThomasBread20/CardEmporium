package it.uniroma2.ispw.cardemporium.FileSystemDB;

import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

import java.io.*;
import java.sql.Date;

public  class RegisterFS {
    File utenti=new File("Utenti");
    File credentials=new File("Credenziali");
    FileWriter fileWriterU;
    FileWriter fileWriterC;
    String user="Utente";
    int id=0;
    String []users;
    String line;
    {
        try {
            fileWriterU = new FileWriter("Utenti");
           fileWriterC =new FileWriter("Credentials");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public Boolean checkUser(String us){
        String []usernames;
        String l;

        try {
            BufferedReader br = new BufferedReader(new FileReader(credentials));
            while((l= br.readLine())!=null){
                usernames=l.split(" ");
                if(usernames[0]==us){
                    return false;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }


    public void addUser(String username, String pwd, String name, String surname, Date date) throws Exception {
        if(!utenti.exists() || !credentials.exists()){
            throw new Exception("file non esiste");
        }
        try {
            BufferedReader br = new BufferedReader(new FileReader(utenti));
            if (br.readLine() == null) {
                System.out.println("File is empty");

            }
            else {
                line=br.readLine();
                users=line.split(" ");
                id= Integer.parseInt(users[0]);
                System.out.println(id);

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Boolean i=checkUser(username);
        if(i==false){
            throw new ExceptionUserAlreadyExist("utente già esistente");
        }


       //scrivo su utenti
        fileWriterU.write(id+1);
        fileWriterU.write(name+" ");
        fileWriterU.write( surname+" ");
        fileWriterU.write(date +" ");
        fileWriterU.write(user+" ");
        fileWriterU.write("\n");


        //scrivo su credentials
        fileWriterC.write(username+" ");
        fileWriterC.write(pwd+" ");
        fileWriterC.write(id+1+" ");
        fileWriterC.write("\n");


    }
 }

