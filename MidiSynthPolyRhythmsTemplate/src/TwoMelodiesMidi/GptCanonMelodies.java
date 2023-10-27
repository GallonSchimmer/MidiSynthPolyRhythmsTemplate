package TwoMelodiesMidi;



import javax.sound.midi.*;

public class GptCanonMelodies {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException, InvalidMidiDataException {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        Sequence sequence = new Sequence(Sequence.PPQ, 24);

        Track track1 = sequence.createTrack();
        Track track2 = sequence.createTrack();

        int tick = 0;

     // Melody 1
        track1.add(createNoteEvent(60, tick, 100)); // C4
        track1.add(createNoteEvent(62, tick + 100, 100)); // D4
        track1.add(createNoteEvent(64, tick + 200, 100)); // E4
        track1.add(createNoteEvent(65, tick + 300, 100)); // F4
        track1.add(createNoteEvent(67, tick + 400, 100)); // G4
        track1.add(createNoteEvent(69, tick + 500, 100)); // A4
        track1.add(createNoteEvent(71, tick + 600, 100)); // B4
        track1.add(createNoteEvent(72, tick + 700, 100)); // C5
        // Add more notes for melody 1

        // Melody 2 (starts after a delay)
        int delayTicks = 100; // adjust this as needed
        track2.add(createNoteEvent(65, tick + delayTicks, 100)); // F4
        track2.add(createNoteEvent(67, tick + delayTicks + 100, 100)); // G4
        track2.add(createNoteEvent(69, tick + delayTicks + 200, 100)); // A4
        track2.add(createNoteEvent(70, tick + delayTicks + 300, 100)); // B4
        track2.add(createNoteEvent(72, tick + delayTicks + 400, 100)); // C5
        track2.add(createNoteEvent(74, tick + delayTicks + 500, 100)); // D5
        track2.add(createNoteEvent(76, tick + delayTicks + 600, 100)); // E5
        track2.add(createNoteEvent(77, tick + delayTicks + 700, 100)); // F5
        // Add more notes for melody 2


        
        
        sequencer.setSequence(sequence);
        sequencer.start();

        while (sequencer.isRunning()) {
            Thread.sleep(100);
        }

        sequencer.close();
    }

    public static MidiEvent createNoteEvent(int note, long tick, int velocity) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, 0, note, velocity);
        return new MidiEvent(message, tick);
    }
}
