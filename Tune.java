import java.util.Random;

public class Tune {

	Chord[] chords;
	Note[] melody;
	int bars;
	int beatsPerBar;
	int beatDuration;

	public Tune(int bars, int beatsPerBar, int beatDuration) {
		generateChordProgression(bars, beatsPerBar, beatDuration);
	}

	public void playTune() {

	}

	public void generateChordProgression(int bars, int beatsPerBar, int beatDuration) {
		chords = new Chord[bars*beatsPerBar];
		Random r = new Random();
		for (int bar = 0; bar < bars; bar++) {
			for (int beat = 0; beat < beatsPerBar; beat++) {
				if (beat == 0) {
					if (r.nextInt(101) <= 75) {
						chords[(bar+1) * beat] = new Chord(1, 4, 2000);
					} else {
						chords[(bar+1) * beat] = new Chord(r.nextInt(6) + 2, 4, 2000);
					}
				} else {
					chords[(bar+1) * beat] = new Chord(r.nextInt(7) + 1, 4, 2000);
				}
			}
		}
	}
}