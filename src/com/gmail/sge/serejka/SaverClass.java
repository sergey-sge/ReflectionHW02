package com.gmail.sge.serejka;

import java.io.*;

public class SaverClass {
    private String text;
    private File file;

    public SaverClass(){
        super();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void save(){
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.append(text);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File saved");
    }
}
