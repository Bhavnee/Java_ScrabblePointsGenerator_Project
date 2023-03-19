package com.example.scrabblepointsgenerator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeMap;

public class ScrabbleController
{

        @FXML
        private void initialize ()
        {
            System.out.println("Ready!!!");
        }

        @FXML
        private void A (ActionEvent event)
        {
            Tex.setText(Tex.getText() + "A");
        }

        @FXML
        private void B (ActionEvent event)
        {
            Tex.setText(Tex.getText() + "B");
        }

        @FXML
        private void C (ActionEvent event)
        {
            Tex.setText(Tex.getText() + "C");
        }

        @FXML
        private void D (ActionEvent event)
        {
            Tex.setText(Tex.getText() + "D");
        }

        @FXML
        private void E(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "E");
        }

        @FXML
        private void F(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "D");
        }

        @FXML
        private void G(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "G");
        }

        @FXML
        private void H(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "H");
        }

        @FXML
        private void I(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "I");
        }

        @FXML
        private void J(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "J");
        }

        @FXML
        private void K(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "K");
        }

        @FXML
        private void L(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "L");
        }

        @FXML
        private void M(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "M");
        }

        @FXML
        private void N(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "N");
        }

        @FXML
        private void O(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "O");
        }

        @FXML
        private void P(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "P");
        }

        @FXML
        private void Q(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "Q");
        }

        @FXML
        private void R(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "R");
        }

        @FXML
        private void S(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "S");
        }

        @FXML
        private void T(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "T");
        }

        @FXML
        private void U(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "U");
        }

        @FXML
        private void V(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "V");
        }

        @FXML
        private void W(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "W");
        }

        @FXML
        private void X(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "X");
        }

        @FXML
        private void Y(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "Y");
        }

        @FXML
        private void Z(ActionEvent event)
        {
            Tex.setText(Tex.getText() + "Z");
        }


        @FXML
        private TextField Previous, Tex, TotalPoints, ErrorMessageDisplay;



        private String wordSubmitted;
        private ArrayList<String> wordsLeft = new ArrayList<String>();

        private static TreeMap<Character, Integer> treeMap;
        static {
            treeMap = new TreeMap<>();

            //put() => add data     .get() => retrieve
            treeMap.put('A', 9);
            treeMap.put('B', 2);
            treeMap.put('C', 2);
            treeMap.put('D', 4);
            treeMap.put('E', 12);
            treeMap.put('F', 2);
            treeMap.put('G', 3);
            treeMap.put('H', 2);
            treeMap.put('I', 8);
            treeMap.put('J', 1);
            treeMap.put('K', 1);
            treeMap.put('L', 4);
            treeMap.put('M', 2);
            treeMap.put('N', 6);
            treeMap.put('O', 8);
            treeMap.put('P', 2);
            treeMap.put('Q', 1);
            treeMap.put('R', 6);
            treeMap.put('S', 4);
            treeMap.put('T', 6);
            treeMap.put('U', 4);
            treeMap.put('V', 2);
            treeMap.put('W', 2);
            treeMap.put('X', 1);
            treeMap.put('Y', 2);
            treeMap.put('Z', 1);
        }

        public int pointsGenerated = 0;
        //word is valid
        private boolean wordIsValid()
        {
            if (wordSubmitted.length()>=2 && wordSubmitted.length()<=8 && wordSubmitted.matches("\\w*([AEIOU])\\w*") &&
                    wordSubmitted.matches("[A-Z]*") && !wordsLeft.contains(wordSubmitted))
            {
                return true;
            }
            else
                return false;
        }
        private boolean wordCanBeUsed()
        {
            char[] character = wordSubmitted.toCharArray();
            Set<Character> allKeys = treeMap.keySet();
            for (char c : character)
            {
                for (Character key : allKeys)
                {
                    if (key == c)
                    {
                        if (treeMap.get(key) > 0)
                        {
                            treeMap.put(key, treeMap.get(key) - 1);
                            break;
                        }
                        else
                        {
                            throw new IllegalArgumentException("The letter" + key + " has already been used!!!");
                        }
                    }
                }
            }
        return true;
        }

    public int TotalPointsGenerated()
    {
        char[] character = wordSubmitted.toCharArray();
        Set<Character> allKeys = treeMap.keySet();
        for (char c : character){
            for (Character key : allKeys){
                if (key==c){
                    pointsGenerated += treeMap.get(key);
                }
            }
        }
        return pointsGenerated;
    }

    public boolean FinishGame()
    {
        Set<Character> allKeys = treeMap.keySet();
        int wordCount = 0;
        int vowelsLeft = 0;
        for (Character key : allKeys)
        {
            String keyString = Character.toString(key);
            wordCount += treeMap.get(key);
            if(keyString.matches("[AEIOU]"))
            {
                vowelsLeft += treeMap.get(key);
            }
        }
        if (wordCount == 1 || vowelsLeft ==0)
        {
            return true;
        }
        else
            return false;
    }
    private String PreviousWord()
    {
        {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < wordsLeft.size(); i++)
            {
                sb.append(wordsLeft.get(i));
                if (i != wordsLeft.size() - 1)
                {
                    sb.append(",");
                }
            }
            //wordsLeft.clear();
            return sb.toString();
        }
    }


    @FXML
    private void Submit (ActionEvent event)
    {
        wordSubmitted = Tex.getText().trim().toUpperCase();
        if(!FinishGame())
        {
            if (wordIsValid())
            {
                try
                {
                    if (wordCanBeUsed())
                    {
                        wordsLeft.add(wordSubmitted);
                        ErrorMessageDisplay.setText("");
                        Tex.setText("");
                        TotalPoints.setText(Integer.toString(TotalPointsGenerated()));
                        Previous.setText(PreviousWord());
                    }
                }
                catch (IllegalArgumentException e)
                {
                    Tex.setText("");
                    ErrorMessageDisplay.setText(e.getMessage());
                }
            }
            else
            {
                Tex.setText("");
                ErrorMessageDisplay.setText("Word you have submitted cannot be duplicated. " +
                        "They must contain minimum 2 letters and maximum 8 letters.");
            }
        }
        else
        {
            Tex.setText("");
            ErrorMessageDisplay.setText("Game Over!");
        }
    }

}
