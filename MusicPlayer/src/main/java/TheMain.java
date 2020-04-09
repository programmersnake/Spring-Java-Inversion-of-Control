import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class TheMain {

    public static void main(String[] args){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.tld");
        Brain(context);
        context.close();
    }

    public static void Brain(ClassPathXmlApplicationContext context){
        Music testMusic;
        switch(new Scanner(System.in).nextInt()){
            case 1: { testMusic = context.getBean("ClassicalMusicBean", Music.class); }
            case 2: { testMusic = context.getBean("RockMusicBean", Music.class); }
            default: { testMusic = context.getBean("PopMusicBean", Music.class); }
        }
        MusicPlayer player = new MusicPlayer(testMusic);
        player.play();
    }

}
