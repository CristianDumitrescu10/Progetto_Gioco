package Progetto_Gioco;
import java.util.Scanner;
import java.util.Random;
//Classe Astratta Personaggio
abstract class Personaggio {

    // Attributi privati
    private int salute;
    private int mana;
    private int attacco;
    private int livello;
    private int difesa;

    // Costruttore
    public Personaggio(int salute, int mana, int attacco, int livello, int difesa) {
        this.salute = salute;
        this.mana = mana;
        this.attacco = attacco;
        this.livello=livello;
        this.difesa=difesa;
    }

    // Getters
    public int getSalute() {
        return salute;
    }

    public int getMana() {
        return mana;
    }

    public int getAttacco() {
        return attacco;
    }
    public int getLivello() {
        return livello;
    }
    public int getDifesa() {
        return difesa;
    }

    // Setters
    public void setSalute(int salute) {
        this.salute = salute;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public void setLivello(int livello) {
        this.livello= livello;
    }
    public void setDifesa(int difesa) {
        this.difesa= difesa;
    }

    // Metodi astratti
    public abstract void attacca();

    public abstract void difendi();
    // Metodo per attaccare un Boss
    public void attacca(Boss boss) {
        int dannoInflitto = this.getAttacco() - boss.getDifesa();
        if (dannoInflitto > 0) {
            boss.setSalute(boss.getSalute() - dannoInflitto);
            System.out.println("Il personaggio attacca il boss per " + dannoInflitto + " punti di danno!");
        } else {
            System.out.println("Il tuo attacco non ha avuto effetto!");
        }
    }
}
    //Classe Guerriero
class Guerriero extends Personaggio {    
    
    public Guerriero(int salute, int mana, int attacco, int livello, int difesa) {
    super(salute, mana, attacco, livello, difesa);
    }

    @Override
    public void attacca() {
        System.out.println("Il guerriero attacca con la sua spada!");
    }

    @Override
    public void difendi() {
        System.out.println("Il guerriero alza il suo scudo per difendersi!");
    }
}
    //Classe Mago
class Mago extends Personaggio {

    public Mago(int salute, int mana, int attacco, int livello, int difesa) {
        super(salute, mana, attacco, livello, difesa);
    }

    @Override
    public void attacca() {
        System.out.println("Il Mago attacca con un incantesimo!");
    }

    @Override
    public void difendi() {
        System.out.println("Il Mago crea uno scudo d'energia");
    }
}
    //Classe Ladro
class Ladro extends Personaggio {

    public Ladro(int salute, int mana, int attacco, int livello, int difesa) {
        super(salute, mana, attacco, livello, difesa);
    }

    @Override
    public void attacca() {
        System.out.println("Il Ladro attacca con il suo coltello!");
    }

    @Override
    public void difendi() {
        System.out.println("Il Ladro schiva l'attacco");
    }
}
//classe Astratta Nemico
class Boss {

    private int salute;
    private int attacco;
    private int difesa;

    public Boss(int salute, int attacco, int difesa) {
        this.salute = salute;
        this.attacco = attacco;
        this.difesa = difesa;
    }

    public void attacca(Personaggio personaggio) {
        int dannoInflitto = this.attacco - personaggio.getDifesa();
        if (dannoInflitto > 0) {
            personaggio.setSalute(personaggio.getSalute() - dannoInflitto);
            System.out.println("Il boss attacca il personaggio per " + dannoInflitto + " punti di danno!");
        } else {
            System.out.println("L'attacco del boss non ha effetto!");
        }
    }

    // Metodi getter e setter per gli attributi del Boss
    public int getSalute() {
        return salute;
    }

    public void setSalute(int salute) {
        this.salute = salute;
    }

