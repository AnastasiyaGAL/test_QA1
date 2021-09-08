import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static float Xo;
    public static float Yo;
    public static float Ro;
    public static float Xt;
    public static float Yt;

    public static void main(String[] args) {
        float Xo=0,Yo=0, Ro=0, Xt=0,Yt=0;
        try {
            Scanner sc1 = new Scanner(new File(args[0]));
            while(sc1.hasNext()){
                Xo=sc1.nextFloat();
                Yo=sc1.nextFloat();
                Ro=sc1.nextFloat();
            }
            sc1.close();
            }catch(FileNotFoundException e){e.printStackTrace();}
        //System.out.println(Xo+" "+Yo);
        try {
            Scanner sc2 = new Scanner(new File(args[1]));
            while(sc2.hasNext()) {
                for (int i=1; i<2; i++) {
                    Xt=sc2.nextFloat();
                    Yt=sc2.nextFloat();
                    //System.out.println(Xt+" "+Yt);
                    if (Math.abs((Xt-Xo)*(Xt-Xo))+Math.abs((Yt-Yo)*(Yt-Yo))==Ro*Ro)
                        System.out.println(0/*+"-точка лежит на окружности"*/);
                    else if (Math.abs((Xt-Xo)*(Xt-Xo))+Math.abs((Yt-Yo)*(Yt-Yo))<Ro*Ro)
                        System.out.println(1/*+"-точка внутри"*/);
                    else System.out.println(2/*+"-точка снаружи"*/);
                }
            }
            sc2.close();
        }catch(FileNotFoundException e){e.printStackTrace();}
    }
}

