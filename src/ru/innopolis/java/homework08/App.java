package ru.innopolis.java.homework08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) {
        try (BufferedReader br = Files.newBufferedReader(Path.of("src/ru/innopolis/java/homework08/test.txt"))) {
            String condition = "";
            Product [] productsArray = new Product[0];
            Person [] personsArray = new Person[0];
            try (BufferedWriter bw = Files.newBufferedWriter(Path.of("src/ru/innopolis/java/homework08/output.txt"))) {
                try {
                    int counter = 0;
                    while (!condition.equals("END")) {
                        for (String line : br.readLine().split("\n")) {
                            if (line.equals("END")) {
                                condition = "END";
                                break;
                            }
                            if (counter == 0) {
                                //считывание покупателей
                                personsArray = PersonConverter.convertFromString(line);
                            }
                            if (counter == 1) {
                                //считывание продуктов
                                productsArray = ProductConverter.convertFromString(line);
                            }
                            if (counter > 1) {
                                //считывание покупок
                                String name = line.substring(0, line.lastIndexOf(" "));
                                int idPerson = PersonConverter.getPersonIndexByName(personsArray, name);
                                String productName = line.substring(line.lastIndexOf(" ") + 1);
                                int idProduct = ProductConverter.getProductIndexByProductName(productsArray, productName);

                                if (personsArray[idPerson].addProductToPack(productsArray[idProduct])) {
                                    bw.write(personsArray[idPerson].getName() + " купил(а) " + productsArray[idProduct].getProductName());
                                    bw.newLine();
                                } else {
                                    bw.write(personsArray[idPerson].getName() + " не может позволить себе " + productsArray[idProduct].getProductName());
                                    bw.newLine();
                                }
                            }
                            counter++;
                        }
                    }
                    bw.newLine();
                    //вывод в файл итоговой строки
                    for (Person person : personsArray) {
                        bw.write(person.toString());
                        bw.newLine();
                    }
                }
                catch (IllegalArgumentException | NullPointerException e) {
                    bw.write(e.getMessage());
                }
                bw.flush();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}