package com.binus.finalproject.page;

public interface BasePage {
    void display();

     default void displayBorder(String chara) {
        final int QTY = 53;
        for(int i = 0; i < QTY; i++)
            System.out.print(chara + " ");
        System.out.println("");
    }

    default String displaySideBorder(String menu) {
        int countedTab = (int) Math.round((double)(93 - menu.length()) / 4.0);
        String tabPrinted = "";
        for(int i = 0; i < countedTab; i++)
            tabPrinted += "\t";
        return tabPrinted;
    }
}
