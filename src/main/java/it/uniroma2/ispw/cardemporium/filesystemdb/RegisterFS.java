package it.uniroma2.ispw.cardemporium.filesystemdb;

import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

import java.io.*;
import java.sql.Date;


public  class RegisterFS implements RegisterDAO {
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
            e.printStackTrace();
        }
    }

    public Boolean checkUser(String us){
        String []usernames;
        String l;

        try {
            BufferedReader br = new BufferedReader(new FileReader(credentials));
            while((l= br.readLine())!=null){
                usernames=l.split(" ");
                if(usernames[0].equals(us)){
                    return false;
                }

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }




    @Override
    public void addUser(String username, String pwd, String name, Date date, String cognome) throws Exception {
        if(!utenti.exists() || !credentials.exists()){
            throw new ExceptionDBerror("file non esiste");
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
        if(Boolean.FALSE.equals(i)){
            throw new ExceptionUserAlreadyExist("utente già esistente");
        }


        //scrivo su utenti
        fileWriterU.write(id+1);
        fileWriterU.write(name+" ");
        fileWriterU.write( cognome+" ");
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

