/**
 * Moved all music stuff over to this file
 * Instead of having a playlist, just put everything in one file and loop it
 * Dan Joshwa
 * version 1
 * 3/22/2020
 */
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
public class musicPlayer
{
    public static void playMusic(String fileName)//use for playing individual songs
    {
        File song = new File(fileName);
        try
        {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(song));
            clip.start();
            //clip.loop(Clip.LOOP_CONTINUOUSLY);//we're not doing full backround music
        }
        catch(Exception e)
        {
            System.out.println("Audio Error");
        }
    }
}