    public int getAttacco() {
        return attacco;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    public void setDifesa(int difesa) {
        this.difesa = difesa;
    }
}

public class GiocoTest {
    public static int generaValoreCasuale(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    public static void main(String[] args) {
        Scanner myStr = new Scanner(System.in);
        Scanner myInt = new Scanner(System.in);

        System.out.println("Ehi Straniero, Benveuto a Osteria Grande");
        System.out.println("Come ti chiami, straniero?");
        String nome=myStr.nextLine();
        boolean a=true;
        while (a==true) {
            System.out.println("Ciao "+nome+", cosa fai nella vita?");
            System.out.println("[1] Guerriero");
            System.out.println("[2] Mago");
            System.out.println("[3] Ladro");
            int sceltapersonaggio=myInt.nextInt();
            Personaggio personaggio = null;
            switch (sceltapersonaggio) {
                case 1:
                    int saluteCasuale = generaValoreCasuale(90, 120);
                    int manaCasuale= generaValoreCasuale(40, 60);
                    int attaccoCasuale = generaValoreCasuale(25, 30);
                    int difesaCasuale= generaValoreCasuale(25, 35);
                    System.out.println("Salve Sir " + nome + "!");
                    personaggio = new Guerriero(saluteCasuale, manaCasuale, attaccoCasuale, 1, difesaCasuale);
                    break;
                case 2:
                    int saluteCasuale1 = generaValoreCasuale(30, 40);
                    int manaCasuale1 = generaValoreCasuale(40, 60);
                    int attaccoCasuale1 = generaValoreCasuale(25, 30);
                    int difesaCasuale1 = generaValoreCasuale(25, 35);
                    System.out.println("Salve Mago/a " + nome + "!");
                    personaggio = new Mago(saluteCasuale1, manaCasuale1, attaccoCasuale1, 1, difesaCasuale1);
                    break;
                case 3:
                    int saluteCasuale2 = generaValoreCasuale(35, 50);
                    int manaCasuale2 = generaValoreCasuale(40, 60);
                    int attaccoCasuale2 = generaValoreCasuale(25, 30);
                    int difesaCasuale2 = generaValoreCasuale(15, 20);
                    System.out.println("Ehi Cane Maledetto, Riporta qui il mio coltello!");
                    personaggio = new Ladro(saluteCasuale2, manaCasuale2, attaccoCasuale2, 1, difesaCasuale2);
                    break;
                default:
                    System.out.println("Scelta non valida!");
                    break;
            }
            if (personaggio != null) {
            System.out.println("-----------------------------------------------");
            System.out.println("* Il tuo personaggio si addentra nelle foreste di Osteria Grande alla ricerca del Tortellino d'oro *");
            System.out.println("-----------------------------------------------");

            // Livello 1 - Il Goblin della Dozza
            System.out.println("LIVELLO 1 - Il Goblin della Dozza");
            System.out.println("Mentre ti avventuri verso la Pizzeria Desiderio, scopri un Goblin che ti impedisce il passaggio");

            Boss goblin = new Boss(70, 30, 10); // Esempio di un goblin come boss del livello 1
                while (goblin.getSalute() > 0 && personaggio.getSalute() > 0) {
                    personaggio.attacca(goblin);

                    if (goblin.getSalute() <= 0) {
                        System.out.println("Hai sconfitto il Goblin della Dozza!");
                        break;
                    }

                    goblin.attacca(personaggio);

                    if (personaggio.getSalute() <= 0) {
                        System.out.println("Sei stato sconfitto dal Goblin della Dozza...");
                        break;
                    }
            

                    if (personaggio.getSalute() > 0) {
                        System.out.println("Il Goblin della Dozza ti indica la direzione di Bologna come la zona ideale per trovare indizi sul tesoro!");
                        System.out.println("-----------------------------------------------");
                        personaggio.setLivello(2);
                        //personaggio = new Guerriero(100, 50, 25, 1, 20);
                        //personaggio = new Mago(80, 70, 20, 1, 15);
                        //personaggio = new Ladro(90, 60, 22, 1, 18);
                        if(sceltapersonaggio==1){
                            personaggio.setSalute(100);
                            System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20 punti");
                            System.out.println("[1]Salute(solo per la prossima battaglia)");
                            System.out.println("[2]Attacco");
                            System.out.println("[3]Difesa");
                            int sceltaUpgrade=myInt.nextInt();
                            if(sceltaUpgrade==1){
                                
                                personaggio.setSalute(personaggio.getSalute()+20);

                            }else if(sceltapersonaggio==2){
                                personaggio.setAttacco(personaggio.getAttacco()+20);
                            }else if(sceltapersonaggio==3){
                                personaggio.setDifesa(personaggio.getAttacco()+20);

                            }else{

                            }

                        }else if(sceltapersonaggio==2){
                            personaggio.setSalute(80);
                            System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20punti");
                            System.out.println("[1]Salute(solo per la prossima battaglia)");
                            System.out.println("[2]Attacco");
                            System.out.println("[3]Difesa");
                            int sceltaUpgrade=myInt.nextInt();
                            if(sceltaUpgrade==1){
                                
                                personaggio.setSalute(personaggio.getSalute()+20);

                            }else if(sceltapersonaggio==2){
                                personaggio.setAttacco(personaggio.getAttacco()+20);

                            }else if(sceltapersonaggio==3){
                                personaggio.setDifesa(personaggio.getAttacco()+20);

                            }else{
                            }


                        }else if(sceltapersonaggio==3){
                            personaggio.setSalute(90);
                            System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20");
                            System.out.println("[1]Salute(solo per la prossima battaglia)");
                            System.out.println("[2]Attacco");
                            System.out.println("[3]Difesa");
                            int sceltaUpgrade=myInt.nextInt();
                            if(sceltaUpgrade==1){
                                
                                personaggio.setSalute(personaggio.getSalute()+20);

                            }else if(sceltapersonaggio==2){
                                personaggio.setAttacco(personaggio.getAttacco()+20);

                            }else if(sceltapersonaggio==3){
                                personaggio.setDifesa(personaggio.getAttacco()+20);

                            }else{

                            }
                        
                        }
                        System.out.println("La Salute del tuo personaggio è stata restabilità");

                        // Livello 2 - La Strega del Pratello
                        System.out.println("LIVELLO 2 - La Strega del Pratello");
                        System.out.println("Mentre ti avventuri nella Via del Pratello, ti imbatti in una Strega Comunista, che ha una pergamena che indica la posizione del tesoro");

                        Boss strega = new Boss(70, 20, 15); 
                        while (strega.getSalute() > 0 && personaggio.getSalute() > 0) {
        
                            personaggio.attacca(strega);

                            if (strega.getSalute() <= 0) {
                                System.out.println("Hai sconfitto la Strega del Pratello!");
                                break;
                            }

                            strega.attacca(personaggio);

                            if (personaggio.getSalute() <= 0) {
                                System.out.println("Sei stato sconfitto dalla Strega del Pratello...");
                                break;
                            }
                        }

                            if (personaggio.getSalute() > 0) {
                                personaggio.setLivello(2);
                                //personaggio = new Guerriero(100, 50, 25, 1, 20);
                                //personaggio = new Mago(80, 70, 20, 1, 15);
                                //personaggio = new Ladro(90, 60, 22, 1, 18);
                                if(sceltapersonaggio==1){
                                    personaggio.setSalute(100);
                                    System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20");
                                    System.out.println("[1]Salute(solo per la prossima battaglia)");
                                    System.out.println("[2]Attacco");
                                    System.out.println("[3]Difesa");
                                    int sceltaUpgrade=myInt.nextInt();
                                    if(sceltaUpgrade==1){
                                        
                                        personaggio.setSalute(personaggio.getSalute()+20);

                                    }else if(sceltapersonaggio==2){
                                        personaggio.setAttacco(personaggio.getAttacco()+20);

                                    }else if(sceltapersonaggio==3){
                                        personaggio.setDifesa(personaggio.getAttacco()+20);

                                    }else{

                                    }

                                }else if(sceltapersonaggio==2){
                                    personaggio.setSalute(80);
                                    System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20");
                                    System.out.println("[1]Salute(solo per la prossima battaglia)");
                                    System.out.println("[2]Attacco");
                                    System.out.println("[3]Difesa");
                                    int sceltaUpgrade=myInt.nextInt();
                                    if(sceltaUpgrade==1){
                                        
                                        personaggio.setSalute(personaggio.getSalute()+20);

                                    }else if(sceltapersonaggio==2){
                                        personaggio.setAttacco(personaggio.getAttacco()+20);

                                    }else if(sceltapersonaggio==3){
                                        personaggio.setDifesa(personaggio.getAttacco()+20);

                                    }else{
                                    }


                                }else if(sceltapersonaggio==3){
                                    personaggio.setSalute(90);
                                    System.out.println("Sei Salito di Livello cosa vuoi migliorare di 20");
                                    System.out.println("[1]Salute(solo per la prossima battaglia)");
                                    System.out.println("[2]Attacco");
                                    System.out.println("[3]Difesa");
                                    int sceltaUpgrade=myInt.nextInt();
                                    if(sceltaUpgrade==1){
                                        
                                        personaggio.setSalute(personaggio.getSalute()+20);

                                    }else if(sceltapersonaggio==2){
                                        personaggio.setAttacco(personaggio.getAttacco()+20);

                                    }else if(sceltapersonaggio==3){
                                        personaggio.setDifesa(personaggio.getAttacco()+20);

                                    }else{

                                    }
                                
                                }
                            System.out.println("La Pergamena ti indica San Luca come possibile ubicazione del Tortellino");
                            System.out.println("-----------------------------------------------");

                            // Livello 3 - Il Dragone di San Luca
                            System.out.println("LIVELLO 3 - Il Dragone di San Luca");
                            System.out.println("Mentre cerchi di scalare il Monte di San Luca, vicinissimo al Tortellino d'Oro ti imbatti in un terribile Dragone");

                            Boss dragone = new Boss(100, 25, 20); 
                            while (dragone.getSalute() > 0 && personaggio.getSalute() > 0) {
                                personaggio.attacca(dragone);

                                
                                if (dragone.getSalute() <= 0) {
                                    System.out.println("Hai sconfitto il Dragone di San Luca!");
                                    break;
                                }

                                dragone.attacca(personaggio);

                                if (personaggio.getSalute() <= 0) {
                                    System.out.println("Sei stato sconfitto dal Dragone di San Luca...");
                                    break;
                                }
                            }

                            // Se il personaggio è vivo, hai vinto il gioco
                            if (personaggio.getSalute() > 0) {
                            System.out.println("Congratulazioni, hai trovato il Tortellino d'Oro!!!");
                            System.out.println("E mo, che vuoi fare con sto tortellino?");
                            System.out.println("THE END");

                            System.out.println("Vuoi Riprovare la storia? si per ricominciare");
                            String seleziozio=myStr.nextLine();

                            if (seleziozio.equalsIgnoreCase("si")){
                                continue;

                            }else{
                                a=false;
                            }
                            
                        }
                        }
                    }
                }
            }
        }
    }
}

    
