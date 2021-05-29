package sgi.login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @author DEROUAULT
 * @version 0.1 : Date : 29/05/2021
 * Permet de lancer la fenêtre pour s'authentifier
 */
public class ui extends JFrame {

    /**
     * Permet de rentrer le nom d'utilisateur
     */
    public JTextField nomUser = new JTextField("Nom d'utilisateur", 5);

    /**
     * Permet de rentrer le mot de passe
     */
    public JPasswordField password = new JPasswordField(5);;

    /**
     * Permet de se connecter
     */
    public JButton connexion = new JButton("Connexion");

    public ui(){

        //Etabli le titre de la fenêtre
            this.setTitle("SGI - Login");
        //Donne le layout à suivre
            this.setLayout(new GridLayout(4,1));
        //Donne le dimension de la fenêtre
            this.setSize(500,500);
        //Définie l'opération à suivre en cas de clic sur le bouton quitter
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //On interdit le redimensionnement
            this.setResizable(false);

        //On positionne la fenêtre au centre de l'écran
            Dimension dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(dimScreen.width / 2 - this.getSize().width / 2, dimScreen.height / 2 - this.getSize().height / 2);

        //On crée les différents objets
            contenu();

        //On affiche la fenêtre et affiche son contenu
            this.setVisible(true);
            this.repaint();
            this.revalidate();


    }

    /**
     * Permet de créer le contenu de la fenêtre pour s'authentifier
     */
    private void contenu(){
        //Titre
            JLabel titre = new JLabel("Authentification",SwingConstants.CENTER);
            titre.setFont(new Font("Serif", Font.BOLD, 35));

        //Nom d'utilisateur
            nomUser.setForeground(Color.GRAY);
            nomUser.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (nomUser.getText().equals("Nom d'utilisateur")) {
                        nomUser.setText("");
                        nomUser.setForeground(Color.BLACK);
                    }
                }
                @Override
                public void focusLost(FocusEvent e) {
                    if (nomUser.getText().isEmpty()) {
                        nomUser.setText("Nom d'utilisateur");
                        nomUser.setForeground(Color.GRAY);
                    }
                }
            });

        //Mot de passe
        password.setForeground(Color.GRAY);


        this.add(titre);
        this.add(nomUser);
        this.add(password);
        this.add(connexion);
    }

}
