package com.gmail.sge.serejka;

import java.io.File;

@SaveTo(path = "a.txt")
public class TextContainer {
    String text = "Some test text to save";
    SaverClass saverClass = new SaverClass();

    @Saver
    public void save(String path){
        saverClass.setFile(new File(path));
        saverClass.setText(this.text);
        saverClass.save();
    }
}