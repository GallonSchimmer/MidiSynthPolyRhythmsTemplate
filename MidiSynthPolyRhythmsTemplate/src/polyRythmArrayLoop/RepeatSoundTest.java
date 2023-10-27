package polyRythmArrayLoop;

import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

//Java Program to Illustrate JAva Sound API

//Importing classes from
//javax.sound package

//Main class
//MiniMusicApp
public class RepeatSoundTest {

	// Method 1
	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of class inside main()
		RepeatSoundTest minimusic = new RepeatSoundTest();

		
		//for loop to play 12 times the note
		for (int i = 0; i < 12; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			System.out.println(" sleep after start loop");
			
		// Calling method 2 to play the sound
		minimusic.play();

		// Display message on the console for
		// successful execution of program
		System.out.println(
			"Successfully compiled and executed");
		}
	}

	// Method 2
	// To play the sound
	public void play()
	{
		

		// Try block to check for exceptions
		try {
			
			
				
				
			// Getting a sequencer and open it
			Sequencer player = MidiSystem.getSequencer();
			player.open();

			// Making 1a new Sequence
			Sequence seq = new Sequence(Sequence.PPQ, 4);// the note duration is a quarter note

			
			// Creating a new track
			Track track = seq.createTrack();
			
			
			
			
			
			
			

			// Making a Message
			ShortMessage a = new ShortMessage();
			// Put the Instruction in the Message
			a.setMessage(144, 1, 44, 100);
			// Make a new MidiEvent
				MidiEvent noteOn = new MidiEvent(a, 1);
			// Add MidiEvent to the Track
			track.add(noteOn);
			//System.out.println("noteON sounding");
			
			// Making a Message
			ShortMessage b = new ShortMessage();
			// Put the Instruction in the Message
			a.setMessage(144, 1, 44, 100);
				MidiEvent noteOn2 = new MidiEvent(b, 2);
			// Add MidiEvent to the Track
			track.add(noteOn2);
			//System.out.println("noteON sounding");
			
			
			// Making a Message
			ShortMessage c = new ShortMessage();
			// Put the Instruction in the Message
			a.setMessage(144, 1, 44, 100);
				MidiEvent noteOn3 = new MidiEvent(c, 3);
			// Add MidiEvent to the Track
			track.add(noteOn3);
			//System.out.println("noteON sounding");
			
			
			
			
			
			//Thread.sleep(1000);
			//System.out.println("sleep after noteOn");
			
			ShortMessage d = new ShortMessage();	
			b.setMessage(144, 1, 44, 100);
			MidiEvent noteon4 = new MidiEvent(d, 4); //duration of the note not the beat
			track.add(noteon4);
			
			
			//Thread.sleep(2000);
			//System.out.println("sleep after first note");
		
			

			// Giving sequence to Sequencer
			player.setSequence(seq);
			//System.out.println("Preparing seq");

			// Start the Sequencer using start() method
			player.start();
			//System.out.println("Play");
			
			
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display the exception on console
			// along with line number
			ex.printStackTrace();
		}
	}
}