package Progetto_Gioco;
import java.util.Scanner;
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
    public void attacca(Boss boss) {
        int dannoInflitto = attacco - boss.getDifesa();
        if (dannoInflitto > 0) {
            boss.setSalute(boss.getSalute() - dannoInflitto);
            System.out.println("Il personaggio attacca il boss per " + dannoInflitto + " punti di danno!");
        } else {
            System.out.println("L'attacco del personaggio è stato bloccato!");
        }
    }

    public void difendi(Boss boss) {
        int dannoRiduzione = difesa;
        int dannoSubito = boss.getAttacco() - dannoRiduzione;
        if (dannoSubito > 0) {
            salute -= dannoSubito;
            System.out.println("Il personaggio subisce " + dannoSubito + " punti di danno!");
        } else {
            System.out.println("La difesa del personaggio ha bloccato l'attacco!");
        }
    }
}
    //Classe Guerriero
class Guerriero extends Personaggio {

    public Guerriero(int salute, int mana, int attacco, int livello,int difesa) {
        super(salute, mana, attacco, livello,difesa);
    }

    public void attacca() {
        System.out.println("Il guerriero attacca con la sua spada!");
    }

    public void difendi() {
        System.out.println("Il guerriero alza il suo scudo per difendersi!");
    }
}
    //Classe Mago
class Mago extends Personaggio {

    public Mago(int salute, int mana, int attacco, int livello,int difesa) {
        super(salute, mana, attacco, livello,difesa);
    }

    public void attacca() {
        System.out.println("Il Mago attacca con un incantesimo!");
    }

    public void difendi() {
        System.out.println("Il Mago crea uno scudo d'energia");
    }
}
    //Classe Ladro
class Ladro extends Personaggio {

    public Ladro(int salute, int mana, int attacco, int livello, int difesa) {
        super(salute, mana, attacco, livello,difesa);
    }

    public void attacca() {
        System.out.println("Il Ladro attacca con il suo coltello!");
    }

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
        int dannoInflitto = attacco - personaggio.getDifesa();
        if (dannoInflitto > 0) {
            personaggio.setSalute(personaggio.getSalute() - dannoInflitto);
            System.out.println("Il boss attacca il personaggio per " + dannoInflitto + " punti di danno!");
        } else {
            System.out.println("L'attacco del boss è stato bloccato!");
        }
    }
    public void combatti(Personaggio personaggio) {
        boolean giocatoreVivo = true;
        boolean bossVivo = true;

        while (giocatoreVivo && bossVivo) {
            // Turno del personaggio
            personaggio.attacca(this);

            // Controllo vittoria del personaggio
            if (this.salute <= 0) {
                giocatoreVivo = false;
                System.out.println("Il personaggio ha sconfitto il boss!");
                break;
            }

            // Turno del boss
            this.attacca(personaggio);

            // Controllo vittoria del boss
            if (personaggio.getSalute() <= 0) {
                bossVivo = false;
                System.out.println("Il boss ha sconfitto il personaggio!");
                break;
            }
        }
    }
    public int getSalute() {
        return salute;
    }

    public int getAttacco() {
        return attacco;
    }

    public int getDifesa() {
        return difesa;
    }

    // Setters
    public void setSalute(int salute) {
        this.salute = salute;
    }

    public void setAttacco(int attacco) {
        this.attacco = attacco;
    }

    public void setDifesa(int difesa) {
        this.difesa= difesa;
    }
}

public class GiocoTest {

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
            switch (sceltapersonaggio) {
                case 1:
                    System.out.println("Salve Sir "+nome+"!");
                    Guerriero personaggioGuerriero= new Guerriero(100,50,20,1,40);
                    //Fai in modo di scegliere il Guerriero
                    
                    break;
    
                case 2:
                    System.out.println("Salve Mago/a "+nome+"!");
                    Mago personaggioMago= new Mago(80,70,15,1,20);
                    
                    break;
    
                case 3:
                    System.out.println("Ehi Cane Maledetto, Riporta qui il mio coltello!");
                    Ladro personaggioLadro= new Ladro(90, 60, 18,1,20);
    
                    //Aggiungi un coltello all ladro
                    
                    break;
            
                default:
                    //Fai in modo di ciclare
                    break;
            }
    
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            System.out.println("*il tuo personaggio si addentra nelle foreste di Osteria Grande alla ricerca del Tortellino d'oro*");
            System.out.println(" ");
            System.out.println("-----------------------------------------------");
            System.out.println(" ");
            System.out.println("LIVELLO 1-Il Goblin della Dozza");
            System.out.println("Mentre ti avventuri verso la Pizzeria Desiderio, scopri un Goblin che ti impedisce il passaggio");
            //Inserisci la battaglia livello 1
            System.out.println("Hai distrutto: Il Goblin della Dozza");
            System.out.println("il Goblin della Dozza ti indica la direzione di Bologna come la zona ideale per trovare indizi sul tesoro! ");
    
    
    
    
    
    
            System.out.println("LIVELLO 2-La Strega del Pratello");
            System.out.println("Mentre ti avventuri nella Via del Pratello, ti imbatti in una Strega Comunista, che ha una pergamena che indica la posizione del tesoro");
            //Inserisci la battaglia livello 2
            System.out.println("Hai distrutto: La Strega del Pratello!!!");
            System.out.println("La Pergamena ti indica San Luca come possibile ubbicazione del Tortellino");
    
    
    
    
    
            System.out.println("LIVELLO 3- Il Dragone di San Luca");
            System.out.println("Mentre cerchi di scalare il Monte di San Luca, vicinissimo al Tortellino d'Oro ti imbatti in un terribile Dragone");
            //Inserisci la battaglia livello 3
            System.out.println("Hai distrutto: Il Dragone di San Luca, e la tua scalata prosegue");
            
            //BOSS FINALE????
    
            System.out.println("Congratulazioni hai trovato il tortellino d'oro!!!");
            System.out.println(" e mo che famo con sto tortellino?");
            System.out.println("----THE END----");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("----CREDITI----");
            System.out.println("Solo Cristian :( ");
            System.out.println("Vuoi rigiocare il gioco? si per rigiocare");
            String volontaUscita=myStr.nextLine();
            if(volontaUscita.equalsIgnoreCase("si")){

            }else{
                
            }
            
        }


    }
    
}