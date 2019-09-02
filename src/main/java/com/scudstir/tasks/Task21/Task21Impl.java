package com.scudstir.tasks.Task21;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class Task21Impl implements Task21 {

    @Override
    public List<String> reverseFile(File input, File output) throws IOException {
        List<String> stringList = new ArrayList<>();
        FileReader reader = new FileReader(input);
        Scanner scan = new Scanner(reader);
        while (scan.hasNext()) {
            stringList.add(scan.next());
        }
        reader.close();
        scan.close();
        FileWriter writer = new FileWriter(output, false);
        ListIterator<String> iterator = stringList.listIterator(stringList.size());
        while (iterator.hasPrevious()) {
            writer.write(iterator.previous() + " ");
        }
        writer.close();
        return stringList;
    }


    public static void main(String[] args) {
        File fileInput = new File("D://Java//Новая папка", "File.txt");
        File fileOutput = new File("D://Java//Новая папка", "Output File.txt");
        Task21Impl taskObject = new Task21Impl();
        try {
            taskObject.reverseFile(fileInput, fileOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}