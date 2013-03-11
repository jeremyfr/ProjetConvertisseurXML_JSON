/*
 * IGMenu.java                                                     11/03/2013
 */
package dcll.jfri.projetConvertisseur;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Interface graphique presentant les informations necessaires a savoir pour
 * convertir un fichier : le nom du fichier.
 * @author Jérémy Fricou
 * @version 1.0
 */
public class IGMenu {
    /** Coordonnee X de la fenetre */
    private static final int X = 300;
    /** Coordonnee Y de la fenetre */
    private static final int Y = 100;
    /** Hauteur de la fenetre */
    private static final int HAUTEUR = 200;
    /**Largeur de la fenetre */
    private static final int LARGEUR = 500;
    /** Titre de la fenetre */
    private static final String TITRE_FENETRE =
                      "Conversion de fichier XML et JSON";
    /** Taille police Titre */
    private static final int TAILLE_TITRE = 24;
    /** Taille du bouton de convertion */
    private static final int TAILLE_CONV = 24;
    /** Taille du bouton de choix de fichier */
    private static final int TAILLE_CHOIX = 10;
    /** Fenetre affichee */
    private JFrame fenetre;
    /** Container de la fenetre */
    private Container c;
    /** Panneau d'affichage des informations de la fenetre */
    private JPanel titre, boutons, conversion;
    /** Bouton de conversion des fichier */
    private JButton convertir;
    /** Affichage du chemin du fichier selectionne */
    private JTextField chemin;
    /** Extension du fichier a convertir */
    private String extension;
    /** Descripteur du fichier a convertir */
    private File fichier;

    /**
     * Constructeur par defaut de l'application graphique.
     */
    public IGMenu() {
        // Attributs de la fenetre affichee
        fenetre = new JFrame("Conversion XML - JSON");
        fenetre.setResizable(false);
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setBounds(X, Y, LARGEUR, HAUTEUR);
        // Conteneur de la fenetre
        c = fenetre.getContentPane();
        c.setBackground(Color.yellow);
        c.setLayout(new BorderLayout());

        // Ajout du titre a la fenetre
        makePanneauTitre();
        // Ajout des boutons a la fenetre
        makePanneauBoutons();
        // Ajout du panneau contenant le champs texte et le bouton d'explorer
        makePanneauConversion();
        init();

        fenetre.setVisible(true);  // Affichage de la fenetre
    }

    /**
     * Creation du panneau contenant le titre de la fenetre
     */
    private void makePanneauTitre() {
        // Creation du panneau contenant le titre de la fenetre
        titre = new JPanel();
        titre.setLayout(new FlowLayout(FlowLayout.CENTER));
        titre.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
        // Titre de la fenetre
        JLabel titreLabel = new JLabel(TITRE_FENETRE);
        titreLabel.setFont(new Font("Arial", Font.PLAIN, TAILLE_TITRE));
        titre.add(titreLabel);  // Ajout du titre au panneau

        c.add(titre, BorderLayout.NORTH);  // Ajout du panneau a la fenetre
    }

