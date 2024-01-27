package it.uniroma2.ispw.cardemporium.filesystemdb;

import it.uniroma2.ispw.cardemporium.dao.RegisterDAO;

import it.uniroma2.ispw.cardemporium.exception.ExceptionUserAlreadyExist;


import java.io.*;
import java.sql.Date;




public  class RegisterFS implements RegisterDAO {

    BufferedReader br;

    static String fileName ="src/main/java/it/uniroma2/ispw/cardemporium/filesystemdb/Credenziali";
    static String fileName1 ="src/main/java/it/uniroma2/ispw/cardemporium/filesystemdb/Utenti";
    static BufferedWriter fileWriter;
    static BufferedWriter fileWriter1;

   static  {
        try {
            fileWriter = new BufferedWriter(new FileWriter(fileName,true));
            fileWriter1 = new BufferedWriter(new FileWriter(fileName1,true));

        } catch (IOException e) {
            e.getMessage();
        }
    }

    @Override
    public void addUser(String username, String pwd, String name, Date date, String cognome) throws ExceptionUserAlreadyExist {

        try {

            int id=getID()+1;
            fileWriter.write(username+" "+pwd+" "+id);

            fileWriter.newLine();
            fileWriter.close();
            fileWriter1.write(id+" "+name+" "+cognome+" "+date+" "+"Utente"+ " "+0);
            fileWriter1.newLine();
            fileWriter1.close();
        } catch (IOException e) {
            e.getCause();
        }

    }
    String line;
    public int getID(){
        int newid = 0;
        try {


            br = new BufferedReader(new FileReader(fileName1));

            while (( line=br.readLine()) != null) {
                newid++;
            }
        } catch (IOException e) {
            e.getMessage();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.getCause();
            }
        }
        return newid;
    }
}

