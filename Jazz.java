import javax.sound.midi.*;

public class Jazz {

    public static void main(String[] args) {
        
        Tune myTune = new Tune(4, 4, 2000);

        for (int j = 0; j < myTune.chords.length; j = (j+1)%myTune.chords.length) {
            
            try {
                Synthesizer midiSynth = MidiSystem.getSynthesizer(); 
                midiSynth.open();
                Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
                MidiChannel[] mChannels = midiSynth.getChannels();
                midiSynth.loadInstrument(instr[0]);

                Chord myChord = myTune.chords[j];
                
                for (int i = 0; i < myChord.notes.length; i++) {
                    mChannels[0].noteOn(myChord.notes[i].pitch, 100);
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("oops");
                }
                
                mChannels[0].allNotesOff();

            } catch (MidiUnavailableException e) {

            }
        }
    }
} 