    /**
     * Creation du panneau contenant les boutons du programme
     */
    private void makePanneauBoutons() {
        // Creation du bouton de conversion
        convertir = new JButton("Choisir un fichier");
        convertir.setEnabled(false);
        convertir.setFont(new Font("Arial", Font.BOLD, TAILLE_CONV));
        convertir.addActionListener(new ActionListener() {
            /*
             * Enregistrement du fichier converti suivant l'extension du
             * fichier a convertir
             */
            public void actionPerformed(ActionEvent actionEvent) {
                // Attributs utiles pour la conversion
                IConvertisseur convert = null;
                String resultatParsing = "";
                // Definition de l'action en fontion de l'extension du fichier
                // 0 = XML -> JSON , 1 = JSON -> XML
                int action = extension.equals("XML")
                        ? 0 : extension.equals("JSON") ? 1 : -1;
                switch(action) {
                    // XML -> JSON
                    case 0:
                      convert = new Xml2json();
                      try {
                          resultatParsing = convert.transform(chemin.getText());
                      } catch (IOException e) {
                          JOptionPane.showMessageDialog(fenetre,
                                  "Erreur de format interne de fichier");
                          init();
                      }
                      break;
                    // JSON -> XML
                    case 1:
                      convert = new Json2xml();
                      try {
                          resultatParsing = convert.transform(chemin.getText());
                      } catch (IOException e) {
                          JOptionPane.showMessageDialog(fenetre,
                                  "Erreur de format interne de fichier");
                          init();
                      }
                      break;
                    default:  // -1
                        JOptionPane.showMessageDialog(fenetre,
                                "Erreur de fontionnement de l'application");
                        System.exit(0);  // Fermeture de l'application
                        init();
                }
                // Creation du chemin du fichier resultat
                String cheminResultat = chemin.getText().substring(
                        0, chemin.getText().lastIndexOf('.'));
                cheminResultat += ".out."
                       + (extension.equals("XML") ? "json" : "xml");
                // Creation et enregistrement du fichier resultat converti
                convert.enregistrer(resultatParsing, cheminResultat);
                JOptionPane.showMessageDialog(fenetre, 
                        "Fichier converti enregistré");
            }
        });
        // Creation du panneau contenant les boutons de la fenetre
        boutons = new JPanel();
        boutons.setLayout(new FlowLayout(FlowLayout.CENTER));
        boutons.add(convertir);

        c.add(boutons,BorderLayout.SOUTH);  // Ajout du panneau a la fenetre
    }

    /**
     * Creation du panneau contenant les outils permettant la conversion a
     * l'utilisateur
     */
    private void makePanneauConversion() {
        // Creation du panneau contenant les outils necessaires a l'utilisateur
        conversion = new JPanel();

        // Creation du label indiquant le chemin du fichier a convertir
        JLabel cheminLabel = new JLabel("Chemin du fichier a convertir : ");
        cheminLabel.setAlignmentY (Component.CENTER_ALIGNMENT);
        conversion.add(cheminLabel);  // Ajout du label au panneau

        // Creation du champs texte permettant du connaitre le chemin du fichier
        chemin = new JTextField(30);
        chemin.setAlignmentY (Component.CENTER_ALIGNMENT);
        conversion.add(chemin);       // Ajout du textfield au panneau

        // Choix du fichier a convertir
        JButton explorer = new JButton("Choisir...");
        explorer.setFont(new Font("Arial", Font.BOLD, TAILLE_CHOIX));
        explorer.addActionListener(new ActionListener() {
            /*
             * Ouverture d'une fenetre de choix de fichier.
             */
            public void actionPerformed(ActionEvent actionEvent) {
                // Selection de fichier
                JFileChooser choix = new JFileChooser(".");
                if (choix.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    convertir.setEnabled(true);  // Le bouton est selectionnable
                    fichier = choix.getSelectedFile();
                    chemin.setText(fichier.getPath()); // affichage du chemin
                    // Recuperation de l'extension du fichier choisi
                    extension = chemin.getText().substring(
                            chemin.getText().lastIndexOf('.')+1
                           ,chemin.getText().length()).toUpperCase();
                    // Changement du texte du bouton en fontion de l'extension
                    // du fichier selectionne
                    if (extension.equals("JSON") ) {
                        convertir.setText("Convertir en fichier xml");
                    } else if(extension.equals("XML")) {
                        convertir.setText("Convertir en fichier json");
                    } else {
                        init();
                        convertir.setText("Fichier choisi incompatible");
                        convertir.setEnabled(false);// Chosir autre fichier
                    }
                }
            }
        });
        conversion.add(explorer);  // Ajout du bouton

        c.add(conversion,BorderLayout.CENTER);  // Ajout du panneau a la fenetre
    }

    /**
     * Initialisation des variables de base a des valeurs par defaut.
     */
    private void init() {
        chemin.setText("");
        extension = "";
        fichier = null;
    }
}
