package it.uniroma2.ispw.cardemporium.filesystemdb;

import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;

import it.uniroma2.ispw.cardemporium.exception.ExceptionDBerror;
import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public  class RegisterFS implements RegisterDAO {
    Logger logger=Logger.getLogger(RegisterFS.class.getName());
    File utenti=new File("Utenti");
    File credentials=new File("Credenziali");
    static FileWriter fileWriterU;
    static FileWriter fileWriterC;
    String user="Utente";
    int id=0;
    String []users;
    String line;


    static {
        try {
            fileWriterU = new FileWriter("Utenti");
            fileWriterC =new FileWriter("Credentiali");
        } catch (IOException e) {
            e.getCause();
        }
    }

    public Boolean checkUser(String us){
        String []usernames;
        String l;

        try
                (BufferedReader br = Files.newBufferedReader(Path.of("Credenziali"), Charset.defaultCharset())){
            while((l= br.readLine())!=null){
                usernames=l.split(" ");
                if(usernames[0].equals(us)){
                    return false;
                }

            }


        } catch (IOException e) {
            e.getCause();
        }
        return true;
    }




    @Override
    public void addUser(String username, String pwd, String name, Date date, String cognome) {
        if(!utenti.exists() || !credentials.exists()){
            try {
                throw new ExceptionDBerror("file non esiste");
            } catch (ExceptionDBerror e) {
                e.getCause();
            }
        }
        line=null;
        try (
            BufferedReader br = new BufferedReader(new FileReader(utenti))){
            if ((line=br.readLine()) != null) {
                line=br.readLine();
                users=line.split(" ");
                id= Integer.parseInt(users[0]);



            }
            else {
                logger.log(Level.INFO,"File is empty");


            }

        } catch (IOException e) {
            e.getCause();
        }
        Boolean i=checkUser(username);
        if(Boolean.FALSE.equals(i)){
            try {
                throw new ExceptionUserAlreadyExist("utente già esistente");
            } catch (ExceptionUserAlreadyExist e) {
                e.getMessage();
            }
        }


        //scrivo su utenti
        try {
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
        } catch (IOException e) {
            e.getCause();
        }


    }
}

