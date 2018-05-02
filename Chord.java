public class Chord {
	Note[] notes;
	int[] majorScale = {2,2,1,2,2,2,1};

	public Chord(int chordRoot, int numNotes, int duration) {
		notes = new Note[4];
		for (int noteIndex = 0; noteIndex < numNotes; noteIndex++) {
			if (noteIndex == 0) {
				notes[0] = new Note(chordRoot + 47, duration);
			} else {
				int pitch = notes[noteIndex - 1].pitch + ((majorScale[noteIndex - 1] + majorScale[noteIndex])%12);
				notes[noteIndex] = new Note(pitch, duration);
			}
		}
	}
}