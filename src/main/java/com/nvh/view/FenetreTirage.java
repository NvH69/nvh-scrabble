package com.nvh.view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("serial")
public class FenetreTirage extends JInternalFrame implements Observer {

    public FenetreTirage() {
        setBounds(210, 689, 258, 71);
        setTitle("Tirage");
        setVisible(true);
        getContentPane().setLayout(new GridBagLayout());
    }

    @Override
    public void update(Observable o, Object t) {
        if (t instanceof String) {

            this.getContentPane().removeAll();
            this.repaint();
            for (int i = 0; i < ((String) t).length(); i++) {
                if (((String) t).charAt(i) == '*') FenetrePlateau.drawLettre('0', i + 1, 0, false, this);
                else if (Character.isAlphabetic(((String) t).charAt(i)))
                    FenetrePlateau.drawLettre(((String) t).charAt(i), i + 1, 0, false, this);
            }
        }
    }
}
