import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        SymulatorTermostatu symtermostat = new SymulatorTermostatu();
        symtermostat.PodajTemperature();


    }
}
class Termostat {
    public float aktualnaTemperatura = 20;
    public float ustawionaTemperatura;

    public Termostat(float ustawionaTemperatura){
        this.ustawionaTemperatura = ustawionaTemperatura;
    }

    public void wlaczOgrzewanie(){

        if(aktualnaTemperatura < this.ustawionaTemperatura){
            aktualnaTemperatura+= 0.5;
            System.out.println("Włączono ogrzewanie");
        }



    }
    public void  wlaczChlodzenie(){


        if(aktualnaTemperatura > this.ustawionaTemperatura){
            aktualnaTemperatura-= 0.5;
            System.out.println("Włączono Chłodzenie");
        }


    }

    public void wylaczChlodzenie(){
        aktualnaTemperatura += 0;
    }
    public void wylaczOgrzewanie(){
        aktualnaTemperatura += 0;
    }

    public void sprawdzTemperature(){

        System.out.println("Aktualna temperatura to: " + aktualnaTemperatura );
        System.out.println("Docelowa temperatura to: " + ustawionaTemperatura);
    }
}

class SymulatorTermostatu{

    public void PodajTemperature() {
        int tmpW = 0;
        float temp = 0;
        while (tmpW == 0) {
            System.out.println("Podaj oczekiwaną temperaturę (10-40)");
            Scanner sc = new Scanner(System.in);  // zeskanowanie oczekiwanej temperatury
            temp = sc.nextFloat();
            if (temp <= 40 && temp >= 10) {
                tmpW = 1;
            } else if (temp > 40) {
                System.out.println("Temperatura za wysoka");
            } else {
                System.out.println("Temperatura za niska");
            }

        }
        Start(temp);
    }

    public void Start(float oczTempFloat){

        Termostat termostat = new Termostat(oczTempFloat);

        while(termostat.aktualnaTemperatura != termostat.ustawionaTemperatura){
            if(termostat.aktualnaTemperatura > termostat.ustawionaTemperatura){
                try{
                    Thread.sleep(500);
                    termostat.wlaczChlodzenie();
                }catch(Exception e){
                    System.out.println("ERROR nie wlaczono chlodzenia");
                }


            }
            try{
                Thread.sleep(500);
                termostat.wlaczOgrzewanie();
            }catch(Exception e){
                System.out.println("ERROR nie wlaczono ogrzewania");
            }

            termostat.sprawdzTemperature();
        }




    }


}
