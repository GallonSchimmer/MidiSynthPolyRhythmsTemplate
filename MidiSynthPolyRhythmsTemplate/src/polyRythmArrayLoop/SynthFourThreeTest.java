package polyRythmArrayLoop;

import java.util.Arrays;
import java.util.List;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.MidiChannel;

/**
 * A little example showing how to play a tune in Java.
 * 
 * Inputs are not sanitized or checked, this is just to show how simple it is.
 * 
 * @author Peter
 */
public class SynthFourThreeTest {
	
	private static List<String> notes = Arrays.asList("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B");
	private static MidiChannel[] channels;
	private static int INSTRUMENT = 0; // 0 is a piano, 9 is percussion, other channels are for other instruments
	private static int VOLUME = 80; // between 0 et 127
	
	public static void main( String[] args ) {
		
		try {
			// * Open a synthesizer
			Synthesizer synth = MidiSystem.getSynthesizer();
			synth.open();
			channels = synth.getChannels();


			//try first with a number to be seen each every 4 beats and at the same time another every 3 beats
			//String[] fourThree = new String[] { "34", " ", " ", "3", "4", " ", "3", " ", "4", "3", " ", " "};
			
			
			for (int i = 0; i < 12; i++) {
				
			
			play("6G",  100);
			rest(100);
			rest(100);
			play("6D",  100);
			play("6G",  100);
			rest(100);
			play("6D",  100);
			rest(100);
			play("6G",  100);
			play("6D",  100);
			rest(100);
			rest(100);
			
			}
			
			// * finish up
			synth.close();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Plays the given note for the given duration
	 */
	private static void play(String note, int duration) throws InterruptedException
	{
			// * start playing a note
			channels[INSTRUMENT].noteOn(id(note), VOLUME );
			// * wait
			Thread.sleep( duration );
			// * stop playing a note
			channels[INSTRUMENT].noteOff(id(note));
	}
	
	/**
	 * Plays nothing for the given duration
	 */
	private static void rest(int duration) throws InterruptedException
	{
		Thread.sleep(duration);
	}
	
	/**
	 * Returns the MIDI id for a given note: eg. 4C -> 60
	 * @return
	 */
	private static int id(String note)
	{
		int octave = Integer.parseInt(note.substring(0, 1));
		return notes.indexOf(note.substring(1)) + 12 * octave + 12;	
	}
}


//https://gist.github.com/pbloem/d29bf80e69d333415622
