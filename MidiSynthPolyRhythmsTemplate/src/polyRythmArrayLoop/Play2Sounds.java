package polyRythmArrayLoop;

import javax.sound.midi.*;

//Java Program to Illustrate JAva Sound API

//Importing classes from
//javax.sound package

//Main class
//MiniMusicApp
public class Play2Sounds {

	// Method 1
	// Main driver method
	public static void main(String[] args)
	{
		// Creating object of class inside main()
		PlaySound minimusic = new PlaySound();

		// Calling method 2 to play the sound
		minimusic.play();

		// Display message on the console for
		// successful execution of program
		System.out.print(
			"Successfully compiled and executed");
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
			Sequence seq = new Sequence(Sequence.PPQ, 4);

			// Creating a new track
			Track track = seq.createTrack();
			Track track2 = seq.createTrack();

			// Making a Message
			ShortMessage a = new ShortMessage();
			ShortMessage aTrack2 = new ShortMessage();

			// Put the Instruction in the Message
			a.setMessage(144, 1, 44, 100);
			aTrack2.setMessage(144, 2, 44, 100);

			// Make a new MidiEvent
			MidiEvent noteOn = new MidiEvent(a, 4);
			MidiEvent noteOn2 = new MidiEvent(aTrack2, 8);

			// Add MidiEvent to the Track
			track.add(noteOn);
			track2.add(noteOn2);
			
			
			
			
		
			ShortMessage b = new ShortMessage();
			ShortMessage bTrack2 = new ShortMessage();
			
			b.setMessage(128, 1, 44, 100);
			MidiEvent noteOff = new MidiEvent(b, 1);
			track.add(noteOff);
			
			bTrack2.setMessage(128, 2, 44, 100);
			MidiEvent noteOff2 = new MidiEvent(bTrack2, 8);
			track2.add(noteOff2);
					

			// Giving sequence to Sequencer
			player.setSequence(seq);

			// Start the Sequencer using start() method
			player.start();
		}

		// Catch block to handle exceptions
		catch (Exception ex) {
			// Display the exception on console
			// along with line number
			ex.printStackTrace();
		}
	}
}