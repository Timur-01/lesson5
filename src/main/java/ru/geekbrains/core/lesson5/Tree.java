package ru.geekbrains.core.lesson5;

import java.io.File;

public class Tree {
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
                subDirTotal++;
        }

        int subDirCounter = 0;
        int filesCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory()){
                print(files[i], indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            }
            else {
                print(files[i], indent,
                        filesCounter  == (files.length-subDirTotal) - 1);
                filesCounter++;
            }

        }


    }

}
