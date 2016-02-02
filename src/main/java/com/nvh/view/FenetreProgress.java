package com.nvh.view;

import com.nvh.controller.Solve;
import com.nvh.model.Dictionnaire;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class FenetreProgress extends JFrame implements Observer {
    private static final long serialVersionUID = -596843077674913400L;
    private JPanel contentPane = new JPanel();
    static public JProgressBar bar = new JProgressBar();

    public FenetreProgress() {
        this.setFont(new Font(FenetrePrincipale.mainFont, Font.PLAIN, 11));

        this.setTitle("Recherche...");
        this.setBounds(600, 460, 276, 64);
        this.setAlwaysOnTop(true);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        this.setContentPane(contentPane);
        contentPane.setLayout(null);

        bar.setMinimum(0);
        bar.setMaximum(Dictionnaire.dico.length - 30000);

        bar.setFont(new Font(FenetrePrincipale.mainFont, Font.PLAIN, 12));
        bar.setBounds(0, 0, 270, 35);
        bar.setStringPainted(true);
        contentPane.add(bar, BorderLayout.CENTER);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        contentPane.setVisible(true);

    }

    @Override
    public void update(Observable obs, Object obj) {
        if (obs instanceof Solve)
            bar.setValue(Solve.indexDico);

    }
}
