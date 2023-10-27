package multipleTracksMidi;

import javax.sound.midi.*;

public class Simple8BitSong {
    public static void main(String[] args) throws MidiUnavailableException, InterruptedException, InvalidMidiDataException {
        Sequencer sequencer = MidiSystem.getSequencer();
        sequencer.open();

        Sequence sequence = new Sequence(Sequence.PPQ, 24);

        Track bassTrack = sequence.createTrack();
        Track melodyTrack = sequence.createTrack();
        Track drumTrack = sequence.createTrack();

        int tick = 0;

        // Set instruments
        int bassInstrument = 32; // Acoustic Bass
        int melodyInstrument = 0; // Acoustic Grand Piano

        bassTrack.add(createInstrumentEvent(bassInstrument));
        melodyTrack.add(createInstrumentEvent(melodyInstrument));

        // Bassline (using triangle waves)
        int bassNote = 36; // C2
        int bassVelocity = 80;
        for (int i = 0; i < 16; i++) {
            bassTrack.add(createNoteEvent(bassNote, tick + i * 100, bassVelocity));
        }

        // Melody (using pulse waves)
        int[] melodyNotes = {60, 62, 64, 65, 67, 69, 71, 72}; // C4 to C5
        int melodyVelocity = 100;
        for (int i = 0; i < melodyNotes.length; i++) {
            melodyTrack.add(createNoteEvent(melodyNotes[i], tick + i * 100, melodyVelocity));
        }

        // Drum track (using noise channel)
        int[] drumNotes = {35, 42}; // Bass Drum 2, Closed Hi-Hat
        int drumVelocity = 80;
        for (int i = 0; i < 16; i++) {
            drumTrack.add(createDrumEvent(drumNotes[i % 2], tick + i * 50, drumVelocity));
        }

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

    public static MidiEvent createInstrumentEvent(int instrument) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.PROGRAM_CHANGE, 0, instrument, 0);
        return new MidiEvent(message, 0);
    }
    
    public static MidiEvent createDrumEvent(int drum, long tick, int velocity) throws InvalidMidiDataException {
        ShortMessage message = new ShortMessage();
        message.setMessage(ShortMessage.NOTE_ON, 9, drum, velocity); // Channel 9 is for drums
        return new MidiEvent(message, tick);
    }
}
